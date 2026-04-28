@ui @pdp
Feature: Product detail page (PDP) and reviews
  As a shopper
  I want to view detailed product info and reviews
  So that I can choose the right shoe

  Background:
    Given I open the site "https://anupdamoda.github.io/AceOnlineShoePortal/index.html"
    And I navigate to the "Men" catalog page

  @pdp @images
  Scenario: PDP shows images, price, sizes, and add-to-cart
    When I open the first product from the listing
    Then I should see the product title
    And I should see the main image and at least 1 thumbnail
    And I should see the price with currency symbol
    And I should see available sizes
    And I should see an "Add to Cart" button enabled for selectable sizes

  @pdp @variant
  Scenario Outline: Selecting size and color updates availability
    When I open a product named "<productName>"
    And I select size "<size>"
    And I select color "<color>"
    Then the "Add to Cart" button should be "<state>"

    Examples:
      | productName     | size | color | state   |
      | Running Breeze  | 9    | Black | enabled |
      | Running Breeze  | 6    | Red   | enabled |

  @reviews
  Scenario: Reviews section displays and can be sorted
    When I scroll to "Reviews" section
    Then I should see overall rating (stars) and review count
    When I sort reviews by "Most Recent"
    Then the top review date should be the most recent among visible reviews

  @reviews @negative
  Scenario: Adding a review requires login
    When I click "Write a review"
    Then I should be prompted to log in or see a login/register modal