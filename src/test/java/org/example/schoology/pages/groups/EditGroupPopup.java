package org.example.schoology.pages.groups;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class EditGroupPopup extends AbstractGroupPopup {

    public Groups edit(final Map<String, String> groupMap) {
        fill(groupMap);
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.page-title")));
        return new Groups();
    }
}
