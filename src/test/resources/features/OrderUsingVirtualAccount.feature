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

    When  User click homepage banner
    Then  User already in homepage

    When  User click search in homepage
    And   User search "Kara Minyak Goreng Kelapa 1L"
    And   User click detail product "Kara Minyak Goreng Kelapa 1L"
    And   User click add to cart in detail product page

    And   User click cart icon
    When  User click shipping type
    Then  User select shipping type "Reguler - Pilih Waktu (Gratis)"
    And   User select time "07.00 - 07.59"
    And   User click confirm

#    When  User click belanja xtra menu
#    And   User click banner shipping xtra

    When User expand the detail product
    Then Verify the total payment is correct
    And  User close the payment detail

    When User click Buy button
    Then User select virtual account as payment
    And  User click Pay Now


