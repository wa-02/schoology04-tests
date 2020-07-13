Feature: Groups

  @deleteGroup @softAssert
  Scenario: Edit a group
    Given I log in as "Instructor01" user
    When I create a group with:
      | name        | SeleniumDriver  |
      | description | Description     |
      | privacy     | School          |
      | access      | Invite Only     |
      | category    | Musical Groups  |
    When I navigate to "Groups"
    And I edit the "SeleniumDriver" group with:
      | privacy | Group           |
      | access  | Allow Requests  |
    Then I should see the "SeleniumDriver has been saved." message
