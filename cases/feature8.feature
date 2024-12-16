Feature: Progress Tracking
  As an instructor
  I want to monitor client progress and send motivational reminders
  So that I can keep clients motivated and track their progress

  Scenario: Monitor client progress with available reports
    Given the instructor is on the progress tracking page
    When the instructor selects to monitor client progress
    Then the system should display all client progress reports

  Scenario: Monitor client progress when no reports are available
    Given the instructor is on the progress tracking page
    And no progress reports are available
    When the instructor selects to monitor client progress
    Then the system should display a message indicating no reports

  Scenario: Send a motivational reminder to a specific client
    Given the instructor is on the progress tracking page
    When the instructor sends a motivational reminder to "Client1" with message "Keep up the great work!"
    Then the system should confirm that the reminder was sent successfully

  Scenario: Send a motivational reminder to a non-existent client
    Given the instructor is on the progress tracking page
    When the instructor sends a motivational reminder to "UnknownClient" with message "You can do it!"
    Then the system should display an error indicating client not found
