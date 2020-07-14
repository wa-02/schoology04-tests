package org.example.schoology.pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class CreateCoursePopup extends AbstractCoursePopup {

    public Course create(final Map<String, String> courseMap) {
        fill(courseMap);
        action.click(submitButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#event-upcoming")));
        return new Course();
    }

}
