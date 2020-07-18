package org.example.schoology.pages.profile;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile extends ViewList {

    @FindBy(xpath = "//a[text()='Edit']")
    private WebElement clickEditBtn;

    @FindBy(xpath = "//span[@id='tab-nav-about']")
    private WebElement clickTabNavigation;

    @FindBy(xpath = "//span[@id='tab-nav-interest']")
    private WebElement clickTabInterest;

    @FindBy(xpath = "//span[@id='tab-nav-contact']")
    private WebElement clickTabContact;

    public void clickEditButton() {
        clickEditBtn.click();
    }

    public EditAboutMe clickTabAbout() {
        clickTabNavigation.click();
        return new EditAboutMe();
    }

    public EditInterestActivity clickTabInterest() {
        clickTabInterest.click();
        return new EditInterestActivity();
    }

    public EditContactInfo clickTabContact() {
        clickTabContact.click();
        return new EditContactInfo();
    }
}
