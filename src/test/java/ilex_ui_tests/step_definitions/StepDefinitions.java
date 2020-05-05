package ilex_ui_tests.step_definitions;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import jdk.internal.org.jline.utils.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ilex_ui_tests.pageobjects.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class StepDefinitions {
    public WebDriver driver;
    public Scenario scenario;
    public WebDriverWait wait;
    public InputStream inputStream;
    public Properties prop;

    public StepDefinitions() throws IOException {
        System.out.println("**************Step Definition Constructor********");
        //Hooks.Initialize_values();
    	driver = Hooks.driver;
    	scenario = Hooks.scenario;
    	wait = Hooks.wait;
        PageFactory.initElements(driver, LandingPage.class);
        PageFactory.initElements(driver, IOI.class);
        PageFactory.initElements(driver, SEC.class);
        PageFactory.initElements(driver, Listing.class);
        PageFactory.initElements(driver, Counterparty.class);
        PageFactory.initElements(driver, InvestorSelection.class);
        PageFactory.initElements(driver, Dashboard_Orders.class);
        PageFactory.initElements(driver, Deal_Invitation.class);

        prop = new Properties();
        String propFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
    }

    @Given("^User Login to Ilex with Buyer credentials$")
    public void user_Login_to_Ilex_with_valid_credentials() throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(prop.getProperty("SITBuyerUsername"));
        list.add(prop.getProperty("SITPassword"));
        LandingPage.login(wait, list);
    }
    @Given("^User Navigates to Landing Page$")
    public void User_Navigates_Landing_Page(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        LandingPage.Navigate_LandingPage(driver,list.get(0),list.get(1));
    }
    @Given("^User Login to Ilex with seller credentials$")
    public void user_Login_to_Ilex_with_seller_credentials() throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(prop.getProperty("SITSellerUsername"));
        list.add(prop.getProperty("SITPassword"));
        LandingPage.login(wait, list);
    }
    @Then("^User Logout from Ilex$")
    public void user_Logout_from_Ilex() throws Throwable {
       LandingPage.logout(driver, wait);
    }
    //********************IOI***************
    @Given("^User Navigates to Login Page of Ilex$")
    public void user_Navigates_to_Login_Page_of_Ilex() throws Throwable
    {
        LandingPage.Navigate_LandingPage(driver,prop.getProperty("SITUrl"),prop.getProperty("SITUIHeaderName"));
    }

    @When("^Click on Order Capture from Navigation Bar$")
    public void click_on_Order_Capture_from_Navigation_Bar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	
        //throw new PendingException();
        System.out.println("**************Click on Order Capture from Navigation Bar********");
        LandingPage.ClickOrderCapture(driver,wait);
        //Thread.sleep(2000);


    }

    @Then("^Able to see Buy/Sell Options in Order Capture Page$")
    public void able_to_see_Buy_Sell_Options_in_Order_Capture_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        System.out.println("**************Able to see Buy/Sell Options in Order Capture Page********");
        IOI.ValidatePageNavigation(driver,"Submit a 4-step order which will be matched by iLex");
        IOI.ValidateBuy_SellButton();
    }

    @When("^User Clicks on Buy button$")
    public void user_Clicks_on_Buy_button() throws Throwable {
    	 IOI.SelectBuy();
    }

    @When("^User Clicks on Sell button$")
    public void user_Clicks_on_Sell_button() throws Throwable {
        IOI.SelectSell();
    }

    @Then("^Validate IOI and Req Radio Buttons$")
    public void validate_IOI_and_Req_Radio_Buttons() throws Throwable {
    	  IOI.ValidateIOI_REQ();
    }


    @When("^Select IOI$")
    public void select_IOI() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        IOI.SelectIOI(wait);
    }


    @Then("^Enter Matching Preference for IOI$")
    public void enter_Matching_Preference_for_IOI(DataTable table) throws Throwable {
    	 List<String> list = table.asList(String.class);
    	 IOI.matchingPreference(driver, wait, list);
    }


    @Then("^Validate Mandatory Fields$")
    public void validate_Mandatory_Fields(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
        List<String> list = table.asList(String.class);
        IOI.ValidateMandatoryFields(driver,wait,list);

    }


    //********************SEC***************
    @When("^User clicks on the Sell button$")
    public void user_clicks_on_the_Sell_button() throws Throwable {
    	 SEC.SelectSell();
    }
    @Then("^Validate SEC and Req Radio Buttons$")
    public void validate_SEC_and_Req_Radio_Buttons() throws Throwable {
        SEC.ValidateSEC_REQ();
    }
    @Then("^Select SEC$")
    public void select_SEC() throws Throwable {
        SEC.SelectSEC(driver, wait);
    }
    @Then("^Select SYN$")
    public void select_SYN() throws Throwable {
        SEC.SelectSYN(driver, wait);
    }

    @Then("^Select Asset$")
    public void select_Asset(DataTable table) throws Throwable {
    	List<String> list = table.asList(String.class);
       SEC.selectAsset(driver,wait, list);
    }
    @Then("^Validate Loan Information$")
    public void validate_Loan_Information(DataTable table) throws Throwable {
    	List<String> list = table.asList(String.class);
        SEC.validateLoanInformation(driver, list);
    }
    
    @Then("^Enter Trade Informations for SEC \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void enter_Trade_Informations_Matching_Preference_for_SEC(String arg1,String arg2,String arg3,String arg4,String arg5) throws Throwable {
    	List<String> list = new ArrayList<String>();
   	    list.add(arg1);list.add(arg2);list.add(arg3);list.add(arg4);list.add(arg5);
        SEC.tradeInformation(driver, list, wait);
    }

    @Then("^Enter Trade Informations for SYN \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void enter_Trade_Informations_Matching_Preference_for_SYN(String arg1,String arg2,String arg3) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);list.add(arg3);
        SEC.SYNtradeInformation(driver, list, wait);
    }


    @Then("^Enter Matching Preferences for SEC$")
    public void enter_Matching_Preferences_for_SEC(DataTable table) throws Throwable {
    	List<String> list = table.asList(String.class);
    	SEC.matchingInformation(driver, list, wait);
    }
    @Then("^User clicks on Save Draft on IOI$")
    public void user_clicks_on_Save_Draft_IOI() throws Throwable {
    	 IOI.saveDraft(driver,wait);
    }
    @Then("^User clicks on Save Draft on SEC$")
    public void user_clicks_on_Save_Draft_SEC() throws Throwable {
        SEC.saveDraft();
    }
    @Then("^User clicks on Submit Order$")
    public void user_clicks_on_Submit_Order() throws Throwable {
    	 SEC.submitOrder(driver,wait);
    }

    @Then("^Order Saved with Expected Message \"([^\"]*)\"$")
    public void order_Saved_with_Expected_Message(String arg1) throws Throwable {
    	List<String> list = new ArrayList<String>();
   	    list.add(arg1);
   	    Listing.ValidateActivateTrancheMessage(driver,list,wait);
    	//IOI.validateSuccessfulSaveDraftMsg(driver, list, wait);
    	//Thread.sleep(10000);
    }



    @When("^Enter Borrower name from Refinitiv$")
    public void enter_Borrower_name_from_Refinitiv(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        List<String> list = table.asList(String.class);
        IOI.EnterRefintivBorrower(driver,wait,list);


    }

    @Then("^Validate Industry Auto Populated and Non-Editable$")
    public void validate_Industry_Auto_Populated_and_Non_Editable(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        List<String> list = table.asList(String.class);
        IOI.Validate_Field_AutoPopulate_NonEditable(driver,wait,list);
    }
    @Then("^Validate Country of Risk Auto Populated and Non-Editable$")
    public void validate_Country_of_Risk_Auto_Populated_and_Non_Editable(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        List<String> list = table.asList(String.class);
        IOI.Validate_Field_AutoPopulate_NonEditable(driver,wait,list);
    }

