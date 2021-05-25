Feature: Consult resources data

  Scenario: Consult list of resources by page number
    Given I have the page number 1 to consult resource information
    When I consult the information of resource using page number
    Then should return the resources information correctly

  Scenario: Consult list of resources by non-existent page number
    Given I have the page number 3 to consult resource information
    When I consult the information of resource using page number
    Then should not return resources information

  Scenario: Consult information of an existing resource by id
    Given I have an existing resource
    When I consult the information of resource using id
    Then should return the resource information correctly

  Scenario: Consult information of non-existent resource by id
    Given I have a non-existent resource
    When I consult the information of resource using id
    Then should not return response data
