Feature: Rate Class Functionality
  As a user of the health.com package
  I want to ensure the Rate class works correctly
  So that I can manage and display ratings properly

  Scenario: Create a Rate object and validate its properties
    Given I have a Rate object with a rate value of 4 and a message "Great service!"
    When I retrieve the rate value
    Then the rate value should be 4

    When I retrieve the rate message
    Then the rate message should be "Great service!"

    When I update the rate value to 5
    Then the rate value should be 5

    When I update the rate message to "Excellent service!"
    Then the rate message should be "Excellent service!"

    When I call the toString method
    Then the output should be "Rate [ rateMessage=Excellent service!, rateValue=5/5 ]"