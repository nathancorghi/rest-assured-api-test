Feature: Consult user data

  Scenario: Consult information of an registered user by id
    Given I have an user already registered
    When I consult the information of user using id
    Then should return the user information correctly

  Scenario: Consult information of unregistered user by id
    Given I have an unregistered user
    When I consult the information of user using id
    Then should not return response data

  Scenario: Consult list of users by page number
    Given I have the page number 2 to consult users information
    When I consult the information of users using page number
    Then should return the users information correctly

  Scenario: Consult list of users by unexisting page number
    Given I have the page number 3 to consult users information
    When I consult the information of users using page number
    Then should not return users information