Feature: Time Machine

  Scenario: Verify the current date is highlighted in Time Machine's calendar
    Given I am on darksky landing page
    When I scroll to the Time Machine button
    And I click on Time Machine button
    Then I verify Current date is highlighted


