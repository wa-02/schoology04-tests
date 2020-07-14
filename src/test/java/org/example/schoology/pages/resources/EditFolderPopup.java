package org.example.schoology.pages.resources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class EditFolderPopup extends AbstractQuestionBankPopup {

    @FindBy(css = "input.edit-title")
    private WebElement nameTextField;

    @FindBy(css = "textArea.edit-description")
    private WebElement descriptionTextAreaField;

    @FindBy(css = "input[class='form-checkbox s-js-enable-tracking']")
    private WebElement enableQuestionTrackingCheckboxField;

    @FindBy(css = "input[id='edit-submit'][value='Save Changes']")
    private WebElement saveChangesButtonField;

    public void edit(final Map<String, String> resourceEditValueMap) {
        fillFields(resourceEditValueMap);
        saveChangesButtonField.click();
    }

    @Override
    public void setName(final String name) {
        nameTextField.clear();
        nameTextField.sendKeys(name);
    }

    @Override
    public void setDescription(final String description) {
        descriptionTextAreaField.clear();
        descriptionTextAreaField.sendKeys(description);
    }

    @Override
    public void setEnableQuestionTracking(final String condition) {
        if (Boolean.parseBoolean(condition)) {
            enableQuestionTrackingCheckboxField.click();
        }
    }
}
