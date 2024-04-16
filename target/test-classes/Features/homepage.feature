Feature: Home page

Background:
    Given Application url completely launched and user is on the home page
    
    Scenario: Select dropdown
 When user select the dropdown for sort by price: high to low
 Then validate that prices of products gets sorted by high to low order