package org.example.schoology.pages.Discussions;

/**
 * @author Benjamin Huanca on 7/14/2020.
 * @version 1.0
 */

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Discussions extends AbstractPage {
    public static final String XPATH_UPDATE_TEXT = "//a[text()='%s']";
    public static final String DELETE_BUTTON = "//div[@class='submit-buttons']/child::span";

    @FindBy(css = "span.create-new")
    private WebElement createDiscussionButton;

    @FindBy(css = "a.discussion-title")
    private WebElement discussionName;

    @FindBy(css = "a.delete-discussion")
    private WebElement deleteDiscussionButton;

    public CreateDiscussion createDiscussion() {
        return new CreateDiscussion();
    }

    public CreateDiscussion clickAddDiscussionButton() {
        createDiscussionButton.click();
        return new CreateDiscussion();
    }

    public String getDiscussionName(final String updateName) {
        WebElement updatedText = driver.findElement(By.xpath(String.format(XPATH_UPDATE_TEXT, updateName)));
        return updatedText.getText();
    }

    public boolean resourceItemExist(final String resourceName) {
        return action.isElementDisplayedOnScreen(By.cssSelector("a.discussion-title"));
    }

    public Discussion joinDiscussion() {

        discussionName.click();
        return new Discussion();
    }

    public void deleteDiscussionClick() {
        deleteDiscussionButton.click();
    }

    public void clickDeleteDiscussionButton() {
        WebElement deleteButton = driver.findElement(By.xpath(DELETE_BUTTON));
        deleteButton.click();
    }

    public boolean discussionDeleted() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#popups-0")));
        return true;
    }
}
