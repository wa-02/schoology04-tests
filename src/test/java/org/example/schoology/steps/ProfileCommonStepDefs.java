package org.example.schoology.steps;

import io.cucumber.java.en.And;
import org.example.core.AssertionGroup;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.profile.Profile;
import org.testng.asserts.Assertion;

public class ProfileCommonStepDefs {
    private final ScenarioContext context;

    private Profile profile;

    private final Home home;

    private final Assertion assertion;

    public ProfileCommonStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup,
                                 final ScenarioContext context, final Profile profile) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
        this.home = new Home();
        this.profile = profile;
    }

    @And("I click on Edit profile button")
    public void iClickOnEditProfileButton() {
        profile.clickEditButton();
    }

}
