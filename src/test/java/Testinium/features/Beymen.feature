Feature: Beymen UI Tests

  Background:
    Given I open the "https://beymen.com" website
    When I verify that the homepage is loaded
    And I accept cookie policy button
    And I closed to gender popup

  Scenario: Perform shopping actions on Beymen.com
    And I enter the keyword into the search box from Excel (Column 1, Row 1)
    And I clear the search box
    And I enter the keyword into the search box from Excel (Column 2, Row 1)
    And I press the Enter key to search box
    And I select a random product from the search results
    And I write the product information and price to a text file
    And I add the selected product to the shopping cart
    And I compare the price on the product page with the price in the cart
    And I increase the quantity to 2 and verify it
    And I remove the product from the cart
    Then I verify that the cart is empty