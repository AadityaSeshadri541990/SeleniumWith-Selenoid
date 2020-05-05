Feature: IOI Ammend And Cancel

  @IOI_Ammend_Cancel_now
  Scenario Outline: Submit IOI Order
    Given User Navigates to Landing Page of Ilex
    And User Login to Ilex with Buyer credentials
    When Click on Order Capture from Navigation Bar
    Then Able to see Buy/Sell Options in Order Capture Page
    When User Clicks on Buy button
    Then Validate IOI and Req Radio Buttons
    When Select IOI
    Then Enter Order Capture Informations for IOI "<Status>""<IOICreateName>""<GoodUntil>""<Borrower>""<Industry>""<RiskCountry>""<Purpose>""<MinSpread>""<MaxSpread>""<FacilityType>""<MinTicket>""<MaxTicket>""<Currency>""<MinTenor>""<MaxTenor>""<TransferType>""<Seniority>""<MarketType>""<GreenLoans>""<Security>""<ECA>"
    Then User Submits IOI Order
    Then On Auto Navigation to Orders Page Select IOI Order Created with IOI Name "<IOICreateName>"
    Then Validate Created IOI Information "<Status>""<IOICreateName>""<GoodUntil>""<Borrower>""<Industry>""<RiskCountry>""<Purpose>""<MinSpread>""<MaxSpread>""<FacilityType>""<MinTicket>""<MaxTicket>""<Currency>""<MinTenor>""<MaxTenor>""<TransferType>""<Seniority>""<MarketType>""<GreenLoans>""<Security>""<ECA>"
    Then Amend IOI "<Status>""<NewIOIName>""<NewGoodUntil>""<NewBorrower>""<Industry>""<NewIndustry>""<RiskCountry>""<NewRiskCountry>""<Purpose>""<NewPurpose>""<NewMinSpread>""<NewMaxSpread>""<FacilityType>""<NewFacilityType>""<NewMinTicket>""<NewMaxTicket>""<Currency>""<NewCurrency>""<NewMinTenor>""<NewMaxTenor>""<TransferType>""<NewTransferType>""<Seniority>""<NewSeniority>""<NewMarketType>""<NewGreenLoans>""<NewSecurity>""<NewECA>"
    Then On Auto Navigation to Orders Page Select IOI Order Amended with IOI Name "<IOICreateName>""<NewIOIName>"
    Then Validate Amended IOI Information "<Status>""<IOICreateName>""<NewGoodUntil>""<NewBorrower>""<NewIndustry>""<NewRiskCountry>""<NewPurpose>""<NewMinSpread>""<NewMaxSpread>""<NewFacilityType>""<NewMinTicket>""<NewMaxTicket>""<NewCurrency>""<NewMinTenor>""<NewMaxTenor>""<NewTransferType>""<NewSeniority>""<NewMarketType>""<NewGreenLoans>""<NewSecurity>""<NewECA>""<NewIOIName>"
    Then Cancel IOI
    Then Validate Cancelled IOI Order "<IOICreateName>""<NewIOIName>"
    Then User Logout from Ilex

    Examples:
      | Status | IOICreateName   | GoodUntil     | Borrower | Industry | RiskCountry | Purpose         | MinSpread | MaxSpread | FacilityType | MinTicket | MaxTicket  | Currency | MinTenor | MaxTenor | TransferType                | Seniority | MarketType | GreenLoans | Security | ECA | NewIOIName   | NewGoodUntil     | NewBorrower | NewIndustry | NewRiskCountry | NewPurpose           | NewMinSpread | NewMaxSpread | NewFacilityType | NewMinTicket | NewMaxTicket  | NewCurrency | NewMinTenor |NewMaxTenor| NewTransferType                          | NewSeniority | NewMarketType | NewGreenLoans  | NewSecurity | NewECA                     |
      | Submit | DBATA8          | 2021-April-11 |          | Shipping | Australia   | Working capital |       100 |       200 | Term Loan A  |         0 | 50,000,000 | AUD      |        3 |        5 | Unfunded risk participation | Senior    | Any        | Any        | Any      | Any | AmendedIOI   |2022-May-11       |             | Automotive  |Hong Kong       |Real Estate Finance   |100           |300           |Term Loan B      |25,000,000    |50,000,000     |HKD          |7            |10         |Legal transfer (Assignment or Novation)   |Subordinated  |Secondary only |Green loans only|Secured      |ECA-backed loans only       |


	