Feature: Login Functionality

  Scenario: Login with valid credential
    Given I have a valid credential
    When I call the login API
    Then should return the token successfully