Feature: Shopping cart features


  Scenario: Verify shopping cart details
    Given I am on the homepage
    When I click on a product "Blouse"
    And I increase the quantity 4 and choose the size "M" and color "White" and click on add to cart
    Then The quantity, size and color should be correct
    And The shopping cart details should be the follow:
      | Name   | Quantity | Unit Price | TotalBeforeShipping | Shipping Fee |
      | Blouse | 4       | $27.00     | $108.00              | $2.00        |


  @test
  Scenario Outline: Verify shopping cart details with multiple inputs
    Given I am on the homepage
    When I click on a product "<Name>"
    And I increase the quantity <Quantity> and choose the size "<Size>" and color "<Color>" and click on add to cart
    Then The quantity, size and color should be correct
    And The shopping cart details should be the follow:
      | Name   | Quantity   | Unit Price   | TotalBeforeShipping   | Shipping Fee   |
      | <Name> | <Quantity> | <Unit Price> | <TotalBeforeShipping> | <Shipping Fee> |

    Examples:
      | Name                        | Quantity | Unit Price | TotalBeforeShipping | Shipping Fee | Size | Color |
      | Blouse                      | 4        | $27.00     | $108.00             | $2.00        | M    | White |
      | Blouse                      | 5        | $27.00     | $135.00             | $2.00        | S    | Black |
      | Faded Short Sleeve T-shirts | 10       | $16.51     | $165.10             | $2.00        | L    | Blue  |
