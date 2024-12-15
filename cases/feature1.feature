Feature: User Login

  Scenario: Successful login as Admin
    Given the user is on the login page
    When the user enters valid credentials "admin" and "admin123"
    Then the user should be redirected to the admin dashboard

  Scenario: Successful login as Instructor
    Given the user is on the login page
    When the user enters valid credentials "trainer" and "trainer123"
    Then the user should be redirected to the instructor dashboard

  Scenario: Successful login as Client
    Given the user is on the login page
    When the user enters valid credentials "client" and "client123"
    Then the user should be redirected to the client dashboard

  Scenario Outline: Failed login
    Given the user is on the login page
    When the user enters invalid credentials "<username>" and "<password>"
    Then an error message should be displayed
    Examples:
      | username | password |
      |          | 8374     |
      | asmaa    | 234      |
      |          |          |
      | asmaa    |          |
