Feature: Delete Resources

  @deleteResource @softAssert
  Scenario: Edit a Question Bank
    Given I log in as "Instructor01" user
    And I add the resource Question Bank with:
      | name                     | My Question Bank  |
      | description              | Brief description |
      | enable Question Tracking | false             |
    When I edit the resource "My Question Bank" with:
      | name                     | My Question Bank           |
      | description              | Brief description updated  |
      | enable Question Tracking | true                       |
    Then I should see the "Your changes have been saved." message
