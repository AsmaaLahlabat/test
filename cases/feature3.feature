Feature: Content Management
  As an admin
  I want to manage content and user feedback
  So that I can ensure the quality and relevance of shared information

  Scenario: View all pending articles
    Given there are multiple pending articles
    When the admin views all pending articles
    Then the system should display a list of pending articles

  Scenario: Approve a pending article
    Given there is a pending article titled "Healthy Eating Tips"
    When the admin approves the article
    Then the article should be marked as approved

  Scenario: Reject a pending article
    Given there is a pending article titled "Quick Fix Diet"
    When the admin rejects the article
    Then the article should be marked as rejected

  Scenario Outline: Resolve a user complaint
    Given there is a complaint with the title "<title>"
    When the admin resolves the complaint
    Then the complaint should be marked as resolved
    Examples:
      | title                  |
      | Late Session Start     |
      | Missing Diet Plan Info |
