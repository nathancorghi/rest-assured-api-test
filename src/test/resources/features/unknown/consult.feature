Feature: Consult resources data

  Scenario: Consult list of resources by page number
    Given I have the page number 1 to consult resource information
    When I consult the information of resource using page number
    Then should return the resource information correctly

  Scenario: Consult list of resources by unexisting page number
    Given I have the page number 3 to consult resource information
    When I consult the information of resource using page number
    Then should not return resource information
