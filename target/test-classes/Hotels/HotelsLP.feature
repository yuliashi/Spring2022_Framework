Feature: Landing Page
  Background:  Given I am on hotels landing page

  Scenario: Verify destination error displayed if search with no destination
    When I click on Search button
    Then Destination Error message is displayed


  Scenario: Verify enter-children's age error is displayed as soon user add a child
    When I add a child to search field
    Then Enter-Age message is displayed


  Scenario: Verify error is NOT displayed as soon user enter's children's age
    When I add a child to search field
    And I enter 2 in child's age
    Then Enter-Age message is not displayed


  Scenario: verify numbers of travelers before and after is the same (?)
