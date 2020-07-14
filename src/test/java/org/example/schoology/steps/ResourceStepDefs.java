package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.Internationalization;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.resources.AddQuestionBankPopup;
import org.example.schoology.pages.resources.EditFolderPopup;
import org.example.schoology.pages.resources.Resources;
import org.testng.asserts.Assertion;

import java.util.Map;

public class ResourceStepDefs {
    private final ScenarioContext context;

    private Resources resources;

    private final Home home;

    private final Assertion assertion;

    public ResourceStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup,
                          final ScenarioContext context, final Resources resources) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
        this.home = new Home();
        this.resources = resources;
    }

    @And("I add the resource Question Bank with:")
    public void iAddTheResourceWith(final Map<String, String> resourceMap) {
        String menu = Internationalization.getInstance().getValue("menuResources");
        resources = home.clickResource(menu);

        resources.clickAddResources();
        AddQuestionBankPopup questionBankPopup = resources.selectAddResourceOption("question-bank");
        questionBankPopup.create(resourceMap);
        context.setContext("ResourceKey", resourceMap.get("name"));
    }

    @When("I delete the resource {string}")
    public void iDeleteTheResource(final String resourceName) {
        resources.clickOnResourceActions(resourceName);
        resources.deleteAction();
    }

    @When("I edit the resource {string} with:")
    public void iEditResourceOptionOf(final String resourceName, final Map<String, String> resourceEditValueMap) {
        String menu = Internationalization.getInstance().getValue("menuResources");
        resources = home.clickResource(menu);

        resources.clickOnResourceActions(resourceName);
        EditFolderPopup editFolder = resources.editAction();
        editFolder.edit(resourceEditValueMap);
    }
}
