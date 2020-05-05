Feature: Listing

  Background: 
    Given User Navigates to Landing Page of Ilex
      | http://ilex-fe-2107524456.ap-southeast-1.elb.amazonaws.com/#/ | Ilex UI |
    And User Login to Ilex with valid credentials
      #|Username|Password|
      | abc@comp.com | password |
    When Click on Administration from Navigation Bar
    And Click on My Loans

  @List123
  Scenario: Add Loan Details followed by Listing Tranche
    When User Able to see Loan Details Page in My Loans
    Then Enter Loan Details
      # |Borrower Name|Parent Name|Borrower Country|Guarantor Name|Industry|Country of risk|Public Rating|Internal Rating|Target Issuance Date|Purpose|Deal Description|
      | Singapore Airlines Ltd | QA | Indonesia | Testing | Chemicals, Plastics & Rubber | Indonesia | AAA | AAA | 2021-April-20 | Real Estate Finance | Dry Test |
     And Followed by Adding Tranches to it
      #|Currency|Amount|Maturity Date|Repayment Type|Facility Type|Seniority Type|Distrubution Method|Margin|Commitment Fee|
      | SVC | 104 | 2021-March-22 | Bullet | Term Loan A | Senior | Syndication | 12 | 1000 |
    Then User Clicks on List button
    And Order Saved with Expected Message
      |Generic Success Message!|
    Then User Logout from Ilex

  #|Expected Msg|
  @List
  Scenario: Add Loan Details followed by Deleting Tranche
    When User Able to see Loan Details Page in My Loans
    Then Enter Loan Details
      # |Borrower Name|Parent Name|Borrower Country|Guarantor Name|Industry|Country of risk|Public Rating|Internal Risk|Target Issuance Date|Purpose|Deal Description|
      | Singapore Airlines Ltd | QA | Indonesia | Testing | Chemicals, Plastics & Rubber | Indonesia | AAA | AAA | 2021-April-20 | Real Estate Finance | Dry Test |
    And Followed by Adding Tranches to it
      #|Currency|Amount|Maturity Date|Repayment Type|Facility Type|Seniority Type|Distrubution Method|Margin|Commitment Fee|
      | SVC | 100 | 2021-March-22 | Bullet | Term Loan A | Senior | Syndication | 12 | 1000 |
    Then User Clicks on Delete button
    And Tranche Deletion  Msg
      #|Expected Msg|
      | You have not created any tranches yet. |
    Then User Logout from Ilex  

  @List
  Scenario: Mandatory Field Checks
    When User Able to see Loan Details Page in My Loans
    Then Scroll down to Tranche by skipping Loan Details
    Then User Clicks on List button
    And User can validate Mandatory check Msg
      #|Mandatory check Msg|
      | Borrower name | Borrower country | Industry | Country of risk | Purpose | Currency | Repayment type | Facility type | Seniority type | Distrubution method |
    Then User Logout from Ilex
