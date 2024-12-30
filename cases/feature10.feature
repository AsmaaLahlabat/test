Feature: Client Account Management
  As a client
  I want to create and customize my profile
  So that I can manage my personal details and fitness goals

  Scenario: Successfully create a profile with valid details
    Given the client is on the account management page
    When the client enters valid personal details "ali", "25", "Weight Loss", "No Dietary Restrictions"
    Then the system should display "Profile created successfully"

  Scenario: Attempt to create a profile with invalid age
    Given the client is on the account management page
    When the client enters invalid age "-5"
    Then the system should display an error message "Error: Invalid age input."

  Scenario: Attempt to create a profile with missing details
    Given the client is on the account management page
    When the client submits the profile with missing details
    Then the system should display an error message "Error: Missing required fields."

  Scenario: Update dietary preferences in the profile
    Given the client is on the account management page
    And the client enters valid personal details "ali", "30", "Muscle Gain", "Vegetarian"
    When the client updates dietary preferences to "Vegan"
    Then the system should display "Profile updated successfully"

  Scenario: View the profile details
    Given the client is on the account management page
    And the client enters valid personal details "ahmad", "28", "Flexibility", "Gluten Free"
    When the client views their profile
    Then the system should display "Name: ahmad, Age: 28, Goal: Flexibility, Preferences: Gluten Free"
