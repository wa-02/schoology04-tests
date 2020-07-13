Feature: Delete Course

  Scenario: Delete a course
    Given I log in as "Instructor01" user
    And I create a course with:
      | name    | SeleniumWebDelete |
      | section | New Section       |
      | area    | Mathematics       |
      | level   | Undergraduate     |
    When I navigate to "Courses"
    And I delete the "SeleniumWebDelete" course
    Then I should see the "Section New Section has been deleted." message
    