package org.example.schoology.pages.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class AddQuestionBankPopup extends AbstractQuestionBankPopup {

    @FindBy(css = "input#edit-title")
    private WebElement nameTextField;

    @FindBy(css = "textArea#edit-description")
    private WebElement descriptionTextAreaField;

    @FindBy(css = "input#edit-enable-tracking")
    private WebElement enableQuestionTrackingCheckboxField;

    @FindBy(css = "input[id='edit-submit'][value='Create']")
    private WebElement createButtonField;

    public Resources create(final Map<String, String> questionBankValuesMap) {
        fillFields(questionBankValuesMap);
        createButtonField.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".messages .message-text")));

        return new Resources();
    }


    public void setName(final String name) {
        nameTextField.sendKeys(name);
    }

    public void setDescription(final String description) {
        descriptionTextAreaField.sendKeys(description);
    }

    public void setEnableQuestionTracking(final String condition) {
        if (Boolean.parseBoolean(condition)) {
            enableQuestionTrackingCheckboxField.click();
        }
    }
}
