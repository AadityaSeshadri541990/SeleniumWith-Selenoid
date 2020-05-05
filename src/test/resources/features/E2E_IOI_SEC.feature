Feature: IOI_SEC_EndtoEndExecution

  @End2End
  Scenario Outline: Submit IOI Order
    Given User Navigates to Login Page of Ilex
    And User Login to Ilex with Buyer credentials
    When Click on Order Capture from Navigation Bar
    Then Able to see Buy/Sell Options in Order Capture Page
    When User Clicks on Buy button
    Then Validate IOI and Req Radio Buttons
    When Select IOI
    Then Enter Order Capture Informations for IOI "<Status>""<IOICreateName>""<GoodUntil>""<Borrower>""<Industry>""<RiskCountry>""<Purpose>""<MinSpread>""<MaxSpread>""<FacilityType>""<MinTicket>""<MaxTicket>""<Currency>""<MinTenor>""<MaxTenor>""<TransferType>""<Seniority>""<MarketType>""<GreenLoans>""<Security>""<ECA>"
    Then User Submits IOI Order
    Then User Logout from Ilex
    Given User Navigates to Login Page of Ilex
    And User Login to Ilex with seller credentials
    When Click on Order Capture from Navigation Bar
    When User clicks on the Sell button
    Then Validate SEC and Req Radio Buttons
    And Select SEC
    And Clicks and Create Asset Name
    When User Able to see Loan Details Page in My Loans
    Then Enter Loan Details MEngine "<Borrower Name>""<Parent Name>""<Borrower Country>""<Guarantor Name>""<Industry>""<Country of risk>""<Public Rating>""<Internal Rating>""<Target Issuance Date>""<Purpose>""<Deal Description>"
    And Followed by Adding Tranches to it "<Currency>""<Amount>""<Maturity Date>""<Repayment Type>""<Facility Type>""<Seniority Type>""<Distrubution Method>""<Margin>"
    Then User Clicks on List button
    And Order Saved with Expected Message "<Listing Success Message>"
    And Capture generated Tranche Name
    #And Click on the Back Button
    When Click on Order Capture from Navigation Bar
    Then Able to see Buy/Sell Options in Order Capture Page
    When User Clicks on Buy button
    And Click on Order Capture
    When User clicks on the Sell button
    Then Validate SEC and Req Radio Buttons
    And Select SEC
    And Select Asset Value
    And Enter Trade Informations for SEC "<All-in spread (indication)>""<Size (indication) (USD)>""<Min. Ticket (indication) (USD)>""<Invitation valid until>""<Target closing date>"
    Then User clicks on Submit Order
    Then Validate Investor Selection page for Buyer Name"<BuyerName>"Seller Name"<SellerName>"
    And Validate Status as Shortlisted
    And Validate BorrowerName"<Borrower Name>"TrancheName OrderType as Secondary
    Then Click on Investor and Invite
    Then Toggle LoanInformation and Trade Information
    And Enter Comments in Invitation to Buy "<InvitationtoBuy_Comments>"
    And Click InvitetoBuy
    And Validate Status as Invited
    Then User Logout from Ilex
#######-------------Deal Invitation----------
    Given User Navigates to Login Page of Ilex
    And User Login to Ilex with Buyer credentials
    And Click on Dashboard and Invitation
    And Select First Row from IOI Deal Invitation
    Then Enter InterestSize "<DealInvitation_InterestSize>" Level of Interest "<DealInvitation_InterestLevel>" EstimatedDecisionDate "<DealInvitation_Decision>"
    And Click on NDA and Accept Invitation
    Then User Logout from Ilex
    Given User Navigates to Login Page of Ilex
    And User Login to Ilex with seller credentials
    And Click on Dashboard and Deals
    Then Select First Sell Deal
    Then Validate Investor Selection page for Buyer Name"<BuyerName>"Seller Name"<SellerName>"
    And Validate Status as Accepted
    And Click Button to get to Onboard Page
    Then Click on Onboard
#######-------------Dealing Room Buyer Bid----------
    Given User Navigates to Login Page of Ilex
    And User Login to Ilex with Buyer credentials
    And Click on Dashboard and Deals
    Then Select First Buy Deal
    And Click Dealing Room Buyer
    Then Enter BidPrice "<DealingRoom_Size_Bid>" and Price "<DealingRoom_Price_Bid>"
    Then Click Bid
    Then User Logout from Ilex
