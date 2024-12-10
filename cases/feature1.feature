Feature: User Login
  Scenario: Successful login
    Given the user is on the login page
    When the user enters valid credentials "admin" and "admin123"
    Then the user should be redirected to the dashboard

  Scenario: Failed login
    Given the user is on the login page
    When the user enters invalid credentials "user1" and "wrongpassword"
    Then an error message should be displayed
