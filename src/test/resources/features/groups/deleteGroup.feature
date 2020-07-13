Feature: Delete Group

  Scenario: Delete a group
    Given I log in as "Instructor01" user
    And I create a group with:
      | name        | SeleniumWebDriverDelete   |
      | description | Description for deleted   |
      | privacy     | School                    |
      | access      | Invite Only               |
      | category    | Musical Groups            |
    When I navigate to "Groups"
    And I delete the "SeleniumWebDriverDelete" group