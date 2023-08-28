@Smoke
Feature: Retail Account page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'Qudsia.yousefzai@tekschool.us' and password 'Qudsia@7869916'
    And User click on login button
    Then User should be logged in into Account
    When User click on Account option

  @updateProfileInfo
  Scenario: Verify User can update Profile Information
    And User update Name "Guardianss" and Phone "phoneNumber"
    And User click on Update button
    Then user profile information should be updated

  @addPaymentMethod
  Scenario: Verify User can add a payment method
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | cardNumber | Chase      |              12 |           2024 |          656 |
    And User click on Add your card button
    Then a message should be displayed "Payment Method added sucessfully"

  @editCard
  Scenario: Verify User can edit Debit or Credit card
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | cardNumber | Chase      |              10 |           2025 |          698 |
    And user click on Update Your Card button
    Then message should be displayed 'Payment Method updated Successfully'

  @removeCard
  Scenario: Verify User can remove Debit or Credit card
    And User click on remove option of card section
    Then payment details should be removed

  @addAddress
  Scenario: Verify User can add an Address
    And User click on Add address option
    And user fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | countryValue | fullnameValue | PhoneValue  | stAddress     | aptValue | cityValue | stateValue | zipCodeValue |
    And User click Add Your Address button
    Then the message should be displayed 'Address Added Successfully'

  @editAddress
  Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And user edit new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | United States | QudsiaAhmadi | phoneNumber  | 3456     | 111 | ElkGrove | California | zipcode |
    And User click update Your Address button
    Then messages should be displayed 'Address Updated Successfully'
    
    @removeAddrsFromAcct
    Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed
