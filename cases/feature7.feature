Feature: Client Interaction

  Scenario: Send message to a single registered client
    Given the instructor is on the client interaction page
    When the instructor sends a message "Keep up the great progress!" to the client "john_doe"
    Then the message should be sent successfully

  Scenario: Send message to multiple registered clients
    Given the instructor is on the client interaction page
    When the instructor sends a message "Training session at 5 PM!" to the following clients:
      | john_doe    |
      | jane_smith  |
    Then the message should be sent to all clients successfully

  Scenario: Provide a progress report to a client
    Given the instructor is on the client interaction page
    When the instructor provides a progress report "Completion: 75%, Attendance: 90%" to the client "john_doe"
    Then the progress report should be provided successfully

  Scenario: View all messages sent to clients
    Given the instructor has sent multiple messages
    When the instructor views all messages
    Then all messages should be displayed

  Scenario: View all progress reports
    Given the instructor has provided multiple progress reports
    When the instructor views all progress reports
    Then all progress reports should be displayed
