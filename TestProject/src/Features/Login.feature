#Author: kousalyakanikannan@gmail.com
Feature: Conduit Application - Login Page

  Scenario: Feeds availability after launching the application
    When Global feed only should be available after launching the application
    And I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    Then Navigate to next pages and ensure the global feeds are loaded
    And Navigate to next pages and ensure the articles which contains the popular tag are loaded

  Scenario: User can not like or comment on the article before signing up the application
    When I click on the like button before sign in, should not be able to like the feed
    And Click on the read more link
    Then A message should be displayed to Sign In Or Sign Up to add comment on article

  Scenario: Ensure the tags are displayed under Global feed and Popular tag feeds
    When Global feed only should be available after launching the application
    And Ensure the tags are displayed
    And I click on the popular tags
    Then Ensure the tags are displayed

  Scenario: Test Sign in success
    When I click on sign in button
    And Enter the correct username and password details to sign in the application
    Then Sign in should get completed successfully

  Scenario: Test Sign in failure
    When I click on sign in button
    And Enter the wrong username and password details to sign in the application
    Then Sign in should get failed with an error message

  Scenario: Test Sign up
    When I click on sign up button
    And Enter Username "Kousalya"
    And Enter Email "kousalyakanikannan@gmail.com"
    And Enter Password "testtest"
    And Click Sign Up
    Then Sign up should get completed successfully

  Scenario: 
    When I click on sign up button
    And Sign up with the existing account
    Then Email has already been taken error message should be displayed

  Scenario: Test Sign up with the special charaters
    When I click on sign up button
    And Enter Username "R#%#@%dsgsd" with the special character
    And Enter Email "kousalyakanikannan@gmail.com"
    And Enter Password "%&@%#testest" with the special character
    Then Sign up should get completed successfully

  Scenario: Test Sign up with the invalid email id
    When I click on sign up button
    And Enter Username "Kousalya"
    And Enter invalid Email id "invalid@gkjr.vj"
    And Enter Password "testestt"
    Then It should display an error message to enter correct Email

  Scenario: Enter the password with less than minimum allowed characters
    When Enter Password "test" with less tham minimum allowed characters
    Then The minimum allowed characters error message for password should be displayed
