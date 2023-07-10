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
Feature: Clicking on each method button on Reqres.in

  Background: User is on Reqres.in portal
    Given User Launches the chromebrowser
    And Navigates to the URL
    Then Verify the title of the page

  Scenario: Clicking on a method button
    When I click on the GET button method for List User
    Then Verify the Associate method end point for List User
    Then Verify Associated method Response for List User should be displayed
    And Verify Whether Support displayed or not Under List User

  Scenario: Clicking on a method button
    When I click on the GET button method for Single User
    Then Verify the Associate method end point for Single User
    Then Verify Associated method Response for Single User  should be displayed
    And Verify Whether Support displayed or not Under Single User

  Scenario: Clicking on a method button
    When I click on the GET button method for Single User not Found
    Then Verify the Associate method end point for Single User not Found
    Then Verify Associated method Response for Single User not Found  should be displayed
    And Verify Whether Support displayed or not Under Single User not Found

  Scenario: Clicking on a method button
    When I click on the POST button method for Create User
    Then Verify the Associate method end point for Create User
    Then Verify the Body of the request for Create User
    Then Verify Associated method Response for Create User  should be displayed
    And Verify Whether Support displayed or not Under Create User Page

  Scenario: Clicking on a method button
    When I click on the PUT button method for  Update User
    Then Verify the Associate method end point for Update User
    Then Verify the Body of the request for Update User
    Then Verify Associated method Response for Update User  should be displayed
    And Verify Whether Support displayed or not Under update User Page

  Scenario: Clicking on a method button
    When I click on the PATCH button method for  Update User partially
    Then Verify the Associate method end point for Update User User partially
    Then Verify the Body of the request for Update User User partially
    Then Verify Associated method Response for Update User User partially should be displayed
    And Verify Whether Support displayed or not Under update User User partially Page

  Scenario: Validate different available Support options to the user
    When I click on Support reqres button
    Then Verify available options
