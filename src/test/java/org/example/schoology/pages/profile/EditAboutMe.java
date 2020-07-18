package org.example.schoology.pages.profile;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class EditAboutMe extends AbstractPage {

    @FindBy(css = "#edit-profile-about-subjects-taught")
    private WebElement subjectTextField;

    @FindBy(css = "#edit-profile-about-grades-taught")
    private WebElement levelTextField;

    @FindBy(css = "#edit-profile-about-position")
    private WebElement positionTextField;

    @FindBy(css = "#edit-profile-about-bio")
    private WebElement bioTextField;

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    public void edit(final Map<String, String> aboutMeMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("subject", () -> setSubject(aboutMeMap.get("subject")));
        stepsMap.put("level", () -> setLevel(aboutMeMap.get("level")));
        stepsMap.put("position", () -> setPosition(aboutMeMap.get("position")));
        stepsMap.put("bio", () -> setBio(aboutMeMap.get("bio")));

        for (final String keyField : aboutMeMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
        submitButton.click();
    }

    public void setSubject(final String subject) {
        subjectTextField.clear();
        subjectTextField.sendKeys(subject);
    }

    public void setLevel(final String level) {
        levelTextField.clear();
        levelTextField.sendKeys(level);
    }

    public void setPosition(final String position) {
        positionTextField.clear();
        positionTextField.sendKeys(position);
    }

    public void setBio(final String bio) {
        bioTextField.clear();
        bioTextField.sendKeys(bio);
    }
}
