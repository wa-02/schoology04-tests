package org.example.schoology.pages.profile;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class EditContactInfo extends AbstractPage {

    @FindBy(css = "#edit-profile-contact-phone")
    private WebElement phoneTextField;

    @FindBy(css = "#edit-profile-contact-website")
    private WebElement websiteTextField;

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    public void edit(final Map<String, String> contactInfoMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("phone", () -> setPhone(contactInfoMap.get("phone")));
        stepsMap.put("websites", () -> setWebSites(contactInfoMap.get("websites")));

        for (final String keyField : contactInfoMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
        submitButton.click();
    }

    public void setPhone(final String phone) {
        phoneTextField.clear();
        phoneTextField.sendKeys(phone);
    }

    public void setWebSites(final String websites) {
        websiteTextField.clear();
        websiteTextField.sendKeys(websites);
    }

}
