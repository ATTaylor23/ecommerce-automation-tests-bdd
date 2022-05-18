Feature: Datatable types


  Scenario: Verify table
    Given I set up something
    When I pass this data as List
          | Item 1 |
          | Item 2 |
          | Item 3 |
          | Item 4 |
          | Item 5 |
    Then I should see the expected result



  Scenario: Verify table
    Given I set up something
    When I pass this data as List of Lists

      | Annie M. G. | Schmidt | 1911-03-20 |
      | Roald | Dahl | 1916-09-13 |
      | Astrid | Lindgren | 1907-11-14 |

    Then I should see the expected result



  Scenario: Verify table
    Given I set up something
    When I pass this data as List of Maps
      | firstName   | lastName | birthDate  |
      | Annie M. G. | Schmidt  | 1911-03-20 |
      | Roald       | Dahl     | 1916-09-13 |
      | Astrid      | Lindgren | 1907-11-14 |

    Then I should see the expected result



  Scenario: Verify table
    Given I set up something
    When I pass this data as Map
      | KMSY | Louis Armstrong New Orleans International Airport |
      | KSFO | San Francisco International Airport               |
      | KSEA | Seattle-Tacoma International Airport              |
      | KJFK | John F. Kennedy International Airport             |


    Then I should see the expected result



  Scenario: Verify table
    Given I set up something
    When I pass this data as Map<String, List<String>>
      | KMSY | 29.993333 | -90.258056  | 3785 |
      | KSFO | 37.618889 | -122.375000 | 1095 |
      | KSEA | 47.448889 | -122.309444 | 6402 |
      | KJFK | 40.639722 | -73.778889  | 1373 |


    Then I should see the expected result





