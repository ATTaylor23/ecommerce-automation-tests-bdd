Feature: Duobank features

  @api
  Scenario: API to UI flow
    Given The base URI is set to "http://qa-duobank.us-east-2.elasticbeanstalk.com/api"
    And The valid body is added to the request
    When I send a POST request to endpoint "/register.php"
    Then The status code should be 200 and response payload should contain a message "You have successfully registered."
    And I navigate to the homepage
    And I enter the same credentials sent by API request
    Then I should be able to login