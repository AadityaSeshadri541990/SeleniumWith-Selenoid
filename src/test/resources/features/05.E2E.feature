@E2E
Feature: End to End Execution
  Background:
    Given User Navigates to Landing Page of Ilex
      | http://ilex-fe-2107524456.ap-southeast-1.elb.amazonaws.com/#/ | ilex UI |
    And User Login to Ilex with valid credentials
      #|Username|Password|
      | abc@comp.com | password |
    When Click on Administration from Navigation Bar
    Then Click on My Network


  Scenario:E2E
    When User navigated to My Network homepage
    And Click Add Contact button
    Then Add New Contact Window Will popup
    And User Enters Contact Fields
      #|First Name|Last Name|Title|Company|Country|Email|Office Number|Mobile Number|
      | Automation | Testing | QA | Palo | Albania | Test@test.com | +65 123 | +65 456 |
    Then User clicks on create button
    When Click on Administration from Navigation Bar
    And Click on My Loans
    When User Able to see Loan Details Page in My Loans
    Then Enter Loan Details
      # |Borrower Name|Parent Name|Borrower Country|Guarantor Name|Industry|Country of risk|Public Rating|Internal Rating|Target Issuance Date|Purpose|Deal Description|
      | Test Automation Team | QA | Indonesia | Testing | Chemicals, Plastics & Rubber | Indonesia | AAA | AAA| 2021-April-20 | Real Estate Finance | Dry Test |Singapore Airlines Ltd|
    And Followed by Adding Tranches to it
      #|Currency|Amount|Maturity Date|Repayment Type|Facility Type|Seniority Type|Distrubution Method|Margin|Commitment Fee|
      | SVC | 104 | 2021-March-22 | Bullet | Other | Senior | Syndication | 12 | 1000 |
    Then User Clicks on List button
    And Order Saved with Expected Message
      |Generic Success Message!|
    When Click on Administration from Navigation Bar
    Then Click on My Network
    When Click on Order Capture from Navigation Bar
    Then Able to see Buy/Sell Options in Order Capture Page
    When User Clicks on Buy button
    Then Validate IOI and Req Radio Buttons
    When Select IOI
    Then Enter Order Capture Informations for IOI
           # |IOIName|GoodUntil      |Borrower      | Industry                                                      |RiskCountry            |Purpose                                  |MinSpread|MaxSpread|FacilityType|MinTicket|MaxTicket|Currency                    |MinTenor|MaxTenor|TransferType                                                     |Seniority  |MarketType     |GreenLoans       |Security    |ECA  |
      |Submit| IOI1  | 2021-March-10 |              | Chemicals, Plastics & Rubber/Paper & Packaging/Transportation | Australia/Singapore | Real Estate Finance| 100 | 200 | Term Loan A | 10 | 25 | SGD | 3 | 5 | Unfunded risk participation/Disclosed funded risk participation | Mezzanine | Primary only | Green loans only | Unsecured | ECA-backed loans only |
    And Enter Matching Preference for IOI
      #|ParentCountry|InvestorType|Filter Out CounterParties|
      | Puerto Rico | Asset Manager | Counterparty 1 |
    Then User clicks on Submit Order
    And Order Submitted with Expected Message
     #|Expected Submitted Message|
      |Generic Success Message!|
    When Click on Order Capture from Navigation Bar
    Then Able to see Buy/Sell Options in Order Capture Page
    When User clicks on the Sell button
    Then Validate SEC and Req Radio Buttons
    And Select SEC
    And Select Asset
      # | Asset Value   |
      | Sing OTHERSVC104mApr20 |
    Then Validate Loan Information
      |Singapore Airlines Ltd | 310780Testing | Chemicals, Plastics & Rubber | AU | TERM_LOAN_A | REAL_ESTATE_FINANCE | 22/03/2021 | 104 | 12 |
    And Enter Trade Informations for SEC
      #|All-in spread (indication)|Size (indication) (USD)|Min. Ticket (indication) (USD)|Invitation valid until|Target closing date|
      | 100 | 50 | 5 | 2020-March-10 | 2021-April-11 |
    Then User clicks on Submit Order
    And Order Submitted with Expected Message
      |Generic Success Message!|
