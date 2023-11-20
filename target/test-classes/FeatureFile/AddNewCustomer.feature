Feature: Customer addition


Scenario: Add New Customer
    Given User Launch chrome browser
    When User opens URL as "https://admin-demo.nopcommerce.com/login"
    And User enter Email id as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User clicks on customer menu
    And clicks on customer menu item
    And Clicks on Add new button
    Then user can view Add new customer page
    When user enter the customer info
    And clicks on save button
    Then user can view confirmation message "The new customer has been added successfully."
    And User close the browser
    	
    	
    	
    Scenario: Search customer by Email
    
    Given User Launch chrome browser
    When User opens URL as "https://admin-demo.nopcommerce.com/login"
    And User enter Email id as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User clicks on customer menu
    And clicks on customer menu item
    And Enter customer mail id
    When User click on search button
    Then user should found mail id in the search table
    And User close the browser
    
    
    Scenario: Search customer by Name
    
    Given User Launch chrome browser
    When User opens URL as "https://admin-demo.nopcommerce.com/login"
    And User enter Email id as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User clicks on customer menu
    And clicks on customer menu item
    And Enter customer FirstName
    And Enter customer LastName
    When User click on search button
    Then user should found name in the search table.
    And User close the browser
    