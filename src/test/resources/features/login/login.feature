Feature: Login Functionality

  Scenario: Login with valid credential
    Given I have a valid credential
    When I call the login API
    Then should return the token successfully

  Scenario: Login with invalid credential
    Given I have a invalid credential
    When I call the login API
    Then should return the message of user not found