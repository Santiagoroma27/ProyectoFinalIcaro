# language: en

Feature: Successful Login
  Scenario: Successful Login
    Given the user enters the opencart page
    When it is validated that the user is on the home page
    And the user goes to the login
    When the user enters valid credentials
    Then it is validated that the user is in their account
    And logout from account

    