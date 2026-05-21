@home_navigation
Feature: Home page and global navigation
  As a shopper
  I want to land on the home page and use the global navigation
  So that I can reach key sections of the site easily

  Background:
    Given I am a guest user
    And I open the site "https://anupdamoda.github.io/AceOnlineShoePortal/index.html"

  @smoke
  Scenario: Home page loads with key UI elements
    Then I should see the site logo
    And I should see a search box
    And I should see the top navigation menu with items:
      | Home | Men | Women | Kids | Sports | Contact |
    And I should see the cart icon with count "0"

  @nav
  Scenario Outline: Navigate to top-level sections
    When I click the "<menuItem>" menu item
    Then I should land on the "<expectedUrlFragment>" page
    And the page title should contain "<expectedTitle>"

    Examples:
      | menuItem | expectedUrlFragment | expectedTitle     |
      | Home     | index               | Ace Online Shoe   |
      | Men      | men                 | Men               |
      | Women    | women               | Women             |
      | Kids     | kids                | Kids              |
      | Sports   | sports              | Sports            |
      | Contact  | contact             | Contact           |

  @footer
  Scenario: Footer links exist and are clickable
    Then I should see footer links:
      | About Us | Privacy Policy | Terms | Help |
    When I click the "About Us" footer link
    Then I should land on a page containing "About" in heading

  @responsive
  Scenario Outline: Responsive menu renders on smaller screens
    Given I set viewport to width "<width>" and height "<height>"
    Then the burger menu "<shouldBeVisible>" be visible
    When the viewport is narrow the menu collapses

    Examples:
      | width | height | shouldBeVisible |
      | 375   | 667    | should          |
      | 768   | 1024   | should          |
      | 1280  | 800    | should not      |