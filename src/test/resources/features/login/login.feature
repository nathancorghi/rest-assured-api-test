Feature: Login Functionality

  Scenario: Login with valid credential
    Given I have a valid credential
    When I call the login API
    Then should return the token successfully

  Scenario: Login with invalid credential
    Given I have a invalid credential
    When I call the login API
    Then should return the message of "user not found"

  Scenario: Validate if field email is required when login
    Given I have a credential without fill field email
    When I call the login API
    Then should return the message of "Missing email or username"

  Scenario: Validate if field password is required when login
    Given I have a credential without fill field password
    When I call the login API
    Then should return the message of "Missing password"