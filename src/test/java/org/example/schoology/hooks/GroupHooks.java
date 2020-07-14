package org.example.schoology.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.core.Internationalization;
import org.example.core.ScenarioContext;
import org.example.core.ui.DriverFactory;
import org.example.schoology.pages.groups.Groups;
import org.example.schoology.pages.groups.DeleteGroupPopup;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;

public class GroupHooks {

    private ScenarioContext context;

    public GroupHooks(final ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
        // this will be executed in all the scenarios

    }

    @After(value = "@deleteGroup")
    public void deleteCourse() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        String menu = Internationalization.getInstance().getValue("menuGroups");
        SubMenu subMenu = new Home().clickMenu(menu);
        subMenu.clickViewListLink(menu);
        DeleteGroupPopup deleteGroupPopup = new Groups().clickDeleteGroup(context.getValue("GroupKey"));
        deleteGroupPopup.clickDeleteButton();
    }
}
