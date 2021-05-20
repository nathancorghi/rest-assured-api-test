Feature: Update a User Functionality

  Scenario: Update user name
    Given I have a user created
    When I call the API to update the user name
    Then should change the user name successfully

  Scenario: Update user job
    Given I have a user created
    When I call the API to update the user job
    Then should change the user job successfully