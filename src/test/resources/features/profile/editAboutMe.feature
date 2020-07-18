Feature: Profile

  @softAssert
  Scenario: Edit profile AboutMe tab
    Given I log in as "Instructor01" user
    When I navigate to right menu on "Your Profile"
    And I click on Edit profile button
    And I edit the About Me tab with:
      | subject  | Subject Test  |
      | level    | Level test    |
      | position | Position test |
      | bio      | Bio Test      |
    Then I should see the "Your profile has been updated." message