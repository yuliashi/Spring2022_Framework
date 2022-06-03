Feature: Daily Details
  @Test27
  Scenario: Verify same temperature values are displayed in the Today's data
    Given I am on darksky landing page
    When I scroll to Daily Details
    And I click on Expand Daily Details for today
    Then I verify Low Temp Header equals to the Low Temp Expandable
    And I verify High Temp Header equals to the High Temp Expandable