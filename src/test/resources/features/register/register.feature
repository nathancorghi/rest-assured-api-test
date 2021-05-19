Feature: Register Functionality

  Scenario: Register with valid credential
    Given I have a valid credential
    When I call the register API
    Then should register successfully

  Scenario: Register with invalid credential
    Given I have a invalid credential
    When I call the register API
    Then should return the message of "Note: Only defined users succeed registration"

  Scenario: Validate if field email is required when register
    Given I have a credential without fill field email
    When I call the register API
    Then should return the message of "Missing email or username"

  Scenario: Validate if field password is required when register
    Given I have a credential without fill field password
    When I call the register API
    Then should return the message of "Missing password"