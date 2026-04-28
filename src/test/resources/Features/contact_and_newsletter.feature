@ui @contact
Feature: Contact Us form and newsletter subscription
  As a visitor
  I want to contact support or subscribe to updates
  So that I can get help and receive news

  Background:
    Given I open the site "https://anupdamoda.github.io/AceOnlineShoePortal/index.html"
    And I navigate to the "Contact" page

  @contact @happy
  Scenario: Submit a valid contact request
    When I fill the contact form:
      | Name    | Priya Singh           |
      | Email   | priya.singh@test.com  |
      | Subject | Order Status          |
      | Message | Need help with order. |
    And I submit the contact form
    Then I should see a success message "Thank you" or similar

  @contact @negative
  Scenario Outline: Contact form validations
    When I fill the contact form:
      | Name    | <name>   |
      | Email   | <email>  |
      | Subject | <subject>|
      | Message | <message>|
    And I submit the contact form
    Then I should see a validation error "<error>"

    Examples:
      | name | email             | subject     | message         | error                      |
      |      | priya@test.com    | Help        | Hi              | Name is required           |
      | Priya| invalid-email     | Help        | Hi              | Enter a valid email        |
      | Priya| priya@test.com    |             | Hi              | Subject is required        |
      | Priya| priya@test.com    | Help        |                 | Message is required        |

  @newsletter
  Scenario Outline: Newsletter subscription from footer
    Given I am on the "Home" page
    When I enter "<email>" into the newsletter field
    And I click "Subscribe"
    Then I should see "<result>"

    Examples:
      | email                 | result               |
      | user+1@testmail.com   | Subscription success |
      | invalid-email         | Enter a valid email  |