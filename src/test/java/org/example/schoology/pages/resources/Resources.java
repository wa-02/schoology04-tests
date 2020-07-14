package org.example.schoology.pages.resources;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Resources extends ViewList {
    @FindBy(xpath = "//span[text()='Add Resources']/parent::div")
    private WebElement addResourcesButton;

    @FindBy(css = "div.popups-body > form > div input#edit-submit")
    private WebElement deleteConfirmationButton;

    @FindBy(css = "div.message-text")
    private WebElement messageField;

    public void clickAddResources() {
        addResourcesButton.click();
    }

    public AddQuestionBankPopup selectAddResourceOption(final String resourceOption) {
        driver.findElement(By.cssSelector(String.format("li#collection-add-%s", resourceOption))).click();
        return new AddQuestionBankPopup();
    }

    public void clickOnResourceActions(final String resourceName) {
        String xpath = String.format("//a[text()='%s']/ancestor-or-self::tr"
                + "/descendant::td[@class='collection-item-gear']/child::div", resourceName);
        driver.findElement(By.xpath(xpath)).click();
    }

    private void clickOnResourceOption(final String resourceOption) {
        String css = String.format("ul[style='display: block;'] li.action-%s", resourceOption);
        driver.findElement(By.cssSelector(css)).click();
    }

    public void deleteAction() {
        clickOnResourceOption("delete");
        deleteConfirmationButton.click();
    }

    public EditFolderPopup editAction() {
        clickOnResourceOption("edit");
        return new EditFolderPopup();
    }
}
