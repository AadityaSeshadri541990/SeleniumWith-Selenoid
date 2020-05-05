@IOI
Feature: ID -100 Indication of Interest

  Background: 
    Given User Navigates to Landing Page of Ilex
      | http://ilex-fe-2107524456.ap-southeast-1.elb.amazonaws.com/#/ | Ilex UI |
    And User Login to Ilex with valid credentials
      #|Username|Password|
      | abc@comp.com | password |
    When Click on Administration from Navigation Bar
    Then Click on My Network
    When Click on Order Capture from Navigation Bar
    Then Able to see Buy/Sell Options in Order Capture Page
    When User Clicks on Buy button
    Then Validate IOI and Req Radio Buttons

 # @ID100_9 @ID100_1 @ID100_2 @ID100_3
 @IOI
  Scenario: Successful Submit
    When Select IOI
    Then Enter Order Capture Informations for IOI
      # |IOIName|GoodUntil      |Borrower      | Industry                                                      |RiskCountry            |Purpose                                  |MinSpread|MaxSpread|FacilityType|MinTicket|MaxTicket|Currency                    |MinTenor|MaxTenor|TransferType                                                     |Seniority  |MarketType     |GreenLoans       |Security    |ECA  |
      | Submit | IOI1 | 2021-March-10 |  | Chemicals, Plastics & Rubber/Paper & Packaging/Transportation | Australia/Singapore | Real Estate Finance| 100 | 200 | Term Loan B | 10 | 25 | SGD | 3 | 5 | Unfunded risk participation/Disclosed funded risk participation | Mezzanine | Primary only | Green loans only | Unsecured | ECA-backed loans only |
    And Enter Matching Preference for IOI
      #|ParentCountry|InvestorType|Filter Out CounterParties|
      | Puerto Rico | Asset Manager | Counterparty 1 |
    Then User clicks on Submit Order
    And Order Submitted with Expected Message
      #|Expected Submitted Message|
      | Generic Success Message! |
      

  # @ID100_6
   @IOI
  Scenario: Mandatory Field Check when Save
    When User Clicks on Buy button
    Then Validate IOI and Req Radio Buttons
    And Select IOI
    Then User clicks on Save Draft on IOI
    Then Validate Mandatory Fields
    |Name|

 # @ID100_SD
  @IOI
  Scenario:Mandatory Field Check when Submitted
    When User Clicks on Buy button
    Then Validate IOI and Req Radio Buttons
    And Select IOI
    Then User clicks on Submit Order
    Then Validate Mandatory Fields
      |Industry|Country of risk|Name|Min spread|Max spread|Min ticket size|Max ticket size|Min tenor|Max tenor|


 # @ID100_7
  @IOI
  Scenario: Save Draft
    When Select IOI
    Then Enter Order Capture Informations for IOI
      | Draft | IOI1 |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
    Then User clicks on Save Draft on IOI
    And Order Saved with Expected Message
      #|Expected Message|
      | Generic Success Message! |

 # @ID100SD
  @IOI
  Scenario: Validate Borrower Industry and Country of Risk
    When User Clicks on Buy button
    Then Validate IOI and Req Radio Buttons
    And Select IOI
    When Enter Borrower name from Refinitiv
      | Singapore Airlines Ltd |
  #  Then Validate Industry Auto Populated and Non-Editable
   # |Industry|Transportation|
  #  And Validate Country of Risk Auto Populated and Non-Editable
  #    | Country of risk | Singapore |

