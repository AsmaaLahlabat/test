Feature: User Management
  As an admin
  I want to manage user accounts
  So that I can add, update, deactivate accounts, approve registrations, and monitor activities

  Scenario: Add a new user
    Given the admin is on the user management page
    When the admin adds a new user with username "john_doe", password "password123", and role "Instructor"
    Then the user should be added successfully

  Scenario: Update an existing user
    Given the admin is on the user management page
    When the admin updates the user "john_doe" with new password "newpass123" and role "Client"
    Then the user details should be updated successfully

  Scenario: Deactivate a user
    Given the admin is on the user management page
    When the admin deactivates the user "john_doe"
    Then the user should be deactivated successfully

  Scenario: Approve a new instructor registration
    Given there are pending instructor registrations
    When the admin approves the registration for "new_instructor"
    Then the instructor should be approved successfully

  Scenario: Monitor user activities
    Given there are multiple users
    When the admin monitors user activities
    Then the system should display user activity statistics
