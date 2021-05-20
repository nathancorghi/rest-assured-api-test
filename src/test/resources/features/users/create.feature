Feature: Create User Functionality

  Scenario: Create a new user
    Given I'm including a new user
    When I call the API for add a new user
    Then should create successful a new user