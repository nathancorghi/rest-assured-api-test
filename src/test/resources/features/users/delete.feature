Feature: Delete a User Functionality

  Scenario: Delete an existing user
    Given I have a user created
    When I call the API to delete the user
    Then should remove the user successfully