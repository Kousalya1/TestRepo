#Author: kousalyakanikannan@gmail.com
Feature: Conduit Application - Home Page

  Background: 
    Given I Sign in to the application
    And Your feed should get loaded if available

  Scenario: Like Your feed
    When Click on the like button, should be able to like the feed
    Then Click on the like button again, should be able to dislike the feed

  Scenario: Comment on Your feed
    When Click on the read more link
    And Post a comment as "Nice Article!" and ensure it is posted
    Then Delete the comment and ensure it is deleted

  Scenario: Check the Global feed
    When I click on the Global feed link
    Then Global feed should get loaded

  Scenario: Like and Dislike the Global feed
    When I click on the Global feed link
    And Global feed should get loaded
    And Click on the like button, should be able to like the feed
    Then Click on the like button again, should be able to dislike the feed

  Scenario: Global feed -> Post Comment and then delete the comment
    When I click on the Global feed link
    And Global feed should get loaded
    And Click on the read more link
    And Post a comment as "Nice Article!" and ensure it is posted
    Then Delete the comment and ensure it is deleted

  Scenario: Global Feed -> Follow and Unfollow the author in the articles
    When I click on the Global feed link
    And Global feed should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the follow button of the author and ensure you are able to follow the user
    Then On Clicking on the Unfollow button, I should be able to Unfollow the author

  Scenario: Global Feed -> Navigate to the author's articles page from the articles in the Global feed
    When I click on the Global feed link
    And Global feed should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the my articles link of the author
    Then I should be able to view the articles of the author if available

  Scenario: Global Feed -> Like and Dislike the author's articles in the author profile page
    When I click on the Global feed link
    And Global feed should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the my articles link of the author
    And Click on the like button, should be able to like the feed
    Then Click on the like button again, should be able to dislike the feed

  Scenario: Global Feed -> Post Comment and then delete the comment on the author's articles in the author profile page
    When I click on the Global feed link
    And Global feed should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the my articles link of the author
    And Click on the read more link
    And Post a comment as "Nice Article!" and ensure it is posted
    Then Delete the comment and ensure it is deleted

  Scenario: Global Feed -> Check the author's favourite articles in the author profile page
    When I click on the Global feed link
    And Global feed should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the favourite articles link
    Then I should be able to view the favourite articles of the author if available

  Scenario: Global Feed -> Like and Dislike the author's favourite articles in the author profile page
    When I click on the Global feed link
    And Global feed should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the favourite articles link
    And Click on the like button, should be able to like the feed
    Then Click on the like button again, should be able to dislike the feed

  Scenario: Global Feed -> Post Comment and then delete the comment on the author's favourite articles in the author profile page
    When I click on the Global feed link
    And Global feed should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the favourite articles link
    And Click on the read more link
    And Post a comment as "Nice Article!" and ensure it is posted
    Then Delete the comment and ensure it is deleted

  Scenario: Global Feed -> Navigate to next page
    When I click on the Global feed link
    And Global feed should get loaded
    Then Navigate to next pages and ensure the global feeds are loaded

  Scenario: Global Feed -> Ensure the tags are displayed under Global feed
    When I click on the Global feed link
    And Global feed should get loaded
    And Ensure the tags are displayed

  Scenario: Global Feed -> Ensure the tags are displayed under My articles and Favourite articles section in the author's profile
    When I click on the Global feed link
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the my articles link of the author
    And Ensure the tags are displayed
    And Click on the favourite articles link
    Then Ensure the tags are displayed

  Scenario: Global Feed -> Ensure the published date for articles is displayed
    When I click on the Global feed link
    And Global feed should get loaded
    And Ensure the published dates are displayed for articles

  Scenario: Click on the popular tags in Home page and verify
    When I click on the popular tags
    Then The respective articles which contains the popular tag should get loaded

  Scenario: Popular tag -> Like and Dislike the article loaded with the popular tag in Home page
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Click on the like button, should be able to like the feed
    Then Click on the like button again, should be able to dislike the feed

  Scenario: Popular tag -> Post Comment and then delete it in the article loaded withe the popular tag in the read more article page
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Click on the read more link
    And Post a comment as "Nice Article!" and ensure it is posted
    Then Delete the comment and ensure it is deleted

  Scenario: Popular tag -> Follow and Unfollow the author in the article loaded with the popular tag
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the follow button of the author and ensure you are able to follow the user
    And On Clicking on the Unfollow button, I should be able to Unfollow the author

  Scenario: Popular tag -> Navigate to the author's articles page from the article loaded withe the popular tag
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the my articles link of the author
    Then I should be able to view the articles of the author if available

  Scenario: Popular tag -> Like and Dislike the author's articles in the author profile page
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the my articles link of the author
    And Click on the like button, should be able to like the feed
    Then Click on the like button again, should be able to dislike the feed

  Scenario: Popular tag -> Post Comment and then delete it in the author's articles in the author profile page
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the my articles link of the author
    And Click on the read more link
    And Post a comment as "Nice Article!" and ensure it is posted
    Then Delete the comment and ensure it is deleted

  Scenario: Popular tag -> Check the author's favourite articles in the author profile page
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the favourite articles link
    Then I should be able to view the favourite articles of the author if available

  Scenario: Popular tag -> Like and Dislike the author's favourite articles in the author profile page
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the favourite articles link
    And Click on the like button, should be able to like the feed
    Then Click on the like button again, should be able to dislike the feed

  Scenario: Popular tag -> Post Comment and then delete it in the author's favourite articles in the author profile page
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the favourite articles link
    And Click on the read more link
    And Post a comment as "Nice Article!" and ensure it is posted
    Then Delete the comment and ensure it is deleted

  Scenario: Popular Tag -> Navigate to next page
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    Then Navigate to next pages and ensure the articles which contains the popular tag are loaded

  Scenario: Popular Tag -> Ensure the tags are displayed under Popular Tag articles
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Ensure the tags are displayed

  Scenario: Popular Tag -> Ensure the tags are displayed under My articles and Favourite articles section in the author's profile
    When I click on the popular tags
    And Click on the authorname in an article and ensure you are navigated to author's profile
    And Click on the my articles link of the author
    And Ensure the tags are displayed
    And Click on the favourite articles link
    Then Ensure the tags are displayed

  Scenario: Popular Tag -> Ensure the published date for articles is displayed
    When I click on the popular tags
    And The respective articles which contains the popular tag should get loaded
    And Ensure the published dates are displayed for articles
