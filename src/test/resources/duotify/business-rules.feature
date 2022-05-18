Feature: Business logic and rules

@testNow
  Scenario: Verify songs table columns
    When I send a query to retrieve column names for songs table
    Then The column names should be the following
      | id         |
      | title      |
      | artist     |
      | album      |
      | genre      |
      | duration   |
      | path       |
      | albumOrder |
      | plays      |


  Scenario: Verify Unicode support
    When I update the last name of the user with the username "leon.schroeder" with "片仮名"
    Then The value should be updated correctly


  Scenario: Verify business logic for duplicates
    When I send a query to retrieve all usernames
    Then the usernames should not contain duplicates