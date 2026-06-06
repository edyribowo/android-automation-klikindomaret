@OrderKlikIndomaret
Feature: Order in Klik Indomaret

  @OrderVirtualAccount
  Scenario: Order in KlikIndomaret using Virtual Account
    Given User launch klik indomaret app
    When  User click skip button in initial launch
    And   User click all pop up in homepage
    Then  User already in homepage
    When  User click account menubar
    And   User click login button
    And   User input the phoneNumber "0882000983688"
    And   User click next
    And   User input the password "Admin@123"
    And   User click login
    And   User click maybe later button

