Feature: Verifying MealB Expense Functionality
@smoke
  Scenario: User should be able to create an expense
    Given user navigates to MealB login page
    Then user logs in with valid credentials
    And user clicks on Add Expense button
    And user selects Meal and Entertainment option option
    And user fill out all fields on Meal and Entertainment modal window
  And user clicks on save button
  Given user verifies that newly created expense show up on expense table