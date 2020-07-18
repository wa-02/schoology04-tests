package org.example.schoology.steps;

import io.cucumber.java.en.And;
import org.example.schoology.pages.profile.EditAboutMe;
import org.example.schoology.pages.profile.Profile;

import java.util.Map;

public class AboutMeStepDefs {

    private Profile profile;

    public AboutMeStepDefs(final Profile profile) {

        this.profile = profile;
    }

    @And("I edit the About Me tab with:")
    public void iEditTheAboutMeTabWith(final Map<String, String> aboutMeMap) {
        EditAboutMe editAbout = profile.clickTabAbout();
        editAbout.edit(aboutMeMap);
    }
}
