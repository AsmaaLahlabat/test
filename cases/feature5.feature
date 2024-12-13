Feature: Subscription Management
  As an admin
  I want to manage subscription plans
  So that I can provide different levels of access to clients and instructors

  Scenario: Add a new subscription plan
    Given the admin is on the subscription management page
    When the admin adds a new subscription plan "Premium" with price "100"
    Then the subscription plan should be added successfully

  Scenario: Update an existing subscription plan
    Given the admin is on the subscription management page
    When the admin updates the plan "Premium" with new price "120"
    Then the subscription plan should be updated successfully

  Scenario: Delete a subscription plan
    Given the admin is on the subscription management page
    When the admin deletes the plan "Premium"
    Then the subscription plan should be deleted successfully
