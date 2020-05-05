package ilex_ui_tests.pageobjects;
//import helpers.Log;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ilex_ui_tests.step_definitions.Hooks;
import ilex_ui_tests.step_definitions.Reusable_Functions;

import java.util.List;

//import ilex_ui_tests.pageobjects.Log;;
//public class HomePage extends BaseClass{
	public class IOI {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(IOI.class);

	//WebDriver driver = Hooks.driver;
	 WebDriverWait wait = Hooks.wait;

	@FindBy(how= How.XPATH, using="//*[text()='Submit a 4-step order which will be matched by iLex']")
	public static WebElement Lbl_PageTitle;

	@FindBy(how= How.XPATH, using="//*[text()='Buy']")
	public static WebElement Btn_Buy;

	@FindBy(how= How.XPATH, using="//*[text()='Sell']")
	public static WebElement Btn_Sell;

	@FindBy(how= How.XPATH, using="//*[text()='Indicate an Interest (IOI)']")
	public static WebElement Rdbtn_IOI;

	@FindBy(how= How.XPATH, using="//*[text()='Launch a Reverse Enquiry (REQ)']")
	public static WebElement Rdbtn_REQ;

	@FindBy(how= How.ID, using="ioi-form-name-of-ioi")
	public static WebElement Txt_IOIName;

	@FindBy(how= How.ID, using="ioi-form-good-until")
	public static WebElement Date_GoodUntil;

	@FindBy(how= How.XPATH, using="//input[@id='ioi-form-borrower']//following-sibling::div/div/button")
	public static WebElement Drp_Borrower;


	@FindBy(how= How.ID, using="ioi-form-min-spread")
	public static WebElement Slt_MinSpread;
	
	@FindBy(how= How.ID, using="ioi-form-max-spread")
	public static WebElement Slt_MaxSpread;
	
	@FindBy(how= How.ID, using="ioi-form-min-ticket-size")
	public static WebElement Slt_MinTicketSize;
	
	@FindBy(how= How.ID, using="ioi-form-max-ticket-size")
	public static WebElement Slt_MaxTicketSize;
	
	@FindBy(how= How.ID, using="ioi-form-min-residual-tenor")
	public static WebElement Slt_MinResidualTenor;
	
	@FindBy(how= How.ID, using="ioi-form-max-residual-tenor")
	public static WebElement Slt_MaxResidualTenor;
	

	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-industry']")
	public static WebElement Drp_Industry;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-parent-country']")
	public static WebElement Drp_CountryOfRisk;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-purpose']")
	public static WebElement Drp_Purpose;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-facility-type']")
	public static WebElement Drp_FacilityType;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-currency']")
	public static WebElement Drp_Currency;
	
	@FindBy(how= How.XPATH, using="//input[@id='ioi-form-investor-type']//following-sibling::div/button//following-sibling::button")
	public static WebElement Drp_InvestorType;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-transfer-type']")
	public static WebElement Drp_Transfer_Type;
	
	//changes so far below
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-purpose']")
	public static WebElement Page_OrderCapture;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-purpose']")
	public static WebElement Drp_Purpose_New;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-facility-type']")
	public static WebElement Drp_FacilityType_New;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-currency']")
	public static WebElement Drp_Currency_New;
	
	@FindBy(how= How.XPATH, using="//span[contains(text(),'+ More options')]")
	public static WebElement Link_Show_More;
	
	@FindBy(how= How.XPATH, using="//span[contains(text(),'- Less options')]")
	public static WebElement Link_Show_Less;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-transfer-type']")
	public static WebElement Drp_Transfer_Type_New;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-seniority']")
	public static WebElement Drp_Seniority;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-market-type']")
	public static WebElement Drp_Form_Market_Type;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-green-loans']")
	public static WebElement Drp_Form_Green_Loans;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-security']")
	public static WebElement Drp_Form_Security;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-eca']")
	public static WebElement Drp_Form_ECA;
	 
	@FindBy(how= How.XPATH, using="//input[@id='ioi-form-parent-country']//following-sibling::div/button//following-sibling::button")
	public static WebElement Drp_ParentCountry;
	
	@FindBy(how= How.XPATH, using="//div[@id='ioi-form-investor-type']")
	public static WebElement Drp_InvestorType_New;
	
	@FindBy(how= How.XPATH, using="//input[@id='ioi-form-filter-out-counterparties']//following-sibling::div/button//following-sibling::button")
	public static WebElement Drp_FilterOutCounterParties;
	
	@FindBy(how= How.XPATH, using="//*[text()='Generic Success Message!']")
	public static WebElement actual_Message;

	@FindBy(how= How.XPATH, using="//span[contains(text(),'Save Draft')]")
	public static WebElement Btn_SaveDraft;

	@FindBy(how= How.XPATH, using="//button[@id='ioi-form-primary-button']")
	public static WebElement Btn_IOISubmit;

	@FindBy(how= How.XPATH, using="//div[contains(text(),'Buy Order')]")
	public static WebElement OrdersPage_BuyTable;



	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Modify Order')]")
	public static WebElement Btn_ModifyIOIOrder;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Cancel Order')]")
	public static WebElement Btn_CancelIOIOrder;

	@FindBy(how = How.XPATH, using = "//*[text()='Confirm']")
	public static WebElement Btn_ConfirmModifyIOIOrder;

	public static void ValidatePageNavigation(WebDriver driver,String Text)
	{
		log.info("Class ------ ActiveReposPage       Function -------ValidatePageNavigation");
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertEquals(Lbl_PageTitle.getText(),Text);
		//driver.navigate().back();
	}

	public static void ValidateBuy_SellButton() {
		Assert.assertTrue(Btn_Buy.isDisplayed());
		Assert.assertTrue(Btn_Sell.isDisplayed());
}

	public static void SelectBuy() throws InterruptedException {
		Reusable_Functions.ButtonClick(Btn_Buy);
		//Thread.sleep(5000);
	}
	public static void SelectSell() throws InterruptedException {
		Reusable_Functions.ButtonClick(Btn_Buy);
		//Thread.sleep(5000);
	}

	public static void ValidateIOI_REQ() {
		Assert.assertTrue(Rdbtn_IOI.isDisplayed());
		Assert.assertTrue(Rdbtn_REQ.isDisplayed());

	}

	public static void SelectIOI(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(Rdbtn_IOI));
		Reusable_Functions.ButtonClick(Rdbtn_IOI);
	}

	public static void OrderCriteria(WebDriver driver, WebDriverWait wait,List<String> list) throws InterruptedException {
		if(list.get(0).contentEquals("Draft"))
		{
			Reusable_Functions.EnterTextBox(Txt_IOIName,list.get(1));
		}
		else if(list.get(0).contentEquals("Submit"))
		{
			Reusable_Functions.EnterTextBox(Txt_IOIName,list.get(1));
			Reusable_Functions.DatePicker(driver,wait,Date_GoodUntil,list.get(2));
			wait.until(ExpectedConditions.elementToBeClickable(Drp_Industry));
			Reusable_Functions.selectValue_New(driver, Drp_Industry, list.get(4), wait);
			wait.until(ExpectedConditions.elementToBeClickable(Drp_CountryOfRisk));
			Reusable_Functions.selectValue_New(driver, Drp_CountryOfRisk, list.get(5), wait);
			wait.until(ExpectedConditions.elementToBeClickable(Drp_Purpose_New));
			Reusable_Functions.selectValue_New(driver,Drp_Purpose_New,list.get(6), wait);
			Reusable_Functions.EnterTextBox(Slt_MinSpread,list.get(7));
			Reusable_Functions.EnterTextBox(Slt_MaxSpread,list.get(8));
		/*	Reusable_Functions.selectValue_New(driver,Slt_MinSpread,list.get(7),wait);
			Reusable_Functions.selectValue_New(driver,Slt_MaxSpread,list.get(8),wait);*/
			Reusable_Functions.selectValue_New(driver, Drp_FacilityType_New, list.get(9), wait);
			Reusable_Functions.EnterTextBox(Slt_MinTicketSize,list.get(10));
			Reusable_Functions.EnterTextBox(Slt_MaxTicketSize,list.get(11));
			/*Reusable_Functions.selectValue_New(driver,Slt_MinTicketSize,list.get(10),wait);
			Reusable_Functions.selectValue_New(driver,Slt_MaxTicketSize,list.get(11),wait);*/
			Reusable_Functions.selectValue_New(driver, Drp_Currency_New, list.get(12), wait);
			Reusable_Functions.linkClick(Link_Show_More);
			Reusable_Functions.EnterTextBox(Slt_MinResidualTenor,list.get(13));
			Reusable_Functions.EnterTextBox(Slt_MaxResidualTenor,list.get(14));
			/*Reusable_Functions.selectValue_New(driver,Slt_MinResidualTenor,list.get(13),wait);
			Reusable_Functions.selectValue_New(driver,Slt_MaxResidualTenor,list.get(14),wait);*/
			if(!list.get(15).contentEquals("Any"))
			{
				Reusable_Functions.selectValue_New(driver, Drp_Transfer_Type_New, list.get(15), wait);
			}
			if(!list.get(16).contentEquals("Any"))
			{
				Reusable_Functions.selectValue_New(driver, Drp_Seniority, list.get(16), wait);
			}
			if(!list.get(17).contentEquals("Any"))
			{
				Reusable_Functions.selectValue_New(driver, Drp_Form_Market_Type, list.get(17), wait);
			}
			if(!list.get(18).contentEquals("Any"))
			{
				Reusable_Functions.selectValue_New(driver, Drp_Form_Green_Loans, list.get(18), wait);
			}
			if(!list.get(19).contentEquals("Any"))
			{
				Reusable_Functions.selectValue_New(driver, Drp_Form_Security, list.get(19), wait);
			}
			if(!list.get(20).contentEquals("Any"))
			{
				Reusable_Functions.selectValue_New(driver, Drp_Form_ECA, list.get(20), wait);
			}
			/*Reusable_Functions.selectValue_New(driver, Drp_Form_Green_Loans, list.get(18), wait);
			Reusable_Functions.selectValue_New(driver, Drp_Form_Security, list.get(19), wait);
			Reusable_Functions.selectValue_New(driver, Drp_Form_ECA, list.get(20), wait);
			*/
		}
	}

	public static void ValidateIOIInfo(WebDriver driver, WebDriverWait wait,List<String> list,String tradestatus) throws InterruptedException {
		System.out.println("*************Existence of More Options *******************"+ Link_Show_More.isDisplayed());
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Link_Show_More);
		//Reusable_Functions.ScrollElementtoView(driver,wait,Link_Show_More);
			//Reusable_Functions.linkClick(Link_Show_More);
		if(tradestatus.contentEquals("Create"))
		{
			Reusable_Functions.ValidateTextBox(Txt_IOIName,list.get(1));
		}
		else if(tradestatus.contentEquals("Amend"))
		{
			Reusable_Functions.ValidateTextBox(Txt_IOIName,list.get(1)+list.get(21));
		}

		Reusable_Functions.ValidateDropDownSelectedValue(Drp_Industry,list.get(4));
		Reusable_Functions.ValidateDropDownSelectedValue(Drp_CountryOfRisk,list.get(5));
		Reusable_Functions.ValidateDropDownSelectedValue(Drp_Purpose_New,list.get(6));
		Reusable_Functions.ValidateDropDownSelectedValue(Slt_MinSpread,list.get(7));
		Reusable_Functions.ValidateDropDownSelectedValue(Slt_MaxSpread,list.get(8));
		Reusable_Functions.ValidateDropDownSelectedValue(Drp_FacilityType_New, list.get(9));
		Reusable_Functions.ValidateDropDownSelectedValue(Slt_MinTicketSize,list.get(10));
		Reusable_Functions.ValidateDropDownSelectedValue(Slt_MaxTicketSize,list.get(11));
		Reusable_Functions.ValidateDropDownSelectedValue(Drp_Currency_New, list.get(12));
		Reusable_Functions.ValidateDropDownSelectedValue(Slt_MinResidualTenor,list.get(13));
		Reusable_Functions.ValidateDropDownSelectedValue(Slt_MaxResidualTenor,list.get(14));
		Reusable_Functions.ValidateDropDownSelectedValue(Drp_Transfer_Type_New, list.get(15));
		Reusable_Functions.ValidateDropDownSelectedValue(Drp_Seniority, list.get(16));
		Reusable_Functions.ValidateDropDownSelectedValue(Drp_Form_Market_Type, list.get(17));
		Reusable_Functions.ValidateDropDownSelectedValue(Drp_Form_Green_Loans, list.get(18));
		Reusable_Functions.ValidateDropDownSelectedValue(Drp_Form_Security, list.get(19));
		Reusable_Functions.ValidateDropDownSelectedValue(Drp_Form_ECA, list.get(20));
	}

	public static void matchingPreference(WebDriver driver, WebDriverWait wait,List<String> list) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(Drp_ParentCountry));
		Reusable_Functions.SelectDropDown(driver, Drp_ParentCountry,list.get(0));
		//Reusable_Functions.SelectDropDown(driver, Drp_InvestorType,list.get(1));
		Reusable_Functions.selectValue_New(driver, Drp_InvestorType_New, list.get(1), wait);
		//Reusable_Functions.SelectDropDown(driver, Drp_FilterOutCounterParties,list.get(2));
		
	}
	
	public static void validateSuccessfulSaveDraftMsg(WebDriver driver,List<String> list,WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(actual_Message));
		String actualMsg = Reusable_Functions.waitForElementToAppear(driver, actual_Message);
		Reusable_Functions.validateElement(actualMsg, list.get(0));
		
		
		
	}
	
	public static void validateSuccessfulSubmitMsg(WebDriver driver,List<String> list,WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(actual_Message));
		String actualMsg = Reusable_Functions.waitForElementToAppear(driver, actual_Message);
		Reusable_Functions.validateElement(actualMsg, list.get(0));
		
		
		
	}

	public static void ValidateMandatoryFields(WebDriver driver,WebDriverWait wait,List<String> list) {
		System.out.println("Table Count"+ list.size());
		int i;
		for(i=0;i<list.size()-1;i++)
		{
			System.out.println("Fields "+ driver.findElement(By.xpath("//*[text()='"+list.get(i)+" is required']")).getText());
			Assert.assertTrue(driver.findElement(By.xpath("//*[text()='"+list.get(i)+" is required']")).isDisplayed());
		}
	}

	public static void EnterRefintivBorrower(WebDriver driver,WebDriverWait wait,List<String> list) throws InterruptedException {
		Reusable_Functions.ScrollElementtoView(driver,wait,Drp_Borrower);
		Reusable_Functions.Borrower(driver,wait,Drp_Borrower,list.get(0),"ioi-form-borrower");
	}

	public static void Validate_Field_AutoPopulate_NonEditable(WebDriver driver,WebDriverWait wait,List<String> list) {
		int i;
			for(i=1;i<=list.size()-1;i++)
			{
				//System.out.println("Actual "+ driver.findElements(By.xpath("//label[text()='"+list.get(0)+"']/following-sibling::div/div/div/div/span")).get(i-1).getText() +"Expected    "+list.get(i) );
				Assert.assertEquals(driver.findElements(By.xpath("//label[text()='"+list.get(0)+"']/following-sibling::div/div/div/div/span")).get(i-1).getText(),list.get(i));
			}
	}

	public static void saveDraft(WebDriver driver,WebDriverWait wait) {
		Reusable_Functions.ButtonClick(Btn_SaveDraft);
		Reusable_Functions.ScrollElementtoView(driver,wait,Rdbtn_IOI);
	}

	public static void submit(WebDriver driver,WebDriverWait wait) throws InterruptedException {

		Reusable_Functions.ButtonClick(Btn_IOISubmit);
		wait.until(ExpectedConditions.visibilityOf(OrdersPage_BuyTable));
		//Thread.sleep(10000);
	}

	public static void AmendIOI(WebDriver driver, WebDriverWait wait, List<String> list) throws InterruptedException {

		Reusable_Functions.EnterTextBox(Txt_IOIName,list.get(1));
		Reusable_Functions.DatePicker(driver,wait,Date_GoodUntil,list.get(2));
		wait.until(ExpectedConditions.elementToBeClickable(Drp_Industry));
		Reusable_Functions.selectValue_New(driver, Drp_Industry, list.get(4), wait);
		//Thread.sleep(10000);
		Reusable_Functions.selectValue_New(driver, Drp_Industry, list.get(5), wait);


		wait.until(ExpectedConditions.elementToBeClickable(Drp_CountryOfRisk));
		Reusable_Functions.selectValue_New(driver, Drp_CountryOfRisk, list.get(6), wait);
		Reusable_Functions.selectValue_New(driver, Drp_CountryOfRisk, list.get(7), wait);

		wait.until(ExpectedConditions.elementToBeClickable(Drp_Purpose_New));
		Reusable_Functions.selectValue_New(driver,Drp_Purpose_New,list.get(8), wait);
		Reusable_Functions.selectValue_New(driver,Drp_Purpose_New,list.get(9), wait);

		Reusable_Functions.selectValue_New(driver,Slt_MaxSpread,list.get(11),wait);
		Reusable_Functions.selectValue_New(driver,Slt_MinSpread,list.get(10),wait);

		Reusable_Functions.selectValue_New(driver, Drp_FacilityType_New, list.get(12), wait);
		Reusable_Functions.selectValue_New(driver, Drp_FacilityType_New, list.get(13), wait);

		Reusable_Functions.selectValue_New(driver,Slt_MaxTicketSize,list.get(15),wait);
		Reusable_Functions.selectValue_New(driver,Slt_MinTicketSize,list.get(14),wait);

		Reusable_Functions.selectValue_New(driver, Drp_Currency_New, list.get(16), wait);
		Reusable_Functions.selectValue_New(driver, Drp_Currency_New, list.get(17), wait);

		//Reusable_Functions.linkClick(Link_Show_More);
		Reusable_Functions.selectValue_New(driver,Slt_MaxResidualTenor,list.get(19),wait);
		Reusable_Functions.selectValue_New(driver,Slt_MinResidualTenor,list.get(18),wait);

		Reusable_Functions.selectValue_New(driver, Drp_Transfer_Type_New, list.get(20), wait);
		Reusable_Functions.selectValue_New(driver, Drp_Transfer_Type_New, list.get(21), wait);

		Reusable_Functions.selectValue_New(driver, Drp_Seniority, list.get(22), wait);
		Reusable_Functions.selectValue_New(driver, Drp_Seniority, list.get(23), wait);

		Reusable_Functions.selectValue_New(driver, Drp_Form_Market_Type, list.get(24), wait);
		Reusable_Functions.selectValue_New(driver, Drp_Form_Green_Loans, list.get(25), wait);
		Reusable_Functions.selectValue_New(driver, Drp_Form_Security, list.get(26), wait);
		Reusable_Functions.selectValue_New(driver, Drp_Form_ECA, list.get(27), wait);
		Reusable_Functions.ButtonClick(Btn_ModifyIOIOrder);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Are you sure you want to modify your IOI?']")));
		Reusable_Functions.ButtonClick(Btn_ConfirmModifyIOIOrder);



	}

	public static void CancelIOI(WebDriver driver, WebDriverWait wait) {
		Reusable_Functions.ButtonClick(Btn_CancelIOIOrder);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Are you sure you want to delete your IOI?']")));
		Reusable_Functions.ButtonClick(Btn_ConfirmModifyIOIOrder);


	}

	public static void ValidateCancelIOI(WebDriver driver, WebDriverWait wait, List<String> list) {



		Reusable_Functions.ValidateTextBox(Txt_IOIName,list.get(0)+list.get(1));
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,'IoiForm__disabled')]")).isDisplayed());

	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	