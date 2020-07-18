package org.example.schoology.pages.profile;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class EditInterestActivity extends AbstractPage {

    @FindBy(css = "#edit-profile-interests-activities")
    private WebElement activitiesTextField;

    @FindBy(css = "#edit-profile-interests-interests")
    private WebElement interestsTextField;

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    public void edit(final Map<String, String> interestActMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("activities", () -> setActivity(interestActMap.get("activities")));
        stepsMap.put("interests", () -> setInterest(interestActMap.get("interests")));

        for (final String keyField : interestActMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
        submitButton.click();
    }

    public void setActivity(final String activity) {
        activitiesTextField.clear();
        activitiesTextField.sendKeys(activity);
    }

    public void setInterest(final String interest) {
        interestsTextField.clear();
        interestsTextField.sendKeys(interest);
    }
}