#######-------------Dealing Room Seller Offer----------
   Given User Navigates to Login Page of Ilex
   And User Login to Ilex with seller credentials
   And Click on Dashboard and Deals
   Then Select First Sell Deal
   Then Validate Investor Selection page for Buyer Name"<BuyerName>"Seller Name"<SellerName>"
   And Validate Status as Onboarded
   And Click Dealing Room Seller
   Then Enter OfferPrice "<DealingRoom_Size_Offer>" and Price "<DealingRoom_Price_Offer>"
    Then Click Offer
    Then User Logout from Ilex

#######-------------Dealing Room Buyer Accept Offer----------
    Given User Navigates to Login Page of Ilex
    And User Login to Ilex with Buyer credentials
    And Click on Dashboard and Deals
    Then Select First Buy Deal
    And Click Dealing Room Buyer
    Then Enter BidPrice "<DealingRoom_Size_Bid>" and Price "<DealingRoom_Price_Bid>"
    And Click Accept Offer
    Then User Logout from Ilex
#######-------------Seller- Dealing Confirmation----------
     Given User Navigates to Login Page of Ilex
     And User Login to Ilex with seller credentials
     And Click on Dashboard and Deals
     Then Select First Sell Deal
     Then Validate Investor Selection page for Buyer Name"<BuyerName>"Seller Name"<SellerName>"
     And Validate Status as Onboarded
     And Click Dealing Room Seller
     Then Seller Confirms Deal
    Then Validate Deal Confirmation Message "<DealConfirmationLine1>""<DealConfirmationLine2>""<DealConfirmationLine3>"
    Then User Logout from Ilex
#######-------------Buyer- Dealing Confirmation----------
     Given User Navigates to Login Page of Ilex
     And User Login to Ilex with Buyer credentials
     And Click on Dashboard and Deals
     Then Select First Buy Deal
     And Click Dealing Room Buyer
     Then Buyer Confirms Deal
     Then Validate Deal Confirmation Message "<DealConfirmationLine1>""<DealConfirmationLine2>""<DealConfirmationLine3>"
    Then User Logout from Ilex


    Examples:
      | Status | IOICreateName| GoodUntil     | Borrower   | Industry         | RiskCountry   | Purpose             | MinSpread | MaxSpread | FacilityType        | MinTicket | MaxTicket  | Currency | MinTenor | MaxTenor | TransferType | Seniority | MarketType | GreenLoans | Security | ECA|Borrower Name                                     | Parent Name     | Borrower Country | Guarantor Name | Industry      | Country of risk | Public Rating | Internal Rating | Target Issuance Date | Purpose           | Deal Description | Currency | Amount  | Maturity Date | Repayment Type | Facility Type      | Seniority Type | Distrubution Method | Margin | Listing Success Message      |Generic Success Message! |All-in spread (indication) | Size (indication) (USD) | Min. Ticket (indication) (USD) | Invitation valid until | Target closing date |BuyerName    |SellerName                       |InvitationtoBuy_Comments|DealInvitation_InterestSize|DealInvitation_InterestLevel|DealInvitation_Decision|DealingRoom_Size_Bid|DealingRoom_Price_Bid|DealingRoom_Size_Offer|DealingRoom_Price_Offer|DealConfirmationLine1                                    |DealConfirmationLine2                                  |DealConfirmationLine3                                                                                  |
      | Submit | IOI_1        | 2021-April-11 |            |Financial Services| Singapore     | Acquisition Finance |       0   |       300 | Revolving Facility  |         0 | 25,000,000 | AUD      |        0 |        3 | Any          | Any       | Any        | Any        | Any      | Any| Agricultural Bank of China Singapore Branch      | Test Automation | Australia        |                |               | Singapore       | AAA           | AA              | 2021-April-10        |Acquisition Finance| SEC_1             | AUD      |    1000 | 2021-May-20   | Bullet         |Revolving Facility  | Senior         | Syndication         |   1000 |Tranche successfully activated|Generic Success Message! |                       100 |                10000000 |                   0            |  2022-May-20          | 2022-May-20          |Scotiabank   |Royal Bank of Scotland Plc [RBS] |IOI_1_SEC_1            | 1000                      |100%                        |2020-April-30          |  1000              | 100                 |1000                  |100                    |Royal Bank of Scotland Plc [RBS] SELLS / Scotiabank BUYS |AUD1,000 of Confidential loan AGRI RCF AUD0m Apr21 1Y  |at a price of 100%, transfer fee Split between Buyer and Seller and Settled without Accrued Interest.  |


    @End2End123
    Scenario: Execute
      Given User Navigates to Login Page of Ilex
