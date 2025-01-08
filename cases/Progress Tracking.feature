Feature: Progress Tracking
  Scenario: Record weight
    Given the user is on the tracking page
    When the user records weight 70.5
    Then the weight should be recorded successfully

  Scenario: Record BMI
    Given the user is on the tracking page
    When the user records BMI 22.5
    Then the BMI should be recorded successfully

  Scenario: Record attendance
    Given the user is on the attendance page
    When the user records attendance for session "Yoga"
    Then the attendance for session "Yoga" should be recorded

  Scenario: View achievements
    Given the user is on the achievements page
    When the user views their achievements
    Then the user should see the achievement "Completed Weight Loss Program"

  Scenario: Receive badge
    Given the user has achieved "Perfect Attendance"
    When the user views their badges
    Then the user should receive the badge "Perfect Attendance"
