@tag
Feature: Registeration For Jpetstore Website
  
Background:
Given I landded on Jpetstore Website
  @tag1
  Scenario Outline: Positive test of registeration
    Given I click on signin button
    Given I click on register btn
    When enter userid
    When enter password
    When enter repeat password
    When enter first name
    When enter last name
    When enter email 
    When enter phone
    When enter address1
    When enter address2
    When enter city
    When enter state
    When enter zip
    When enter country
    When select language
    When select category
    When select language
    When enable mylist
    When enable mybanner
    And click save account information btn
    Then user registered successfully 

    #Examples: 
      #| name            | password    | 
      #| mohamed1123     |   mohaa     |  
         
