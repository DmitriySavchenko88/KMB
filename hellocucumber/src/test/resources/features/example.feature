Feature: Product list page

  Scenario: Searching a product by the input field
    Given Product list page is opened
    When customer enters a product name into the input field end press ENTER
    Then the entered product appears in the product list on the site page
