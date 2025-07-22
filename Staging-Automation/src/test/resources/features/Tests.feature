
Feature: Funcionalidades del Sistema
  @regression
  @smoke
  Scenario: Login in Staging
    Given User is on Login page
    When Enter email and password
    Then Verify that the Dashboard page should be displayed

  @regression
  Scenario: Search Employee
    Given User is on the Employees page
    When Performs a search for "Jorge Vallejos" employee
    Then Verify that the "Jorge Vallejos" Employee should be displayed on the grid
