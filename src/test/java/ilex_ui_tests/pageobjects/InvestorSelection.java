package ilex_ui_tests.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import jdk.internal.org.jline.utils.Log;
import ilex_ui_tests.step_definitions.Reusable_Functions;

public class InvestorSelection {
	public static String AssetName;
	public static String trancheName;
	
	@FindBy(how=How.XPATH,using = "//*[text()='SING TLA SGD0m Apr21 1Y']")
	public static WebElement assetName;
	
	@FindBy(how=How.XPATH,using="(//*[text()='ABC Financial Leasing Co Ltd'])[1]")
	public static WebElement shortlistedInvestor;
	
	@FindBy(how=How.XPATH,using="//span[text()='Add Tranche']")
	public static WebElement AddTranche;
	

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Back')]//*[local-name()='svg']//*[name()='path' and contains(@fill,'currentCol')]")
	public static WebElement BackBtn;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='sell-sec-form-select-asset-autocomplete']//following-sibling::div/button//following-sibling::button")
	 public static WebElement Drp_Asset;

	@FindBy(how=How.XPATH,using="//input[@id='pri-syn-form-select-asset-autocomplete']//following-sibling::div/button//following-sibling::button")
	public static WebElement Drp_Asset_SYN;
	
	@FindBy(how=How.XPATH, using="//div[@id='root']/descendant::div/div[2]/div[1]/div[3]")
	public static WebElement Logout;
	
	@FindBy(how= How.XPATH, using="//*[text()='Generic Success Message!']")
	public static WebElement actual_Message;
	
	@FindBy(how=How.XPATH,using="//div[contains(@class,'tranche-title')]")
	public static WebElement generated_TrancheTitle;
	
	 @FindBy(how=How.XPATH,using="//input[@id='sell-sec-form-select-asset-autocomplete']")
	 public static WebElement duplicateAsset;
	 
	 @FindBy(how=How.XPATH,using="//div[@id='ACTIVE']")
	 public static WebElement activeOrders;
	 
	 @FindBy(how=How.XPATH,using="//div[text()='Loan Creation']")
	 public static WebElement LoanCreation;

	@FindBy(how=How.XPATH,using="//div[contains(@class,'DealsInformationHeader__owner')]/div/div")
	public static WebElement Lbl_InvestorSelection_OwnerCompanyName;

	@FindBy(how=How.XPATH,using="//div[contains(@class,'InvestorSelectionTable-____TableRow')]/div/div/div[2]/div[1]")
	public static WebElement Lbl_InvestorSelection_BuyerCompanyName;

	@FindBy(how=How.XPATH,using="//div[contains(@class,'InvestorSelectionTable-____TableRow')]/div/div[4]")
	public static WebElement Lbl_InvestorSelection_Status;

	@FindBy(how=How.XPATH,using="//h2[contains(@class,'DealsInformationHeader__borrower-name')]")
	public static WebElement Lbl_InvestorSelection_BorrowerName;

	@FindBy(how=How.XPATH,using="//div[contains(@class,'DealsInformationHeader__tranche-name')]/span[1]")
	public static WebElement Lbl_InvestorSelection_TrancheName;

	@FindBy(how=How.XPATH,using="//div[contains(@class,'InvestorSelectionTable-____TableRow')]/div/div/div[2]/div[1]/parent::div/parent::div[1]/child::div[1]//input[@type='checkbox']")
	public static WebElement Chkbox_InvestorSelection_SelectBuyer;

	@FindBy(how=How.XPATH,using="//button[@id='deals-investor-refresh-button']")
	public static WebElement Btn_InvestorSelection_Invite;

	@FindBy(how=How.XPATH,using="//button[@id='invitation-to-buy-invite-button']/span[1]")
	public static WebElement Btn_InvestorSelection_InvitationToBuy_Invite;

	@FindBy(how=How.XPATH,using="//input[@id='loan-information-borrower-name']")
	public static WebElement ChkBox_InvestorSelection_BorrowerName;

	@FindBy(how=How.XPATH,using="//input[@id='trade-information-all-in-spread']")
	public static WebElement ChkBox_InvestorSelection_Spread;

	@FindBy(how=How.XPATH,using="//textarea[@id='trade-information-comments']")
	public static WebElement Txt_InvestorSelection_Spread;


	@FindBy(how=How.XPATH,using="//*[@data-icon='envelope']/parent::div")
	public static WebElement Btn_Envelope;

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Onboard')]")
	public static WebElement Btn_Onboard;


	//*[@data-icon='envelope']












	public static void validateAssetName(WebDriver driver,List<String> list,WebDriverWait wait) {
		Reusable_Functions.ScrollElementtoView(driver, wait, AddTranche);
		AssetName = assetName.getText();
		String ActualValue = AssetName;
       // Log.info(AssetName);
	    Reusable_Functions.waitForElementToAppear(driver, assetName);
		Reusable_Functions.validateElement(ActualValue, list.get(0));
	}
	public static void selectCreatedAsset(WebDriver driver,WebDriverWait wait) throws InterruptedException {
	//	Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(Drp_Asset));
		Assert.assertTrue("Element is not displayed", Drp_Asset.isDisplayed());
		
		AssetName = assetName.getText();
		String ActualValue = AssetName;
		System.out.println("aSSET NAME"+ AssetName);
		
		 Reusable_Functions.Borrower(driver, wait, Drp_Asset, AssetName,"sell-sec-form-select-asset-autocomplete");
		 Reusable_Functions.ScrollElementtoView(driver, wait,assetName );
	}
	public static String captureTrancheName(WebDriver driver,WebDriverWait wait) {
		//Reusable_Functions.ScrollElementtoView(driver, wait, AddTranche);
		//trancheName = Reusable_Functions.getTrancheName(generated_TrancheTitle);
		trancheName = "AGRI RCF AUD0m Apr21 1Y";
		System.out.println("Tranche Name : "+trancheName);
		return trancheName;
	}
	
	public static void SelectAsset(WebDriver driver,WebDriverWait wait) throws InterruptedException {
	//	Reusable_Functions.selectAsset(driver, wait, Drp_Asset,"sell-sec-form-select-asset-autocomplete",trancheName,duplicateAsset,generated_TrancheTitle);
	//	Reusable_Functions.Borrower(driver, wait, Drp_Asset, trancheName, "sell-sec-form-select-asset-autocomplete");
	//	Reusable_Functions.BorrowerMultiple(driver, wait, Drp_Asset, trancheName,"sell-sec-form-select-asset-autocomplete");
		String ID  = "sell-sec-form-select-asset-autocomplete";
		Reusable_Functions.BorrowerMult(driver, wait, Drp_Asset,trancheName,ID);
	}

	public static void SelectAsset_SYN(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		Reusable_Functions.BorrowerMult(driver, wait, Drp_Asset_SYN,trancheName, "pri-syn-form-select-asset-autocomplete");
	}
	public static void Validate_TrancheName(WebDriverWait wait) {
		Assert.assertTrue(assetName.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(assetName));
	}
	public static void validate_ShortlistedInvestors(WebDriverWait wait,List<String> list) {
		wait.until(ExpectedConditions.visibilityOf(shortlistedInvestor));
		String actualValue = shortlistedInvestor.getText();
		Assert.assertEquals(list.get(0), actualValue);
		
	}
	public static void selectAssetAndInput(WebDriver driver,WebDriverWait wait) {
		Reusable_Functions.createAndInputAsset(driver, wait, Drp_Asset, "sell-sec-form-select-asset-autocomplete");
	}

	public static void selectAssetAndInput_SYN(WebDriver driver,WebDriverWait wait) {
		Reusable_Functions.createAndInputAsset(driver, wait, Drp_Asset_SYN, "pri-syn-form-select-asset-autocomplete");
	}

	public static void clickBackBtn(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		Thread.sleep(1000);
		Reusable_Functions.ScrollElementtoView(driver, wait, LoanCreation);
		Assert.assertTrue("Element not visible", BackBtn.isDisplayed());
	//	Reusable_Functions.clickLink(driver, BackBtn);
		wait.until(ExpectedConditions.visibilityOf(BackBtn));
		Reusable_Functions.ButtonClick(BackBtn);
	}
	public static void navigateActiveOrders() {
		Reusable_Functions.ButtonClick(activeOrders);
	}
	public static void validationMatchingEngine(WebDriver driver,List<String> list) throws InterruptedException {
	//	Reusable_Functions.iterateTable(driver,list.get(0));
		Reusable_Functions.iterateTable(driver, list.get(0), trancheName);
		
	}
	public static void selectOrder(WebDriver driver,List<String> list) throws InterruptedException {
		//	Reusable_Functions.iterateTable(driver,list.get(0));
			Reusable_Functions.selectIOIName(driver, list.get(0));
			
		}
	public static void inputorder(WebDriver driver,List<String> list) throws InterruptedException {
		//	Reusable_Functions.iterateTable(driver,list.get(0));
			Reusable_Functions.selectIOIName(driver, list.get(0));
			
		}


	public static void ValidateBuyerSellerName(WebDriver driver,WebDriverWait wait,List<String> list) throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(Lbl_InvestorSelection_BuyerCompanyName));
		Assert.assertEquals(list.get(0),Lbl_InvestorSelection_BuyerCompanyName.getText());
		Assert.assertEquals(list.get(1),Lbl_InvestorSelection_OwnerCompanyName.getText());
		//Lbl_InvestorSelection_OwnerCompanyName

	}

	public static void ValidateStatus(WebDriver driver,WebDriverWait wait,String status) {
		wait.until(ExpectedConditions.visibilityOf(Lbl_InvestorSelection_Status));
		Assert.assertEquals(status,Lbl_InvestorSelection_Status.getText());

	}

	public static void ValidateBorrowerTrancheName(WebDriver driver, List<String> list) {
		Assert.assertEquals(list.get(0),Lbl_InvestorSelection_BorrowerName.getText());
		Assert.assertEquals(trancheName,Lbl_InvestorSelection_TrancheName.getText());

	}

	public static void InviteBuyer(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		Reusable_Functions.clickLink(driver,Chkbox_InvestorSelection_SelectBuyer);
		Reusable_Functions.ButtonClick(Btn_InvestorSelection_Invite);
		wait.until(ExpectedConditions.elementToBeClickable(Btn_InvestorSelection_InvitationToBuy_Invite));


		//Thread.sleep(10000);
		//Chkbox_InvestorSelection_SelectBuyer.click();

	}

	public static void ToggleLoanInfo(WebDriver driver, WebDriverWait wait)
	{
		Reusable_Functions.clickLink(driver,ChkBox_InvestorSelection_BorrowerName);
		Reusable_Functions.clickLink(driver,ChkBox_InvestorSelection_Spread);


	}

	public static void EnterComments(WebDriver driver, WebDriverWait wait, List<String> list)
	{
		Reusable_Functions.EnterTextBox(Txt_InvestorSelection_Spread,list.get(0));

	}

	public static void ClickInvitetoBuy(WebDriver driver, WebDriverWait wait) {
		Reusable_Functions.ScrollElementtoView(driver,wait,Lbl_InvestorSelection_BorrowerName);
		Reusable_Functions.ButtonClick(Btn_InvestorSelection_InvitationToBuy_Invite);

	}

	public static void ClicktoOnboard(WebDriver driver, WebDriverWait wait) {

		Reusable_Functions.clickLink(driver,Btn_Envelope);
		wait.until(ExpectedConditions.elementToBeClickable(Btn_Onboard));

	}

	public static void OnboardBuyer(WebDriver driver, WebDriverWait wait) {
		Reusable_Functions.clickLink(driver,Btn_Onboard);
	}
}
