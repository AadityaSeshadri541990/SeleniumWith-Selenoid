package ilex_ui_tests.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ilex_ui_tests.step_definitions.Reusable_Functions;

public class SEC {
	 final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SEC.class);
	 
	 @FindBy(how= How.XPATH, using="//*[text()='Sell']")
		public static WebElement Btn_Sell;
	 @FindBy(how= How.XPATH, using="//*[text()='Launch a Primary Syndication (SYN)']")
		public static WebElement Rdbtn_SYN;
	 @FindBy(how= How.XPATH, using="//*[text()='Run a Secondary Sell down (SEC)']")
		public static WebElement Rdbtn_SEC;
	 @FindBy(how= How.XPATH, using="//*[text()='Distribute Axes (AXE)']")
		public static WebElement Rdbtn_AXE;
	 @FindBy(how= How.XPATH, using="//input[@id='sell-sec-form-parent-country']//following-sibling::div/button//following-sibling::button")
		public static WebElement Drp_SECParentCountry;
	 @FindBy(how= How.XPATH, using="//input[@id='sell-sec-form-investor-type']//following-sibling::div/button//following-sibling::button")
		public static WebElement Drp_SECInvestorType;
	 @FindBy(how= How.XPATH, using="//input[@id='sell-sec-form-filter-out-counterparties']//following-sibling::div/button//following-sibling::button")
		public static WebElement Drp_SECFilterOutCounterParty;
	 @FindBy(how= How.XPATH, using="//span[contains(text(),'Save Draft')]")
		public static WebElement Btn_SaveDraft;
	 @FindBy(how= How.XPATH, using="//span[contains(text(),'Submit Order')]")
		public static WebElement Btn_SubmitOrder;
	 @FindBy(how=How.XPATH,using="//input[@id='sell-sec-form-select-asset-autocomplete']//following-sibling::div/button//following-sibling::button")
	 public static WebElement Drp_Asset;

	@FindBy(how=How.XPATH,using="//input[@id='pri-syn-form-select-asset-autocomplete']//following-sibling::div/button//following-sibling::button")
	public static WebElement Drp_Asset_SYN;

	 @FindBy(how=How.XPATH,using="//input[@id='sell-sec-form-select-asset-spread']")
	 public static WebElement Text_AllInSpread;
	 @FindBy(how=How.XPATH,using="//input[@id='sell-sec-form-select-asset-size']")
	 public static WebElement Text_SizeIndication;
	 @FindBy(how=How.XPATH,using="//input[@id='sell-sec-form-select-asset-min-ticket']")
	 public static WebElement Text_MinTicket;

	@FindBy(how=How.XPATH,using="//input[@id='pri-syn-form-select-asset-min-ticket']")
	public static WebElement Text_SYN_MinTicket;


	 @FindBy(how= How.ID, using="sell-sec-form-select-asset-invitation-validity")
	public static WebElement Invitation_Validity;

	@FindBy(how= How.ID, using="pri-syn-form-select-commitment-deadline")
	public static WebElement SYN_Date_CommitmentDeadline;

	@FindBy(how= How.ID, using="sell-sec-form-select-asset-closing-date")
	public static WebElement TargetClosing_Date;
	@FindBy(how= How.ID, using="pri-syn-form-select-target-closing-date")
	public static WebElement SYN_TargetClosing_Date;

	 @FindBy(how=How.XPATH,using="//span[text()='Borrower Name']//following-sibling::span")
	 public static WebElement BorrowerName_Value;
	 @FindBy(how=How.XPATH,using="//span[text()='Guarantor']//following-sibling::span")
	 public static WebElement Guarantor_Value;
	 @FindBy(how=How.XPATH,using="//span[text()='Industry']//following-sibling::span")
	 public static WebElement Industry_Value;
	 @FindBy(how=How.XPATH,using="//span[text()='Country of Risk']//following-sibling::span")
	 public static WebElement CountryofRisk_Value;
	 @FindBy(how=How.XPATH,using="//span[text()='Facility Type']//following-sibling::span")
	 public static WebElement FacilityType_Value;
	 @FindBy(how=How.XPATH,using="//span[text()='Purpose']//following-sibling::span")
	 public static WebElement Purpose_Value;
	 @FindBy(how=How.XPATH,using="//span[text()='Maturity Date']//following-sibling::span")
	 public static WebElement Maturity_Date_Value;
	 @FindBy(how=How.XPATH,using="//span[text()='Amount']//following-sibling::span")
	 public static WebElement Amount_Value;
	 @FindBy(how=How.XPATH,using="//span[text()='Margin']//following-sibling::span")
	 public static WebElement Margin_Value; 
	 @FindBy(how=How.XPATH,using="//input[@id='sell-sec-form-select-asset-autocomplete']")
	 public static WebElement duplicateAsset;

	@FindBy(how= How.XPATH, using="//*[text()='Generic Success Message!']")
	public static WebElement actual_Message;

	@FindBy(how = How.XPATH,using = "//div[contains(@class,'SelectAsset__loan-information-table')]")
	public static WebElement Table_SEC_Info;

	@FindBy(how = How.XPATH,using = "//div[contains(@class,'SelectAsset__loan-information-table')]//span[text()='Borrower Name']//following-sibling::span")
	public static WebElement Table_SEC_Info_BorrowerName;

	@FindBy(how = How.XPATH,using = "//div[contains(@class,'SelectAsset__loan-information-table')]//span[text()='Guarantor']//following-sibling::span")
	public static WebElement Table_SEC_Info_Guarantor;

	@FindBy(how = How.XPATH,using = "//div[contains(@class,'SelectAsset__loan-information-table')]//span[text()='Industry']//following-sibling::span")
	public static WebElement Table_SEC_Info_Industry;

	@FindBy(how = How.XPATH,using = "//div[contains(@class,'SelectAsset__loan-information-table')]//span[text()='Country of Risk']//following-sibling::span")
	public static WebElement Table_SEC_Info_Country_of_Risk;

	@FindBy(how = How.XPATH,using = "//div[contains(@class,'SelectAsset__loan-information-table')]//span[text()='Facility Type']//following-sibling::span")
	public static WebElement Table_SEC_Info_Facility_Type;

	@FindBy(how = How.XPATH,using = "//div[contains(@class,'SelectAsset__loan-information-table')]//span[text()='Purpose']//following-sibling::span")
	public static WebElement Table_SEC_Info_Purpose;

	@FindBy(how = How.XPATH,using = "//div[contains(@class,'SelectAsset__loan-information-table')]//span[text()='Amount']//following-sibling::span")
	public static WebElement Table_SEC_Info_Amount;

	@FindBy(how = How.XPATH,using = "//div[contains(@class,'SelectAsset__loan-information-table')]//span[text()='Margin']//following-sibling::span")
	public static WebElement Table_SEC_Info_Margin;

	@FindBy(how = How.XPATH,using = "//div[text()='Deal Description']//following-sibling::div")
	public static WebElement Table_SEC_Info_Deal_Description;

	@FindBy(how = How.XPATH,using = "//span[text()='Modify Order']")
	public static WebElement Btn_ModifyOrder;

	@FindBy(how = How.XPATH, using = "//*[text()='Confirm']")
	public static WebElement Btn_ConfirmModifySECOrder;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Cancel Order')]")
	public static WebElement Btn_CancelSECOrder;






	public static void ValidateSEC(WebDriver driver, WebDriverWait wait,List<String> list) {
		wait.until(ExpectedConditions.visibilityOf(Table_SEC_Info));
		Assert.assertEquals(Table_SEC_Info_BorrowerName.getText(),list.get(0));
		Assert.assertEquals(Table_SEC_Info_Guarantor.getText(),list.get(1));
		Assert.assertEquals(Table_SEC_Info_Industry.getText(),list.get(2));
		Assert.assertEquals(Table_SEC_Info_Country_of_Risk.getText(),list.get(3));
		Assert.assertEquals(Table_SEC_Info_Facility_Type.getText(),list.get(4));
		Assert.assertEquals(Table_SEC_Info_Purpose.getText(),list.get(5));
		Assert.assertEquals(Table_SEC_Info_Amount.getText(),list.get(6)+" "+list.get(7));//AUD 100
		Assert.assertEquals(Table_SEC_Info_Margin.getText(),list.get(8)+" "+"bps");
		Assert.assertEquals(Table_SEC_Info_Deal_Description.getText(),list.get(9));
		Reusable_Functions.ValidateTextBox(Text_AllInSpread,list.get(10));
		Reusable_Functions.ValidateTextBox(Text_SizeIndication,list.get(11));
		Reusable_Functions.ValidateTextBox(Text_MinTicket,list.get(12));

	}

	public static void ValidateSYN(WebDriver driver, WebDriverWait wait,List<String> list) {
		wait.until(ExpectedConditions.visibilityOf(Table_SEC_Info));
		Assert.assertEquals(Table_SEC_Info_BorrowerName.getText(),list.get(0));
		Assert.assertEquals(Table_SEC_Info_Guarantor.getText(),list.get(1));
		Assert.assertEquals(Table_SEC_Info_Industry.getText(),list.get(2));
		Assert.assertEquals(Table_SEC_Info_Country_of_Risk.getText(),list.get(3));
		Assert.assertEquals(Table_SEC_Info_Facility_Type.getText(),list.get(4));
		Assert.assertEquals(Table_SEC_Info_Purpose.getText(),list.get(5));
		Assert.assertEquals(Table_SEC_Info_Amount.getText(),list.get(6)+" "+list.get(7));//AUD 100
		Assert.assertEquals(Table_SEC_Info_Margin.getText(),list.get(8)+" "+"bps");
		Assert.assertEquals(Table_SEC_Info_Deal_Description.getText(),list.get(9));
		Reusable_Functions.ValidateTextBox(Text_SYN_MinTicket,list.get(10));

	}



	 public static void SelectSell() throws InterruptedException {
			Reusable_Functions.ButtonClick(Btn_Sell);
			//Thread.sleep(5000);
		}
	 public static void ValidateSEC_REQ() {
			Assert.assertTrue(Rdbtn_SYN.isDisplayed());
			Assert.assertTrue(Rdbtn_SEC.isDisplayed());
			Assert.assertTrue(Rdbtn_AXE.isDisplayed());

		}
	 public static void SelectSEC(WebDriver driver,WebDriverWait wait) {
			Reusable_Functions.ButtonClick(Rdbtn_SEC);
			wait.until(ExpectedConditions.elementToBeClickable(Drp_Asset));
			
			Reusable_Functions.ScrollElementtoView(driver,wait,Drp_Asset);
			
			//System.out.println("###########");
		}
	 public static void selectAsset(WebDriver driver,WebDriverWait wait,List<String> list) throws InterruptedException {
		 Reusable_Functions.Borrower(driver,wait,Drp_Asset,list.get(0),"sell-sec-form-select-asset-autocomplete");
		 //Thread.sleep(10000);
	 }
	 
	 public static void validateLoanInformation(WebDriver driver,List<String> listLoanInfo) {
		 String borrowerValueActXpath = BorrowerName_Value.getText();
		  String guarantorValueActXpath = Guarantor_Value.getText();
		  String industryValueActXpath =Industry_Value.getText();
		  String countryOfRiskValueActXpath = CountryofRisk_Value.getText();
		  String facilityTypeValueActXpath = FacilityType_Value.getText();
		  String purposeValueActXpath = Purpose_Value.getText();
		  String maturityDateValueActXpath = Maturity_Date_Value.getText();
		  String  amountActValueXpath = Amount_Value.getText();
		  String marginActValueXpath =  Margin_Value.getText();
		  
		//Validate Loan information against expected Value 
		 
		  Reusable_Functions.validateElement(borrowerValueActXpath, listLoanInfo.get(0));
		  Reusable_Functions.validateElement(guarantorValueActXpath, listLoanInfo.get(1));
		  	Reusable_Functions.validateElement(industryValueActXpath, listLoanInfo.get(2));
		  Reusable_Functions.validateElement(countryOfRiskValueActXpath, listLoanInfo.get(3));
		  Reusable_Functions.validateElement(facilityTypeValueActXpath, listLoanInfo.get(4));
		  Reusable_Functions.validateElement(purposeValueActXpath, listLoanInfo.get(5));
		  Reusable_Functions.validateElement(maturityDateValueActXpath, listLoanInfo.get(6));
		  Reusable_Functions.validateElement(amountActValueXpath, listLoanInfo.get(7));
		  Reusable_Functions.validateElement(marginActValueXpath, listLoanInfo.get(8));
		 
		 
		 
	 }
	
	 public static void SYNtradeInformation(WebDriver driver,List<String> list,WebDriverWait wait) throws InterruptedException {

			Reusable_Functions.EnterTextBox(Text_SYN_MinTicket, list.get(0));
			Reusable_Functions.DatePicker(driver, wait, SYN_Date_CommitmentDeadline,list.get(1));
			wait.until(ExpectedConditions.elementToBeClickable(SYN_TargetClosing_Date));
			Reusable_Functions.DatePicker(driver, wait,SYN_TargetClosing_Date,list.get(2));
			Reusable_Functions.ScrollElementtoView(driver,wait,Btn_SubmitOrder);
			
		}

	public static void tradeInformation(WebDriver driver,List<String> list,WebDriverWait wait) throws InterruptedException {
		Reusable_Functions.EnterTextBox(Text_AllInSpread, list.get(0));
		Reusable_Functions.EnterTextBox(Text_SizeIndication, list.get(1));
		Reusable_Functions.EnterTextBox(Text_MinTicket, list.get(2));
		//Thread.sleep(5000);
		Reusable_Functions.DatePicker(driver, wait, Invitation_Validity,list.get(3));
		wait.until(ExpectedConditions.elementToBeClickable(TargetClosing_Date));
		//	Reusable_Functions.ScrollElementtoView(driver,wait,TargetClosing_Date);
		//Thread.sleep(500);
		Reusable_Functions.DatePicker(driver, wait,TargetClosing_Date,list.get(4));
		//	Reusable_Functions.ScrollElementtoView(driver,wait,Drp_SECParentCountry);
		//	Thread.sleep(5000);
		Reusable_Functions.ScrollElementtoView(driver,wait,Btn_SubmitOrder);

	}


	 public static void matchingInformation(WebDriver driver,List<String> list,WebDriverWait wait) throws InterruptedException {
		    Reusable_Functions.SelectDropDown(driver, Drp_SECParentCountry,list.get(0));
			Reusable_Functions.SelectDropDown(driver, Drp_SECInvestorType,list.get(1));
		//	Reusable_Functions.SelectDropDown(driver, Drp_SECFilterOutCounterParty,list.get(2));
			Reusable_Functions.ScrollElementtoView(driver,wait,Btn_SaveDraft);
		 
	 }
	
	 
	 
	 public static void saveDraft() {
		 Reusable_Functions.ButtonClick(Btn_SaveDraft);
		 //Reusable_Functions.ScrollElementtoView();
	 }
	 public static void submitOrder(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		// Reusable_Functions.ScrollElementtoView(driver,wait,Btn_SubmitOrder);
		 Reusable_Functions.ButtonClick_New(driver,Btn_SubmitOrder);
		 //wait.until(ExpectedConditions.visibilityOf(actual_Message));
		 //Thread.sleep(10000);

	 }


	public static void AmendSEC(WebDriver driver, WebDriverWait wait, List<String> list) throws InterruptedException
	{
		System.out.println("**********************Amend SEC*******************");

		Reusable_Functions.EditTextBox(Text_AllInSpread,list.get(0));
		Reusable_Functions.EditTextBox(Text_SizeIndication,list.get(1));
		Reusable_Functions.EditTextBox(Text_MinTicket,list.get(2));
		Reusable_Functions.ButtonClick(Btn_ModifyOrder);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Are you sure you want to modify your SEC?']")));
		Reusable_Functions.ButtonClick(Btn_ConfirmModifySECOrder);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'DealsInformationHeader__borrower')]")));
	}

	public static void AmendSYN(WebDriver driver, WebDriverWait wait, List<String> list) throws InterruptedException
	{
		System.out.println("**********************Amend SEC*******************");

		Reusable_Functions.EditTextBox(Text_SYN_MinTicket,list.get(0));
		Reusable_Functions.ButtonClick(Btn_ModifyOrder);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Are you sure you want to modify your PRI?']")));
		Reusable_Functions.ButtonClick(Btn_ConfirmModifySECOrder);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'DealsInformationHeader__borrower')]")));
	}

	public static void CancelSEC(WebDriver driver, WebDriverWait wait) {
		Reusable_Functions.ButtonClick(Btn_CancelSECOrder);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Are you sure you want to delete your PRI?']")));
		Reusable_Functions.ButtonClick(Btn_ConfirmModifySECOrder);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'DealsInformationHeader__borrower')]")));

	}

	public static void ValidateCancelSEC(WebDriver driver, WebDriverWait wait) {
		//Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,'SecForm__disabled')]")).isDisplayed());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'SynForm__disabled')]")));
		Assert.assertEquals(1,driver.findElements(By.xpath("//*[contains(@class,'SynForm__disabled')]")).size());
	}

	public static void SelectSYN(WebDriver driver, WebDriverWait wait) {
		Reusable_Functions.ButtonClick(Rdbtn_SYN);
		wait.until(ExpectedConditions.elementToBeClickable(Drp_Asset_SYN));
		Reusable_Functions.ScrollElementtoView(driver,wait,Drp_Asset_SYN);
	}
}
