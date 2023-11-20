Feature: Login to demo.nopcommerce
  User wants to login to demo.nopcommerce website


  Scenario: Successful login with valid credentials
    Given User Launch chrome browser
    When User opens URL as "https://admin-demo.nopcommerce.com/login"
    And User enter Email id as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on logout button
    Then Page title should be "Your store. Login"
    And User close the browser
    
    #Scenario Outline keyword is used for datadriven and Examples is used to provide the data
    
   
    Scenario Outline: Successful login with valid credentials DataDriven Testing (DDT)
    Given User Launch chrome browser
    When User opens URL as "https://admin-demo.nopcommerce.com/login"
    And User enter Email id as "<email>" and Password as "<password>"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on logout button
    Then Page title should be "Your store. Login"
    And User close the browser
    
    Examples: 
    |email|password|
    |admin@yourstore.com|admin|
    |test@yourstore.com|admin|