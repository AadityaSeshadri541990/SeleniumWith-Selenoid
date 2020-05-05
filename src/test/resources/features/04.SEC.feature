@SEC
Feature: ID -101 Secondary Sell Down

   @SellDown 
  Scenario: Successful loan
    Given User Navigates to Landing Page of Ilex
      | http://ilex-fe-2107524456.ap-southeast-1.elb.amazonaws.com/#/ | Ilex UI |
    #|http://localhost:9000/|Ilex UI|
    And User Login to Ilex with valid credentials
      #|Username|Password|
      | abc@comp.com | password |
    When Click on Administration from Navigation Bar
    And Click on My Loans
    When User Able to see Loan Details Page in My Loans
    Then Enter Loan Details
      # |Borrower Name|Parent Name|Borrower Country|Guarantor Name|Industry|Country of risk|Public Rating|Internal Rating|Target Issuance Date|Purpose|Deal Description|
      | Test Automation Team | QA | Indonesia | Testing | Chemicals, Plastics & Rubber | Australia | AAA | AAA | 2021-April-20 | Real Estate Finance | Dry Test | Singapore Airlines Ltd |
    And Followed by Adding Tranches to it
      #|Currency|Amount|Maturity Date|Repayment Type|Facility Type|Seniority Type|Distrubution Method|Margin|Commitment Fee|
      | SGD | 104 | 2021-March-22 | Bullet | Term Loan A | Senior | Syndication | 12 | 1000 |
    Then User Clicks on List button
    And Order Saved with Expected Message
      | Generic Success Message! |
    And Validate the Asset Name
      #|Expected Value|
      | Sing TERM_LOAN_ASGD104mApr2021 |

  # @ID101SD
  @SellDown
  Scenario: Save Draft
    Given User Navigates to Landing Page of Ilex
      | http://ilex-fe-2107524456.ap-southeast-1.elb.amazonaws.com/#/ | Ilex UI |
    #|http://localhost:9000/|Ilex UI|
    And User Login to Ilex with valid credentials
      #|Username|Password|
      | abc@comp.com | password |
    Then Click on Order Capture from Navigation Bar
    And Able to see Buy/Sell Options in Order Capture Page
    When User clicks on the Sell button
    Then Validate SEC and Req Radio Buttons
    And Select SEC
    And Select Created Asset
    Then Validate Loan Information
      | Singapore Airlines Ltd | 310780Testing | Chemicals, Plastics & Rubber | AU | TERM_LOAN_A | REAL_ESTATE_FINANCE | 22/03/2021 | 104 | 12 |
    Then User clicks on Save Draft on SEC
    And Order Saved with Expected Message
      | Generic Success Message! |

  # @ID101_1 @ID100_2 @ID100_3
  @SellDown
  Scenario: Successful Submit
    Given User Navigates to Landing Page of Ilex
      | http://ilex-fe-2107524456.ap-southeast-1.elb.amazonaws.com/#/ | Ilex UI |
    #|http://localhost:9000/|Ilex UI|
    And User Login to Ilex with valid credentials
      #|Username|Password|
      | abc@comp.com | password |
    Then Click on Order Capture from Navigation Bar
    And Able to see Buy/Sell Options in Order Capture Page
    When User clicks on the Sell button
    Then Validate SEC and Req Radio Buttons
    And Select SEC
    And Select Created Asset
    Then Validate Loan Information
      | Singapore Airlines Ltd | 310780Testing | Chemicals, Plastics & Rubber | AU | TERM_LOAN_A | REAL_ESTATE_FINANCE | 22/03/2021 | 104 | 12 |
    And Enter Trade Informations for SEC
      #|All-in spread (indication)|Size (indication) (USD)|Min. Ticket (indication) (USD)|Invitation valid until|Target closing date|
      | 100 | 50 | 5 | 2020-March-10 | 2021-April-11 |
    # And Enter Matching Preferences for SEC
    #|Parent Country|Investor Type|Filter Out CounterParties|
    #| Indonesia | ASSET_MANAGER | Counterparty 1 |
    Then User clicks on Submit Order
    And Order Submitted with Expected Message
      | Generic Success Message! |
