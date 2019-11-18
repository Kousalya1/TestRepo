#Author: kousalyakanikannan@gmail.com
Feature: Conduit Application - New Post Page

  Background: 
    Given I Sign in to the application
    And Your feed should get loaded if available
    And Click on New post link
    Then New post page should get loaded successfully

  Scenario: Create New post
    When I enter the title "Java" for an article
    And Write the description "Learn Java" of an article
    And Write the body "Java is a Object oriented programming language" in detail
    And Mention the tags "#Java #learn"
    And Click on the Publish Article button
    Then The article should get published

  Scenario: Click on Publish article button without entering any details and verify the error messages
    When Click on the Publish Article button
    Then The mandatory error messages should be displayed for the title, description and body

  Scenario: Enter only the title and click on Publish article button
    When I enter the title "Java" for an article
    And Click on the Publish Article button
    Then The mandatory error messages should be displayed for description and body

  Scenario: Enter only the title and description and then click on Publish article button
    When I enter the title "Java" for an article
    And Write the description "Learn Java" of an article
    And Click on the Publish Article button
    Then The mandatory error messages should be displayed only for body

  Scenario: Edit and Delete Article
    When I click on edit article button
    And New post page should get loaded successfully
    And Edit the title "Selenium"
    And Edit the description "Learn Selenium"
    And Edit the body "Selenium is one of the most popular automated testing suites."
    And Edit the tags "#Selenium #learn"
    And Click on the Publish Article button
    Then The article should get published
    And On deleting the article, it should get deleted successfully

  Scenario: Post Comment and Delete it
    When I enter the title "Java" for an article
    And Write the description "Learn Java" of an article
    And Write the body "Java is a Object oriented programming language" in detail
    And Mention the tags "#Java #learn"
    And Click on the Publish Article button
    And Post a comment as "Nice Article!!!!" and ensure it is posted
    Then Delete the comment and ensure it is deleted

  Scenario: Check the Placeholders in the New post page
    When I check the placeholder of title, description, body, tags
    Then The placeholders should be displayed properly in New post page

  Scenario: Create new post with the special characters in all the fields
    When I enter the title "@#$hjfds" for an article with the special characters
    And Write the description "#$@#%jhfkshf" of an article with the special characters
    And Write the body "$%#^hdfha" in detail with the special characters
    And Mention the tags "%#jgg" with the special characters
    And Click on the Publish Article button
    Then The article should get published
