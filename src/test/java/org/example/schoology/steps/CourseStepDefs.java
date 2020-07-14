package org.example.schoology.steps;

import java.util.Map;

import io.cucumber.java.en.And;
import org.example.core.AssertionGroup;
import org.example.core.Internationalization;
import org.example.core.ScenarioContext;
import org.example.core.ui.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.courses.Courses;
import org.example.schoology.pages.courses.CreateCoursePopup;
import org.example.schoology.pages.courses.DeleteCoursePopup;
import org.example.schoology.pages.courses.EditCoursePopup;
import org.testng.asserts.Assertion;

public class CourseStepDefs {

    private final ScenarioContext context;

    private final Home home;

    private final Assertion assertion;

    public CourseStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup,
                          final ScenarioContext context) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
        this.home = new Home();
    }

    @And("I create a course with:")
    public void iCreateACourseWith(final Map<String, String> datatable) {
        String menu = Internationalization.getInstance().getValue("menuCourses");
        SubMenu subMenu = home.clickMenu(menu);
        subMenu.clickViewListLink(menu);
        CreateCoursePopup createCoursePopup = new Courses().clickCreateCourseButton();
        createCoursePopup.create(datatable);
        context.setContext("CourseKey", datatable.get("name"));
    }

    @And("I edit the {string} course with:")
    public void iEditTheCourseWith(final String name, final Map<String, String> datatable) {
        EditCoursePopup editCoursePopup = new Courses().clickEditCourse(name);
        editCoursePopup.edit(datatable);
    }

    @And("I should see the {string} section on {string} course item")
    public void iShouldSeeTheSectionOnCourseItem(final String expectedSection, final String courseName) {
        assertion.assertEquals(expectedSection, new Courses().getSectionByName(courseName));
    }

    @And("I delete the {string} course")
    public void iDeleteTheCourse(final String courseName) {
        DeleteCoursePopup deleteCoursePopup = new Courses().clickDeleteCourse(courseName);
        deleteCoursePopup.clickDeleteButton();
    }

    @And("I delete the {string} inactive course")
    public void iDeleteTheInactiveCourse(final String courseName) {
        DeleteCoursePopup deleteCoursePopup = new Courses().clickDeleteInactiveCourse(courseName);
        deleteCoursePopup.clickDeleteButton();
    }
}