//*********************************Listing******************************************
    
    @When("^Click on Administration from Navigation Bar$")
    public void click_on_Administration_from_Navigation_Bar() throws Throwable {
       LandingPage.ClickAdministration(wait);
    }

    @When("^Click on My Loans$")
    public void click_on_My_Loans() throws Throwable {
        LandingPage.ClickMyLoans(wait);
    }

    @When("^User Able to see Loan Details Page in My Loans$")
    public void user_Able_to_see_Loan_Details_Page_in_My_Loans() throws Throwable {
       Listing.ValidateLoanDetailsScreen(wait);
    }

    @Then("^Enter Loan Details$")
    public void enter_Loan_Details(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        Listing.InputLoanDetails(driver, list, wait);
        
    }
    
    @Then("^Followed by Adding Tranches to it \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void followed_by_Adding_Tranches_to_it(String arg1,String arg2,String arg3,String arg4,String arg5,String arg6,String arg7,String arg8) throws Throwable {
    	List<String> list = new ArrayList<String>();
   	    list.add(arg1);list.add(arg2);list.add(arg3);list.add(arg4);list.add(arg5);list.add(arg6);list.add(arg7);list.add(arg8);
    	Listing.Click_AddTranche(driver, list, wait);
    	//Thread.sleep(10000);
    }

    @Then("^User Clicks on List button$")
    public void user_Clicks_on_List_button() throws Throwable {
       Listing.ClickTrancheList(wait);
        //Thread.sleep(1000000);
       //Sing OTHERSVC100mApr20
    }


    @Then("^Tranche List  Msg$")
    public void tranche_List_Msg() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
    }

    @Then("^User Clicks on Delete button$")
    public void user_Clicks_on_Delete_button() throws Throwable {
       Listing.DeleteTranche();
    }
    @Then("^Tranche Deletion  Msg$")
    public void tranche_Deletion_Msg(DataTable table) throws Throwable {
    	List<String> list = table.asList(String.class);
        Listing.ValidateDeletedTranche(list);
    }
    @Then("^Scroll down to Tranche by skipping Loan Details$")
    public void scroll_down_to_Tranche_by_skipping_Loan_Details() throws Throwable {
       Listing.ClickAddTranche_Listing(driver, wait);
    }
    
    @Then("^User can validate Mandatory check Msg$")
    public void user_can_validate_Mandatory_check_Msg(DataTable table) throws Throwable {
    	List<String> list = table.asList(String.class);
        Listing.ValidateMandatoryFields(driver, wait, list);
    }
    //******************************Counterparty************************************************
    
    @Then("^Click on My Network$")
    public void click_on_My_Network() throws Throwable {
        LandingPage.ClickMyNetworks(wait);
    }

    @When("^User navigated to My Network homepage$")
    public void user_navigated_to_My_Network_homepage() throws Throwable {
       Counterparty.ValidateMyNetworkPage(wait);
    }

    @When("^Click Add Contact button$")
    public void click_Add_Contact() throws Throwable {
       Counterparty.Click_AddContact();
    }

    @Then("^Add New Contact Window Will popup$")
    public void add_New_Contact_Window_Will_popup() throws Throwable {
       Counterparty.Validate_AddNewContactWindow(wait);
    }
    @Then("^User Enters Contact Fields$")
    public void user_Enters_Contact_Fields(DataTable table) throws Throwable {
    	List<String> list = table.asList(String.class);
    	Counterparty.Contact_Details(driver, wait, list);
    }
    @Then("^User clicks on create button$")
    public void user_clicks_on_create_button() throws Throwable {
      Counterparty.Click_CreateBtn();
    }
    @Then("^User clicks on cancel button$")
    public void user_clicks_on_cancel_button() throws Throwable {
    	Counterparty.Click_CancelBtn();
    }
    @When("^Clicks on Create Group$")
    public void clicks_on_Create_Group() throws Throwable {
       Counterparty.Click_CreateGrp();
    }
    @Then("^User clicks on group create button$")
    public void user_clicks_on_group_create_button() throws Throwable {
        Counterparty.Click_CreateBtnGrp(wait);
    }
    @Then("^User clicks on group cancel button$")
    public void user_clicks_on_group_cancel_button() throws Throwable {
        Counterparty.Click_CancelBtnGrp();
    }
    @Then("^Create Group Window Will popup$")
    public void add_Create_Group_Window_Will_popup() throws Throwable {
       Counterparty.Validate_GroupWindow(wait);
    }

    @Then("^User Enters Group Details$")
    public void user_Enters_Group_Details(DataTable table) throws Throwable {
    	List<String> list = table.asList(String.class);
    	Counterparty.Enter_GroupDetails(driver, wait, list);
    }
