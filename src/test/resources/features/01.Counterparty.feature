@CPM
Feature: Counterparty

  Background:
    Given User Navigates to Landing Page of Ilex
    And User Login to Ilex with valid credentials
    When Click on Administration from Navigation Bar
    Then Click on My Network

  @Counterparty
  Scenario: Create User
    When User navigated to My Network homepage
    And Click Add Contact button
    Then Add New Contact Window Will popup
    And User Enters Contact Fields
      #|First Name|Last Name|Title|Company|Country|Email|Office Number|Mobile Number|
      | Automation | Testing | QA | Palo | Albania | Test@test.com | +65 123 | +65 456 |
    Then User clicks on create button
    Then User Logout from Ilex

  @Counterparty
  Scenario: Cancel User
    When User navigated to My Network homepage
    And Click Add Contact button
    Then Add New Contact Window Will popup
    And User Enters Contact Fields
      #|First Name|Last Name|Title|Company|Country|Email|Office Number|Mobile Number|
      | Cancel Automation | Cancel Testing | QA | Palo | Albania | Test@test.com | +65 567 | +65 865 |
    Then User clicks on cancel button
    Then User Logout from Ilex

  @Counterparty
  Scenario: Modify User
    When User navigated to My Network homepage
    And Click Add Contact button
    Then Add New Contact Window Will popup
    And User Enters Contact Fields
      #|First Name|Last Name|Title|Company|Country|Email|Office Number|Mobile Number|
      | AutoModify | Test | QA | Palo | Albania | Test@test.com | +65 123 | +65 456 |
    Then User clicks on create button
    And User Modify the added Contact detail
      #|Contact Name|Change First Name|
      | AutoModify | Modify |
    Then User Logout from Ilex

  @Counterparty
  Scenario: Create Group
    When User navigated to My Network homepage
    And Clicks on Create Group
    Then Create Group Window Will popup
    And User Enters Group Details
      #|Group Name|Search Contact|
      | Team_Automation | Automation Testing, |
    Then User clicks on group create button
    Then User Logout from Ilex

  # And Validate the created record in Groups Tab
  #@Counterparty
  #Scenario: Cancel Group
    #When User navigated to My Network homepage
    #And Clicks on Create Group
    #Then Create Group Window Will popup
    #And User Enters Group Details
      #|Group Name|Search Contact|
      #| Team_Automation | Automation Testing |
    #Then User clicks on group cancel button

  @Counterparty
  Scenario: Modify Group
    When User navigated to My Network homepage
    And Clicks on Create Group
    Then Create Group Window Will popup
    And User Enters Group Details
      #|Group Name|Search Contact|
      | Auto10Modify | Automation Testing, |
    And User clicks on group create button
    And User navigated to Group Tab
    Then User Modify the created group
      #|Group Name|Change Group Name|
      | Auto10Modify | Modifiednew |
    Then User Logout from Ilex

