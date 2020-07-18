Feature: Profile

  @softAssert
  Scenario: Edit Contact Information tab
    Given I log in as "Instructor01" user
    When I navigate to right menu on "Your Profile"
    And I click on Edit profile button
    And I edit the Contact Information tab with:
      | phone    | 4450356896   |
      | websites | website test |
    Then I should see the "Your profile has been updated." message