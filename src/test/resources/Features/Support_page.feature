#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@UI
Feature: Verify the reqres support page
  I want to use this template to test Support page

  Background: User is on Reqres.in portal
    Given User Launches the chromebrowser
    And Navigates to the URL
    Then Verify the title of the page
    Then User Clicks on Support reqres button

  @UI
  Scenario: Verify the different options available for Support
    Given User is on Support Page
    Then validate different available options
