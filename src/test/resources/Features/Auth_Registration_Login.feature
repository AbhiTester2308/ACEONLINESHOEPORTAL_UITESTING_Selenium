@ui @auth
Feature: User registration and login
  As a shopper
  I want to register and log in
  So that I can manage my orders and checkout faster

  Background:
    Given I open the site "https://anupdamoda.github.io/AceOnlineShoePortal/index.html"

  @registration @happy
  Scenario Outline: Successful user registration
    When I navigate to the "Register" page
    And I register with details:
      | First Name | Abhishek   |
      | Last Name  | Chauhan  |
      | Email      | acfvaley@gmail.com |
      | Password   | 123456   |
      | Confirm    |123456   |
    And I submit the registration form
    Then I should see a registration success message "Account created" or similar
    And I should be redirected to "Login" page or be logged in

    Examples:
      | first | last  | email                   | pass         |
      | Alex  | Roy   | alex.roy+1@testmail.com | P@ssw0rd123! |
      | Mira  | Das   | mira.das+2@testmail.com | P@ssw0rd123! |

  @registration @negative
  Scenario Outline: Registration validation errors
    When I navigate to the "Register" page
    And I register with details:
      | First Name | <first> |
      | Last Name  | <last>  |
      | Email      | <email> |
      | Password   | <pass>  |
      | Confirm    | <confirm> |
    And I submit the registration form
    Then I should see a validation error containing "<error>"

    Examples:
      | first | last | email              | pass       | confirm    | error                      |
       | Alex   | Roy  | alex@test.com      | P@ssw0rd1! | P@ssw0rd1! | First Name is required     |
      | Alex  |      | alex@test.com      | P@ssw0rd1! | P@ssw0rd1! | Last Name is required      |
      | Alex  | Roy  | invalid-email      | P@ssw0rd1! | P@ssw0rd1! | Enter a valid email        |
      | Alex  | Roy  | alex@test.com      | short      | short      | Password strength          |
      | Alex  | Roy  | alex@test.com      | P@ssw0rd1! | mismatch   | Passwords do not match     |

  @login @happy
  Scenario Outline: Successful login with valid credentials
    Given I navigate to the "Login" page
    When I login with email "<email>" and password "<password>"
    Then I should see my user name or a welcome message
    And the logout button should be visible

    Examples:
      | email                    | password     |
      | alex.roy+1@testmail.com | P@ssw0rd123! |

  @login @negative
  Scenario: Login fails with invalid credentials
    Given I navigate to the "Login" page
    When I login with email "wrong@user.com" and password "WrongPass!"
    Then I should see an authentication error "Invalid credentials"
    And the logout button should not be visible