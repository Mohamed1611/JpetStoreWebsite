@tag
Feature: Signin from Jpetstore
  
Background:
Given I landded on Jpetstore Website
  @tag1
  Scenario Outline: Positive test of Signin
    Given I click on signin button
    When I login with username <name> and password <password>
    Then I land on the dashboard screen

    Examples: 
      | name            | password  | 
      | mohamed1123     | mohaa     |  
         
