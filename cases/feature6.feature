Feature: Instructor Program Management
  As an instructor
  I want to manage fitness programs and add materials
  So that I can organize training effectively for clients

  Scenario: Add a new fitness program
    Given the instructor is on the program management page
    When the instructor adds a program with title "Strength Training", duration "4 Weeks", level "Advanced", goals "Build Muscle", price "70", and materials "Video Tutorials"
    Then the program should be added successfully

  Scenario: Update an existing fitness program
    Given the instructor is on the program management page
    When the instructor updates the program "Yoga Basics" with duration "3 Weeks", level "Intermediate", goals "Flexibility & Strength", price "40", and materials "Video & Images"
    Then the program should be updated successfully

  Scenario: Delete a fitness program
    Given the instructor is on the program management page
    When the instructor deletes the program "HIIT Workout"
    Then the program should be deleted successfully
