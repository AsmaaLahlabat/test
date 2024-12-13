Feature: User Login
  Scenario: Successful login
    Given the user is on the login page
    When the user enters valid credentials "admin" and "admin123"
    Then the user should be redirected to the dashboard

  Scenario Outline: Failed login
    Given the user is on the login page
    When the user enters invalid credentials "<username>" and "<password>"
    Then an error message should be displayed
    Examples:
      | username |password|
      |          | 8374   |
      | asmaa    | 234    |
      |          |        |
      | asmaa    |        |