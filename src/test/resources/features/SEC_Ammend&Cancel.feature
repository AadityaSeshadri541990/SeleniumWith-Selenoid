Feature: SEC Ammend And Cancel

  @Amend_Cancel_SEC
  Scenario Outline: Add Loan and Run SEC
    Given User Navigates to Landing Page of Ilex
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
    And Order Saved with Expected Message "<Generic Success Message!>"
    And Capture generated Tranche Name
    And Click on the Back Button
    And Click on Order Capture
    When User clicks on the Sell button
    Then Validate SEC and Req Radio Buttons
    And Select SEC
    And Select Asset Value
    And Enter Trade Informations for SEC "<All-in spread (indication)>""<Size (indication) (USD)>""<Min. Ticket (indication) (USD)>""<Invitation valid until>""<Target closing date>"
    Then User clicks on Submit Order
    When Click on Dashboard from Navigation Bar
    Then Click on Orders
    Then Sort SELL Orders with Latest on Top
    And Select First SELL from List
    Then Validate SEC Order "<Borrower Name>""<Guarantor Name>""<Industry>""<Country of risk>""<Facility Type>""<Purpose>""<Currency>""<Amount>""<Margin>""<Deal Description>""<All-in spread (indication)>""<Size (indication) (USD)>""<Min. Ticket (indication) (USD)>"
    Then Amend SEC "<NewSpread>""<NewSize>""<NewMinTicket>"
    Then Click on Orders
    Then Sort SELL Orders with Latest on Top
    And Select First SELL from List
    Then Validate SEC Order "<Borrower Name>""<Guarantor Name>""<Industry>""<Country of risk>""<Facility Type>""<Purpose>""<Currency>""<Amount>""<Margin>""<Deal Description>""<NewSpread>""<NewSize>""<NewMinTicket>"
    Then Cancel SEC
    Then Click on Orders
    And Validate Cancel SEC

    Examples:
      | Borrower Name                                     | Parent Name     | Borrower Country | Guarantor Name | Industry              | Country of risk | Public Rating | Internal Rating | Target Issuance Date | Purpose             | Deal Description | Currency | Amount | Maturity Date | Repayment Type | Facility Type      | Seniority Type | Distrubution Method | Margin | Generic Success Message! | Expected Value | All-in spread (indication) | Size (indication) (USD) | Min. Ticket (indication) (USD) | Invitation valid until | Target closing date | NewSpread|NewSize|NewMinTicket|
      | China Construction Bank Singapore                 | Test Automation | Australia        | QA             | Aerospace and Defense | Australia       | AAA           | AA              | 2021-April-10        | Working capital     | Dry Auto Run     | HKD      |    100 | 2022-March-11 | Bullet         | Term Loan A        | Senior         | Syndication         |    300 | Generic Success Message! | Expected Value |                        200 |                      30 |                              0 | 2022-April-11          | 2022-May-10         | 150      |100    |50          |

