Feature: Profile

  @softAssert
  Scenario: Edit InterestsActivities tab
    Given I log in as "Instructor01" user
    When I navigate to right menu on "Your Profile"
    And I click on Edit profile button
    And I edit the Interests Activities tab with:
      | activities  | new activity Test  |
      | interests    | new interest test    |
    Then I should see the "Your profile has been updated." message