package org.example.schoology.pages.groups;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Groups extends ViewList {

    public static final String GROUP_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::li//div[@href='#']";
    public static final String SELECT_ACTIONS = "//a[text()='%s']/ancestor::li//ul//li[@class='action-edit']";
    public static final String DELETE_ACTIONS = "//a[text()='%s']/ancestor::li//ul//li[@class='action-delete']";
    public static final String GROUP_BY_NAME = "//a[text()='%s']";

    @FindBy(xpath = "//a[@href='/groups/new']")
    private WebElement createGroupButton;

    public CreateGroupPopup clickCreateGroupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createGroupButton));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", createGroupButton);

        return new CreateGroupPopup();
    }

    public EditGroupPopup clickEditGroup(final String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName)));
        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        wait.until(ExpectedConditions.elementToBeClickable(groupActionsButton));
        groupActionsButton.click();
        driver.findElement(By.xpath(String.format(SELECT_ACTIONS, groupName))).click();
        return new EditGroupPopup();
    }

    public String getGroupByName(final String groupName) {
        return driver.findElement(By.xpath(String.format(GROUP_BY_NAME, groupName))).getText();
    }

    public DeleteGroupPopup clickDeleteGroup(final String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName)));
        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", groupActionsButton);

        wait.until(ExpectedConditions.visibilityOf(groupActionsButton));
        groupActionsButton.click();
        driver.findElement(By.xpath(String.format(DELETE_ACTIONS, groupName))).click();
        return new DeleteGroupPopup();
    }

}
