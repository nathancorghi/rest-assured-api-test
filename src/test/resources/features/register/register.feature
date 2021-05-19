Feature: Register Functionality

  Scenario: Register with valid credential
    Given I have a valid credential
    When I call the register API
    Then should register successfully

  Scenario: Register with invalid credential
    Given I have a invalid credential
    When I call the register API
    Then should return the message of "Note: Only defined users succeed registration"