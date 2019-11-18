#Author: kousalyakanikannan@gmail.com
Feature: Conduit Application - Settings Page

  Background: 
    Given I Sign in to the application
    And Your feed should get loaded if available
    And Click on Settings link
    Then Settings page should get loaded successfully

  Scenario: Check the Placeholders in Settings page
    When I check the placeholder of URL of profile picture, Username, Short bio, Email, and Password
    Then The placeholders should be displayed properly in Settings page

  Scenario: Click on Update Settings button without entering any details and verify the error messages
    When Click on the Update Settings button
    Then The mandatory error messages should be displayed for Email and Username

  Scenario: Enter only the Email and click on Update Settings button
    When Enter Email "test@gmail.com"
    And Click on the Update Settings button
    Then The mandatory error messages should be displayed for Username

  Scenario: Update the settings by entering all the details
    When I enter URL "https://images.app.goo.gl/Dxz8gpyaPtGHPFWS7" of the profile picture
    And Enter Username "Test username"
    And Enter Short bio "Test bio" about you
    And Enter Email "test@gmail.com"
    And Enter Password "testtesttest"
    And Click on the Update Settings button
    Then The settings should get updated

  Scenario: Edit the settings by entering all the details
    When I edit URL "https://images.app.goo.gl/Dxz8gpyaPtGHPFWS7" of the profile picture
    And Edit Username "Test username"
    And Edit Short bio "Test bio" about you
    And Edit Email "test@gmail.com" in the settings page
    And Edit Password "testtesttest"
    And Click on the Update Settings button
    Then The settings should get updated

  Scenario: Update the setting with the Special characters in all the field
    When I enter URL "https://images.app.goo.gl/Dxz8gpyaPtGHPFWS7" of the profile picture
    And Enter Username "R#%#@%dsgsd" with the special character
    And Enter Short bio "#$^#$^hhd" about you with the special character
    And Enter Email "%#$^$#6@gmail.com" in the settings page with the special character
    And Enter Password "%&@%#testest" with the special character
    And Click on the Update Settings button
    Then The settings should get updated

  Scenario: Edit the password with less than minimum allowed characters
    When Edit Password "test" with less tham minimum allowed characters
    Then The minimum allowed characters error message for password should be displayed

  Scenario: Logout
    When I click on logout
    Then I should get logged out of the application
