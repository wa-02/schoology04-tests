package org.example.schoology.steps;

import io.cucumber.java.en.And;
import org.example.schoology.pages.profile.EditInterestActivity;
import org.example.schoology.pages.profile.Profile;

import java.util.Map;

public class InterestsActivitiesStepDef {

    private Profile profile;

    public InterestsActivitiesStepDef(final Profile profile) {
        this.profile = profile;
    }

    @And("I edit the Interests Activities tab with:")
    public void iEditTheInterestsActivitiesTabWith(final Map<String, String> aboutMeMap) {
        EditInterestActivity editInterestAct = profile.clickTabInterest();
        editInterestAct.edit(aboutMeMap);

    }
}
