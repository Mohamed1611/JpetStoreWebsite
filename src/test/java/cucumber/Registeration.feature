@tag
Feature: Registeration For Jpetstore Website
  
Background:
Given I landded on Jpetstore Website
  @tag1
  Scenario: Positive test of registeration
    Given I click on signin button
    And I click on register btn
    And enter userid
    And enter password
    And enter repeat password
    And enter first name
    And enter last name
    And enter email
    And enter phone
    And enter address1
    And enter address2
    And enter city
    And enter state
    And enter zip
    And enter country
    And select language
    And select category
    And select language
    And enable mylist
    And enable mybanner
    When click save account information btn
    Then user registered successfully 

    #Examples: 
      #| name            | password    | 
      #| mohamed1123     |   mohaa     |  
         
