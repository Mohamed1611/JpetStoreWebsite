
@tag
Feature: Add to Cart for JpetStore Website
  
Background:
Given I landded on Jpetstore Website
  @tag1
  Scenario Outline: Positive test of Add To Cart
   Given I click on signin button
    When I login with username <name> and password <password>
    Then I land on the dashboard screen
    When I select category of product from dashboard
    And I select the product id from products page
    And I click on add to cart
    Then I land on the shopping cart page with the selected product

    Examples: 
      | name            | password    | 
      | mohamed1123     |   mohaa     |  
         
