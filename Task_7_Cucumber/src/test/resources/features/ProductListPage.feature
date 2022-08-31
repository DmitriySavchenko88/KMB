Feature: Check Product list page functionality

  Background: Product list page is opened
    Given Product list page is opened

  Scenario: Searching a product by the input field

    When customer enters a product name into the input field end press ENTER
    Then the entered product appears in the product list on the site page

  Scenario Outline: User clicks product category on the header on the product list page
    When the user clicks <category>
    Then the page displays <title>
    Examples:
      | category     | title        |
      | Film Cameras | Film Cameras |
      | Webcams      | Webcams      |


  Scenario: Test the valid login using DataTable
    Given Sign in form is opened
    When Users enters the information as follows
      | Email         | Pass   |
      | rewq@mail.com | 471666 |
    And Click on the LogIn button
    Then My Account button is displayed on the Main page