@login
  Feature: login functionality

    Background:
      Given I am on the login page

    Scenario: Login attempt without credentials
      When I click the login button
      Then I should see the error message "Epic sadface: Username is required"

    Scenario: Login attempt with valid username and wrong password
      Given I enter username "standard_user"
      And I enter password "wrong_password"
      When I click the login button
      Then I should see the error message "Epic sadface: Username and password do not match any user in this service"

    Scenario: Login attempt with invalid username and valid password
      Given I enter username "invalid_user"
      And I enter password "secret_sauce"
      When I click the login button
      Then I should see the error message "Epic sadface: Username and password do not match any user in this service"
