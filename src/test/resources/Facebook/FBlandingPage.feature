Feature: Facebook landing page

  Background:
    Given I am on facebook landing page
  #facebook.com
  #Launch facebook.com
  #Click on Facebook Pay, Oculus, Instagram, Portal and Bulletin
  #Close ALL windows except Instagram
  #Verify number of window-Handles is 1
  #Verify Page Title is Instagram
  #Verify Log in button on Instagram is disabled by default

  Scenario: Verify Instagram button is disabled by default
  when called from facebook.com landing page
    When I click on Facebook Pay
     And I click on Oculus
     And I click on Instagram
     And I click on Portal
     And I click on Bulletin
     And I close ALL windows except Instagram
    Then I verify the number of windows equals to 1


