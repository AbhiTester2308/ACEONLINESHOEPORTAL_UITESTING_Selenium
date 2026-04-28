@ui @catalog
Feature: Browse, search, filter and sort products
  As a shopper
  I want to find shoes quickly
  So that I can make a purchase decision efficiently

  Background:
    Given I open the site "https://anupdamoda.github.io/AceOnlineShoePortal/index.html"
    And I am on the "Men" catalog page

  @search
  Scenario Outline: Keyword search returns relevant results
    When I search for "<keyword>"
    Then I should see a results header containing "<keyword>"
    And each listed product name or description should contain "<keyword>" at least once

    Examples:
      | keyword  |
      | running  |
      | sneaker  |
      | leather  |

  @filter
  Scenario: Filter by category and price range
    When I apply filters:
      | Category | Sports      |
      | PriceMin | 1000        |
      | PriceMax | 3000        |
      | Size     | 9           |
      | Color    | Black       |
    Then the results should only include products in "Sports"
    And every product price should be between 1000 and 3000 inclusive
    And every product size should include "9"
    And at least one color chip should be "Black"

  @sort
  Scenario Outline: Sort results by price and popularity
    When I sort the results by "<sortOption>"
    Then the product list should be ordered "<order>" by "<metric>"

    Examples:
      | sortOption     | order | metric      |
      | Price: Low-High| asc   | price       |
      | Price: High-Low| desc  | price       |
      | Popularity     | desc  | popularity  |

  @pagination
  Scenario: Pagination works across multiple pages
    Given the results show page "1"
    When I click "Next" page
    Then I should see page "2"
    And the product cards should update (no duplicates from page 1)