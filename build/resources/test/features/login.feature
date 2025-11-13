@login
  Feature: login functionality

    Background:
      Given I am on the login page

    Scenario: Login attempt without credentials
      When I click the login button
      Then I should see the error message "Epic sadface: Username is required"