//    @Then("^Validate the created record in Groups Tab$")
//    public void validate_the_created_record_in_Groups_Tab() throws Throwable {
//       
//    }
//    @Then("^User Modify the added Contact detail$")
//    public void user_Modify_the_added_Contact_detail() throws Throwable {
//       Counterparty.ModifyUserValue(driver, list);
//    }
    @When("^User Modify the added Contact detail$")
    public void user_Modify_the_added_Contact_detail(DataTable table) throws Throwable {
    	List<String> list = table.asList(String.class);
    	Counterparty. ModifyUserValue(driver, list, wait);
    }
    @Then("^User clicks on Groups tab$")
    public void user_clicks_on_Groups_tab() throws Throwable {
    	Counterparty.NavigateToGroupTab(driver, wait);
       
    }
    @Then("^User navigated to Group Tab$")
    public void user_navigated_to_Group_Tab() throws Throwable {
        Counterparty.NavigateToGroupTab(driver, wait);
    }
    @Then("^User Modify the created group$")
    public void user_Modify_the_created_group(DataTable table) throws Throwable {
    	List<String> list = table.asList(String.class);
    	Counterparty.ModifyGroupValue(driver, list, wait);
    }

    //**************************Deals*******************************************
    @When("^Click on Dashboard from Navigation Bar$")
    public void click_on_Dashboard_from_Navigation_Bar() throws Throwable {
       LandingPage.ClickDashboard(driver,wait);
    }

    @Then("^Click on Deals$")
    public void click_on_Deals() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      //  throw new PendingException();
    }

    @When("^User Clicks on Sample Deals Info$")
    public void user_Clicks_on_Sample_Deals_Info() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      //  throw new PendingException();
    }
   /////////////Investor Selection/////////////////////////////
    
    @Then("^Validate the Asset Name \"([^\"]*)\"$")
    public void validate_the_Asset_Name(String arg) throws Throwable {
    	List<String> list = new ArrayList<String>();
        list.add(arg);
       InvestorSelection.validateAssetName(driver, list, wait);
    }
    @Then("^User Validate the Shortlisted Investors \"([^\"]*)\"$")
    public void user_Validate_the_Shortlisted_Investors(String arg) throws Throwable {
    	List<String> list = new ArrayList<String>();
        list.add(arg);
    	InvestorSelection.validate_ShortlistedInvestors(wait, list);
    }
    @Then("^Select Created Asset$")
    public void select_Created_Asset() throws Throwable {
       InvestorSelection.selectCreatedAsset(driver, wait);
    }


    //****************************Bulk*******************************

    @Then("^Enter Order Capture Informations for IOI \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void enter_Order_Capture_Informations_for_IOI(String arg1, String arg2, String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9,String arg10,String arg11,String arg12,String arg13,String arg14,String arg15,String arg16,String arg17,String arg18,String arg19,String arg20,String arg21) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);list.add(arg3);list.add(arg4);list.add(arg5);list.add(arg6);list.add(arg7);list.add(arg8);list.add(arg9);list.add(arg10);list.add(arg11);list.add(arg12);list.add(arg13);list.add(arg14);list.add(arg15);list.add(arg16);list.add(arg17);list.add(arg18);list.add(arg19);list.add(arg20);list.add(arg21);
        IOI.OrderCriteria(driver,wait,list);

    }

    @Then("^Validate Created IOI Information \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void Validate_IOI(String arg1, String arg2, String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9,String arg10,String arg11,String arg12,String arg13,String arg14,String arg15,String arg16,String arg17,String arg18,String arg19,String arg20,String arg21) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);list.add(arg3);list.add(arg4);list.add(arg5);list.add(arg6);list.add(arg7);list.add(arg8);list.add(arg9);list.add(arg10);list.add(arg11);list.add(arg12);list.add(arg13);list.add(arg14);list.add(arg15);list.add(arg16);list.add(arg17);list.add(arg18);list.add(arg19);list.add(arg20);list.add(arg21);
        String TradeStatus = "Create";
        IOI.ValidateIOIInfo(driver,wait,list,TradeStatus);

    }

    @Then("^Validate Amended IOI Information \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void Validate_Amended_IOI(String arg1, String arg2, String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9,String arg10,String arg11,String arg12,String arg13,String arg14,String arg15,String arg16,String arg17,String arg18,String arg19,String arg20,String arg21,String arg22) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);list.add(arg3);list.add(arg4);list.add(arg5);list.add(arg6);list.add(arg7);list.add(arg8);list.add(arg9);list.add(arg10);list.add(arg11);list.add(arg12);list.add(arg13);list.add(arg14);list.add(arg15);list.add(arg16);list.add(arg17);list.add(arg18);list.add(arg19);list.add(arg20);list.add(arg21);list.add(arg22);
        String TradeStatus = "Amend";
        IOI.ValidateIOIInfo(driver,wait,list,TradeStatus);

    }

    @Then("^Cancel IOI$")
    public void Cancel_IOI() throws Throwable {

        IOI.CancelIOI(driver,wait);

    }

    @Then("^Cancel SEC$")
    public void Cancel_SEC() throws Throwable {

        SEC.CancelSEC(driver,wait);

    }

    @Then("^Cancel SYN$")
    public void Cancel_SYN() throws Throwable {

        SEC.CancelSEC(driver,wait);

    }

    @Then("^Validate Cancelled IOI Order \"([^\"]*)\"\"([^\"]*)\"$")
    public void Validate_Cancel_IOI(String arg1, String arg2) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);
        String Tab = "Cancel";
        String IOI_Name = list.get(0)+list.get(1);
        Dashboard_Orders.SelectIOI(driver, IOI_Name, wait,Tab);
        IOI.ValidateCancelIOI(driver,wait,list);

    }


    @Then("^Amend IOI \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void Amend_IOI(String arg1, String arg2, String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9,String arg10,String arg11,String arg12,String arg13,String arg14,String arg15,String arg16,String arg17,String arg18,String arg19,String arg20,String arg21,String arg22,String arg23,String arg24,String arg25,String arg26,String arg27,String arg28) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);list.add(arg3);list.add(arg4);list.add(arg5);list.add(arg6);list.add(arg7);list.add(arg8);list.add(arg9);list.add(arg10);list.add(arg11);list.add(arg12);list.add(arg13);list.add(arg14);list.add(arg15);list.add(arg16);list.add(arg17);list.add(arg18);list.add(arg19);list.add(arg20);list.add(arg21);list.add(arg22);list.add(arg23);list.add(arg24);list.add(arg25);list.add(arg26);list.add(arg27);list.add(arg28);
        IOI.AmendIOI(driver,wait,list);
        Thread.sleep(3000);

    }

    @Then("^Enter Loan Details MEngine \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void enter_Loan_Details_MEngine(String arg1, String arg2, String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9,String arg10,String arg11) throws Throwable {
    	 List<String> list = new ArrayList<String>();
    	 list.add(arg1);list.add(arg2);list.add(arg3);list.add(arg4);list.add(arg5);list.add(arg6);list.add(arg7);list.add(arg8);list.add(arg9);list.add(arg10);list.add(arg11);
        Listing.InputLoanDetailsMEngine(driver, list, wait);
        
    }

    @Then("^User Submits IOI Order$")
    public void User_Submits_IOI_Order() throws Throwable {
        IOI.submit(driver,wait);
    }

    @Then("^Order Submitted with Expected Message \"([^\"]*)\"$")
    public void order_Submitted_with_Expected_Message(String arg1) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);
        IOI.validateSuccessfulSubmitMsg(driver, list, wait);
    }

    @Then("^On Auto Navigation to Orders Page Select IOI Order Created with IOI Name \"([^\"]*)\"$")
    public void SelectIOIOrder(String arg1) throws Throwable {
        List<String> list = new ArrayList<String>();
         list.add(arg1);
         String IOI_Name =  list.get(0);
         String Tab = "Active";
        Dashboard_Orders.SelectIOI(driver, IOI_Name, wait,Tab);
    }

    @Then("^On Auto Navigation to Orders Page Select IOI Order Amended with IOI Name \"([^\"]*)\"\"([^\"]*)\"$")
    public void SelectIOIAmendOrder(String arg1,String arg2) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);
        String IOI_Name = list.get(0)+list.get(1);
        String Tab = "Active";
        Dashboard_Orders.SelectIOI(driver, IOI_Name, wait,Tab);
        //Thread.sleep(10000);
    }
    
    @Then("^Clicks and Create Asset Name$")
    public void clicks_and_Create_Asset_Name() throws Throwable {
       InvestorSelection.selectAssetAndInput(driver, wait);
    }

    @Then("^Clicks and Create Asset Name for SYN$")
    public void clicks_and_Create_Asset_Name_ForSYN() throws Throwable {
        InvestorSelection.selectAssetAndInput_SYN(driver, wait);
    }

    @Then("^Click on the Back Button$")
    public void click_on_the_Back_Button() throws Throwable {
        InvestorSelection.clickBackBtn(driver, wait);
    }
    @Then("^Capture generated Tranche Name$")
    public void capture_generated_Tranche_Name() throws Throwable {
    	InvestorSelection.captureTrancheName(driver, wait);
    }

    @Then("^Click on Order Capture$")
    public void Click_Order_Capture() throws Throwable {
        //InvestorSelection.captureTrancheName(driver, wait);
        LandingPage.ClickOrderCapture(driver,wait);
    }

    @Then("^Select Asset Value$")
    public void select_Asset_Value() throws Throwable {
        InvestorSelection.SelectAsset(driver, wait);
    
    }

    @Then("^Select Asset Value for SYN$")
    public void select_Asset_Value_SYN() throws Throwable {
        InvestorSelection.SelectAsset_SYN(driver, wait);

    }


    @Then("^Click on Orders$")
    public void click_on_Orders() throws Throwable {
       LandingPage.ClickOrders(driver,wait);
       //Thread.sleep(10000);
    }

    @Then("^Validate Cancel SEC$")
    public void ValidateCancelSEC() throws Throwable {
        String Status = "Cancel";
        LandingPage.SelectFirstSEC(driver,wait,Status);
        SEC.ValidateCancelSEC(driver,wait);
        //Thread.sleep(10000);
    }

    @Then("^Validate Cancel SYN$")
    public void ValidateCancelSYN() throws Throwable {
        String Status = "Cancel";
        LandingPage.SelectFirstSEC(driver,wait,Status);
        SEC.ValidateCancelSEC(driver,wait);
        //Thread.sleep(10000);
    }

    @Then("^Sort SELL Orders with Latest on Top$")
    public void Sort_SELL() throws Throwable {
        LandingPage.SortSEC(driver,wait);
        //Thread.sleep(10000);
    }

    @Then("^Select First SELL from List$")
    public void SelectFirstSELL() throws Throwable {
        String Status = "Active";
        LandingPage.SelectFirstSEC(driver,wait,Status);
        //Thread.sleep(10000);
    }

    @Then("^Validate SEC Order \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void ValidateSEC(String arg1,String arg2,String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9,String arg10,String arg11,String arg12,String arg13) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);list.add(arg3);list.add(arg4);list.add(arg5);list.add(arg6);list.add(arg7);list.add(arg8);list.add(arg9);list.add(arg10);list.add(arg11);list.add(arg12);list.add(arg13);
        //Thread.sleep(20000);
        SEC.ValidateSEC(driver,wait,list);
        //Thread.sleep(10000);
    }

    @Then("^Validate SYN Order \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void ValidateSYN(String arg1,String arg2,String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9,String arg10,String arg11) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);list.add(arg3);list.add(arg4);list.add(arg5);list.add(arg6);list.add(arg7);list.add(arg8);list.add(arg9);list.add(arg10);list.add(arg11);
        //Thread.sleep(20000);
        SEC.ValidateSYN(driver,wait,list);
        //Thread.sleep(10000);
    }

    @Then("^Amend SEC \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void AmendSEC(String arg1,String arg2,String arg3) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);list.add(arg3);
        SEC.AmendSEC(driver,wait,list);
        //Thread.sleep(1000);
    }

    @Then("^Amend SYN \"([^\"]*)\"$")
    public void AmendSYN(String arg1) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);
        SEC.AmendSYN(driver,wait,list);
        //Thread.sleep(1000);
    }



    @Then("^Navigate to Active Orders$")
    public void navigate_to_Active_Orders() throws Throwable {
       InvestorSelection.navigateActiveOrders();
    }
    @Then("^Verify Order Status \"(.*?)\"$")
    public void verify_Order_Status(String arg1) throws Throwable {
     List<String> list = new ArrayList<String>();
   	 list.add(arg1);
   	 InvestorSelection.validationMatchingEngine(driver, list);
    }
    @Then("^Select the Order \"(.*?)\"$")
    public void select_the_Order(String arg1) throws Throwable {
    	List<String> list = new ArrayList<String>();
      	 list.add(arg1); 
      	 InvestorSelection.selectOrder(driver, list);
    }
    @Then("^Enter IOI Page  \"(.*?)\"\"(.*?)\"$")
    public void enter_IOI_Page(String arg1, String arg2) throws Throwable {
    	List<String> list = new ArrayList<String>();
     	 list.add(arg1);
     	 
    }

    @Then("^User Modify IOI Order$")
    public void user_Modify_IOI_Order(String arg1) throws Throwable {
    	List<String> list = new ArrayList<String>();
     	 list.add(arg1);
    }

    @When("^Delete Test Data DB$")
    public void DeleteDataTestDB() throws Throwable {


    }

    @Then("^Validate Investor Selection page for Buyer Name\"(.*?)\"Seller Name\"(.*?)\"$")
    public void ValidateInvestorSelectionIOI_SEC(String arg1,String arg2) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);
        InvestorSelection.ValidateBuyerSellerName(driver,wait,list);

    }

    @And("^Validate Status as Shortlisted$")
    public void Validate_IOI_SECStatus_InvestorSelection() throws Throwable {
        String Status = "Shortlisted";
        InvestorSelection.ValidateStatus(driver,wait,Status);


    }

    @And("^Validate Status as Accepted$")
    public void Validate_IOI_SECStatus_InvestorSelection_Accepted() throws Throwable {
        String Status = "Accepted";
        InvestorSelection.ValidateStatus(driver,wait,Status);


    }

    @And("^Validate Status as Onboarded$")
    public void Validate_IOI_SECStatus_InvestorSelection_Onboarded() throws Throwable {
        String Status = "Onboarded";
        InvestorSelection.ValidateStatus(driver,wait,Status);


    }

    @And("^Click Button to get to Onboard Page$")
    public void Onboard_Page() throws Throwable
    {
        InvestorSelection.ClicktoOnboard(driver,wait);
    }

    @Then("^Click on Onboard$")
    public void Onboard_Buyer() throws Throwable
    {
        InvestorSelection.OnboardBuyer(driver,wait);
    }

    @And("^Validate Status as Invited$")
    public void Validate_IOI_SECStatus_InvestorSelection_Invited() throws Throwable {
        String Status = "Invited";
        Thread.sleep(2000);
        InvestorSelection.ValidateStatus(driver,wait,Status);


    }
    @And("^Validate BorrowerName\"(.*?)\"TrancheName OrderType as Secondary$")
    public void ValidateBorrowerName(String arg1) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);
        InvestorSelection.ValidateBorrowerTrancheName(driver,list);

    }
    @And("^Click on Investor and Invite$")
    public void ClickInvestor() throws Throwable {
        InvestorSelection.InviteBuyer(driver,wait);

    }

    @Then("^Toggle LoanInformation and Trade Information$")
    public void ToggleLoanInfo() throws Throwable {
        InvestorSelection.ToggleLoanInfo(driver,wait);

    }

    @Then("^Enter Comments in Invitation to Buy \"(.*?)\"$")
    public void InvestorSelection_EnterComments(String arg1) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);
        InvestorSelection.EnterComments(driver,wait,list);

    }

    @And("^Click InvitetoBuy$")
    public void ClickInvitation() throws Throwable {
        InvestorSelection.ClickInvitetoBuy(driver,wait);

    }
    @And("^Click on Dashboard and Invitation$")
    public void ClickDashboard_Invitations() throws Throwable {
        LandingPage.ClickDashboard(driver,wait);
        LandingPage.ClickInvitations(driver,wait);

    }

    @And("^Click on Dashboard and Deals$")
    public void ClickDashboard_Invitations_Deals() throws Throwable {
        LandingPage.ClickDashboard(driver,wait);
        LandingPage.ClickDeals(driver,wait);

    }

    @Then("^Select First Sell Deal$")
    public void SelectFirstDeal_Sell() throws Throwable {
       Deal_Invitation.SelectFirstSellDeral(driver,wait);

    }

    @Then("^Select First Buy Deal$")
    public void SelectFirstDeal_Buy() throws Throwable {
        Deal_Invitation.SelectFirstBuyDeral(driver,wait);

    }

    @Then("^Click Dealing Room Seller$")
    public void ClickDealingRoom() throws Throwable {
        Deal_Invitation.DealingRoomTab_Seller(driver,wait);

    }

    @Then("^Click Dealing Room Buyer$")
    public void ClickDealingRoom_Buyer() throws Throwable {
        Deal_Invitation.DealingRoomTab_Buyer(driver,wait);

    }

    @Then("^Seller Confirms Deal$")
    public void Seller_Confirm() throws Throwable {
        Deal_Invitation.Seller_Confirm(driver,wait);

    }

    @Then("^Buyer Confirms Deal$")
    public void Buyer_Confirm() throws Throwable {
        Deal_Invitation.Buyer_Confirm(driver,wait);

    }

    @Then("^Validate Deal Confirmation Message \"(.*?)\"\"(.*?)\"\"(.*?)\"$")
    public void VaidateDealConfirmation(String arg1,String arg2,String arg3) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);list.add(arg3);
        Deal_Invitation.ValidateDealConfirmation(driver,wait,list);

    }

    @And("^Click Dealing Room Button$")
    public void DealingRoom() throws Throwable {
        Deal_Invitation.ClickDealingRoomButton(driver,wait);

    }

    @Then("^Enter BidPrice \"(.*?)\" and Price \"(.*?)\"$")
    public void DealSiteInfo(String arg1,String arg2) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1); list.add(arg2);
        Deal_Invitation.DealingRoomBuyer(driver,wait,list);
       // Thread.sleep(10000);

    }

    @Then("Click Bid$")
    public void ClickBid() throws Throwable {

        Deal_Invitation.DealingRoomClickBid(driver,wait);

    }

    @Then("Click Offer$")
    public void ClickOffer() throws Throwable {

        Deal_Invitation.DealingRoomClickOfer(driver,wait);

    }

    @Then("Click Accept Offer$")
    public void ClickAcceptOfer() throws Throwable {

        Deal_Invitation.DealingRoomClickAcceptOfer(driver,wait);

    }

    @Then("^Enter OfferPrice \"(.*?)\" and Price \"(.*?)\"$")
    public void DealSiteInfo_Offer(String arg1,String arg2) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1); list.add(arg2);
        Deal_Invitation.DealingRoomSeller(driver,wait,list);
        //Thread.sleep(10000);

    }

    @And("^Select First Row from IOI Deal Invitation$")
    public void Click_FirstRow_Invitation() throws Throwable {
        Deal_Invitation.SelectFirstRowDealInvitation(driver,wait);

    }

    @Then("^Enter InterestSize \"(.*?)\" Level of Interest \"(.*?)\" EstimatedDecisionDate \"(.*?)\"$")
    public void EnterDeaslInvitation_Info(String arg1,String arg2,String arg3) throws Throwable {
        List<String> list = new ArrayList<String>();
        list.add(arg1);list.add(arg2);list.add(arg3);
        Deal_Invitation.EnterDealsInvitation_Info(driver,wait,list);

    }

    @And("^Click on NDA and Accept Invitation")
    public void ClickNDA_Accept() throws Throwable {
        Deal_Invitation.ClickNDA_Accept(driver,wait);

    }
}