Feature: Consult user data

  Scenario: Consult information of an registered user by id
    Given I have an user already registered
    When I consult the information of user using id
    Then should return the user information correctly

  Scenario: Consult information of unregistered user by id
    Given I have an unregistered user
    When I consult the information of user using id
    Then should not return any information of user