package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import org.example.core.AssertionGroup;
import org.example.core.Internationalization;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.groups.Groups;
import org.example.schoology.pages.groups.EditGroupPopup;
import org.example.schoology.pages.groups.CreateGroupPopup;
import org.example.schoology.pages.groups.DeleteGroupPopup;
import org.testng.asserts.Assertion;

public class GroupStepDefs {

    private final ScenarioContext context;

    private Assertion assertion;

    public GroupStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup,
                         final ScenarioContext context, final Groups groups) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
    }

    @And("I create a group with:")
    public void iCreateAGroupWith(final Map<String, String> datatable) {
        String menu = Internationalization.getInstance().getValue("menuGroups");
        SubMenu subMenu = new Home().clickMenu(menu);
        subMenu.clickViewListLink(menu);
        CreateGroupPopup createGroupPopup = new Groups().clickCreateGroupButton();
        createGroupPopup.create(datatable);
        context.setContext("GroupKey", datatable.get("name"));
    }

    @And("I edit the {string} group with:")
    public void iEditTheGroupWith(final String name, final Map<String, String> datatable) {
        EditGroupPopup editGroupPopup = new Groups().clickEditGroup(name);
        editGroupPopup.edit(datatable);
    }

    @And("I should see a group with {string} as a name")
    public void iShouldSeeAGroupWithAsName(final String groupName) {
        assertion.assertEquals(groupName, new Groups().getGroupByName(groupName));
    }

    @And("I delete the {string} group")
    public void iDeleteTheGroup(final String groupName) {
        DeleteGroupPopup deleteGroupPopup = new Groups().clickDeleteGroup(groupName);
        deleteGroupPopup.clickDeleteButton();
    }
}
