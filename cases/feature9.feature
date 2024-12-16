Feature: Notifications and Updates
  As an instructor
  I want to notify clients about schedule changes and announce new programs
  So that clients stay informed and updated

  Scenario: Send notification about schedule changes
    Given the instructor is on the notifications and updates page
    When the instructor sends a notification "Schedule has been updated for Yoga Basics"
    Then all clients should receive the notification

  Scenario: Announce new programs or offers
    Given the instructor is on the notifications and updates page
    When the instructor announces "New Weight Loss Program available with 20% discount"
    Then all clients should receive the announcement

  Scenario: Invalid choice in Notifications menu
    Given the instructor is on the notifications and updates page
    When the instructor selects an invalid option
    Then an invalid option error message should be displayed
