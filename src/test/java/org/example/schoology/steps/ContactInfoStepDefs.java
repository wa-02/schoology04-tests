package org.example.schoology.steps;

import io.cucumber.java.en.And;
import org.example.schoology.pages.profile.EditContactInfo;
import org.example.schoology.pages.profile.Profile;

import java.util.Map;

public class ContactInfoStepDefs {

    private Profile profile;

    public ContactInfoStepDefs(final Profile profile) {
        this.profile = profile;
    }

    @And("I edit the Contact Information tab with:")
    public void iEditTheContactInformationTabWith(final Map<String, String> contactInfoMap) {
        EditContactInfo editContactInfo = profile.clickTabContact();
        editContactInfo.edit(contactInfoMap);
    }
}
