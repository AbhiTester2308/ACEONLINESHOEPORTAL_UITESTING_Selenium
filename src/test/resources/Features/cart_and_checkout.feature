@ui @cart @checkout
Feature: Shopping cart and checkout
  As a shopper
  I want to add items to cart and complete checkout
  So that I can purchase my shoes

  Background:
    Given I open the site "https://anupdamoda.github.io/AceOnlineShoePortal/index.html"
    And I am on the "Men" page

  @cart @add
  Scenario: Add a product to cart from PDP
    When I open the first product from the listing
    And I select an available size
    And I click "Add to Cart"
    Then the cart count should increase by 1
    And a mini cart or toast should confirm the addition

  @cart @update
  Scenario: Update quantity and remove item in cart page
    Given I open the cart page
    When I increase the quantity of the first line item to "2"
    Then the line item subtotal should update correctly
    And the cart total should reflect the change
    When I remove the item
    Then the cart should be empty
    And I should see "Your cart is empty"

  @checkout @happy
  Scenario Outline: Successful guest checkout with valid details
    Given the cart has at least one item
    When I proceed to checkout
    And I enter shipping details:
      | Full Name | <name>        |
      | Address   | <address>     |
      | City      | <city>        |
      | State     | <state>       |
      | Zip       | <zip>         |
      | Phone     | <phone>       |
      | Email     | <email>       |
    And I select payment method "Card"
    And I enter card details:
      | Number | <card>     |
      | Expiry | <expiry>   |
      | CVV    | <cvv>      |
    And I place the order
    Then I should see an order confirmation with an order number

    Examples:
      | name       | address          | city   | state | zip   | phone       | email                  | card             | expiry | cvv |
      | Abhi K     | 221B Baker St    | Noida  | UP    | 201301| 9999999999  | abhi.k+1@testmail.com   | 4111111111111111 | 12/28  | 123 |

  @checkout @negative
  Scenario: Checkout errors for invalid payment
    Given the cart has at least one item
    When I proceed to checkout
    And I enter shipping details with required fields missing
    And I select payment method "Card"
    And I enter an invalid card number "123456789012"
    And I attempt to place the order
    Then I should see validation errors for missing required fields
    And I should see a payment error "Invalid card number"

  @promo
  Scenario Outline: Apply and validate promo codes
    Given the cart has at least one item
    When I open the cart page
    And I apply promo code "<code>"
    Then I should see "<resultMessage>"
    And the total should "<totalChange>" compared to pre-discount

    Examples:
      | code      | resultMessage        | totalChange |
      | SAVE10    | Promo applied        | decrease    |
      | INVALID50 | Invalid promo code   | not change  |