Feature: Program Exploration and Enrollment
  Scenario: Filter programs by difficulty level
    Given the user is on the programs page
    When the user selects difficulty level "Beginner"
    Then the filtered programs for "Beginner" should be displayed

  Scenario: Filter programs by focus area
    Given the user is on the programs page
    When the user selects focus area "Weight Loss"
    Then the filtered programs for "Weight Loss" should be displayed

  Scenario: Enroll in a program
    Given the user is on the programs page
    When the user enrolls in the "Weight Loss" program
    Then the user should see the "Weight Loss" program schedule

  Scenario: View program schedule
    Given the user is enrolled in the "Weight Loss" program
    When the user views the "Weight Loss" program schedule
    Then the user should see the schedule details
