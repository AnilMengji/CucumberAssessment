@API
Feature: Testing GET API

  Scenario: Testing GET request and storing response in a file
    Given I have a GET API endpoint
    When I send a GET request
    Then I should receive a successful response
    And I store the response in a file
    Then Compare Actual and expected Response files

  Scenario: Creating a user with user details
    Given I have a request to create a user
    When I send a POST request with user details
    Then I should receive a successful response with status code 201
