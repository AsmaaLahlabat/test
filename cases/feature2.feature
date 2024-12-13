Feature: Program Monitoring
  As an admin
  I want to monitor fitness programs
  So that I can analyze their performance and generate reports

  Scenario: View all programs
    Given there are multiple programs
    When the admin views all programs
    Then the system should display a list of all programs

  Scenario: View the most popular program
    Given there are multiple programs
    When the admin views the most popular program
    Then the system should display the program with the highest enrollments

  Scenario Outline: Add a new program
    Given the admin wants to add a new program
    When the admin adds a program with title "<title>", enrollments "<enrollments>", and attendance "<attendance>"
    Then the program should be added to the list
    Examples:
      | title          | enrollments | attendance |
      | Pilates Basics | 40          | 35         |
      | HIIT Workout   | 60          | 50         |
