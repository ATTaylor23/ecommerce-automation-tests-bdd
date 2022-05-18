Feature: Homepage related functionalities

@jenkins
  Scenario: Verify homepage products names
    Given I am on the homepage
    Then The promoted products should be the following
      | Faded Short Sleeve T-shirts |
      | Blouse                      |
      | Printed Dress               |
      | Printed Dress               |
      | Printed Summer Dress        |
      | Printed Summer Dress        |
      | Printed Chiffon Dress       |
#    Cucumber Datatable is a convenient way to pass a set of
#    data into a SINGLE step


  @fail
  Scenario: Verify homepage products details
    Given I am on the homepage
    When I click on a product "Blouse"
    Then The product details should be the following as list of lists
      | Name   | Price | Model  | Condition | Compositions | Styles | Properties   |
      | Blouse | $27.00 | demo_2 | New       | Cotton       | Casual | Short Sleeve |




  Scenario: Verify homepage products details using list of maps
    Given I am on the homepage
    When I click on a product "Blouse"
    Then The product details should be the following as list of Maps
      | Name   | Price | Model  | Condition | Compositions | Styles | Properties   |
      | Blouse | $27.00 | demo_2 | New       | Cotton       | Casual | Short Sleeve |


  Scenario Outline: Verify homepage products details with multiple products
    Given I am on the homepage
    When I click on a product "<product>"
    Then The product details should be the following as list of Maps
      | Name      | Price   | Model   | Condition   | Compositions | Styles | Properties |
      | <product> | <price> | <model> | <condition> | <material>   | <type> | <mode>     |

    Examples:
      | product                     | price  | model  | condition | material  | type   | mode           |
      | Faded Short Sleeve T-shirts | $16.51 | demo_1 | New       | Cotton    | Casual | Short Sleeve   |
      | Blouse                      | $27.00 | demo_2 | New       | Cotton    | Casual | Short Sleeve   |
      | Printed Dress               | $26.00 | demo_3 | New       | Cotton    | Girly  | Colorful Dress |
      | Printed Dress               | $50.99 | demo_4 | New       | Viscose   | Dressy | Short Dress    |
      | Printed Summer Dress        | $28.98 | demo_5 | New       | Viscose   | Casual | Maxi Dress    |
      | Printed Summer Dress        | $30.50 | demo_6 | New       | Polyester | Girly  | Short Dress   |
      | Printed Chiffon Dress       | $16.40 | demo_7 | New       | Polyester | Girly  | Midi Dress    |