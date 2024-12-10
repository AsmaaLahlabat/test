Feature: Program Monitoring
  As an admin
  I want to monitor fitness programs
  So that I can analyze their performance and generate reports

  Scenario: View most popular program
    Given there are multiple programs
    When the admin views the most popular program
    Then the system should display the program with the highest enrollments

  Scenario: Generate attendance report
    Given there are multiple programs
    When the admin generates an attendance report
    Then the system should display a report with program names and attendance

  Scenario: View all programs
    Given there are multiple programs
    When the admin views all programs
    Then the system should display a list of all programs

  Scenario: Add a new program
    Given the admin wants to add a new program
    When the admin adds a program with title "Pilates Basics", enrollments "40", and attendance "35"
    Then the program should be added to the list
