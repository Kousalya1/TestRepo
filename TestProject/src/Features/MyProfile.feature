#Author: kousalyakanikannan@gmail.com
Feature: Conduit Application - My Profile Page

  Background: 
    Given I Sign in to the application
    And Your feed should get loaded if available
    And Click on My Profile link
    Then My Profile page should get loaded successfully

  Scenario: Check the Profile picture, Username and Bio
    When I check for the profile picture, Username and Bio
    Then The Profile picture should be displayed
    And The Username and Bio should be displayed

  Scenario: Check My Articles
    When I click on My Articles link
    Then My articles should get loaded

  Scenario: My Articles -> Like and Dislike My articles
    When I click on My Articles link
    And My articles should get loaded
    And Click on the like button, should be able to like the feed
    Then Click on the like button again, should be able to dislike the feed

  Scenario: My Articles -> Post Comment and then delete the comment
    When I click on My Articles link
    And My articles should get loaded
    And Click on the read more link
    And Post a comment as "Nice Article!!!!" and ensure it is posted
    Then Delete the comment and ensure it is deleted

  Scenario: Favourite Articles -> Check my favourite articles
    When Click on the favourite articles link
    Then I should be able to view my favourite articles if available

  Scenario: Favourite Articles -> Like and Dislike my favourite articles
    When Click on the favourite articles link
    And My favourite articles page should get loaded
    And Click on the like button, should be able to like the feed
    Then Click on the like button again, should be able to dislike the feed

  Scenario: Favourite Articles -> Post Comment and then delete it in my favourite articles page
    When Click on the favourite articles link
    And My favourite articles page should get loaded
    And Click on the read more link
    And Post a comment as "Nice Article!" and ensure it is posted
    Then Delete the comment and ensure it is deleted

  Scenario: Edit Profile settings by entering all the details
    When I click on the Edit profile settings button
    And Settings page should get loaded successfully
    And I enter URL "https://images.app.goo.gl/Dxz8gpyaPtGHPFWS7" of the profile picture
    And Enter Username "Test2 username"
    And Enter Short bio "Test2 bio" about you
    And Enter Email "test2#gmail.com"
    And Enter Password "test2test2test"
    And Click on the Update Settings button
    Then The settings should get updated

  Scenario: Ensure the tags are displayed under My articles and Favourite articles
    When I click on My Articles link
    And Ensure the tags are displayed
    And Click on the favourite articles link
    Then Ensure the tags are displayed

  Scenario: Ensure the published date for articles is displayed
    When I click on My Articles link
    And Ensure the published dates are displayed for articles
    And Click on the favourite articles link
    Then Ensure the published dates are displayed for articles
