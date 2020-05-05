package ilex_ui_tests.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ilex_ui_tests.step_definitions.Reusable_Functions;

public class Listing {

	@FindBy(how = How.XPATH, using = "//span[text()='Loan details']")
	public static WebElement LoanDetails;

	@FindBy(how = How.XPATH, using = "//span[text()='Create Loan']")
	public static WebElement Btn_CreateLoan;


	@FindBy(how = How.XPATH, using = "//input[@id='create-loan-form-borrower-name']//following-sibling::div/div//following-sibling::button")
	public static WebElement Drp_BorrowerName;

	@FindBy(how = How.XPATH, using = "//input[@id='parentName']")
	public static WebElement ParentName;

	@FindBy(how = How.XPATH, using = "//div[@id='borrowerCountry']")
	public static WebElement BorrowerCountry;

	@FindBy(how = How.XPATH, using = "//input[@id='guarantorName']")
	public static WebElement GuarantorName;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Industry')]")
	public static WebElement ScrollIndustry;
	 

	@FindBy(how = How.XPATH, using = "//div[@id='borrowerIndustry']")
	public static WebElement BorrowerIndustry;

	@FindBy(how = How.XPATH, using = "//div[@id='countryOfRisk']")
	public static WebElement CountryOfRisk;

	@FindBy(how = How.XPATH, using = "//div[@id='borrowerRating']")
	public static WebElement PublicRating;

	@FindBy(how = How.XPATH, using = "//div[@id='borrowerIntRating']")
	public static WebElement InternalRating;

	@FindBy(how = How.XPATH, using = "//input[@id='issueDate']")
	public static WebElement IssueDate;

	@FindBy(how = How.XPATH, using = "//div[@id='purpose']")
	public static WebElement Purpose;

	@FindBy(how = How.XPATH, using = "//textarea[@id='description']")
	public static WebElement DescriptionArea;

	@FindBy(how = How.XPATH, using = "//label[@id='greenLoan-Yes']")
	public static WebElement GreenLoanYes;

	@FindBy(how = How.XPATH, using = "//label[@id='greenLoan-No']")
	public static WebElement GreenLoanNo;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add Tranche')]")
	public static WebElement AddTranche;

	// -------------------Add Tranche----------------------------------------

	@FindBy(how = How.XPATH, using = "//div[@id='mui-component-select-tranches[0][currency]']")
	public static WebElement TrancheCurrency;

	@FindBy(how = How.XPATH, using = "//input[@id='sell-axe-tranche-input-size']")
	public static WebElement TrancheAmount;

	@FindBy(how = How.XPATH, using = "//label[text()='Maturity Date']//following-sibling::div")
	public static WebElement TrancheMaturityDate;

	@FindBy(how = How.XPATH, using = "//div[@id='mui-component-select-tranches[0][repaymentType]']")
	public static WebElement RepaymentType;

	@FindBy(how = How.XPATH, using = "//div[@id='mui-component-select-tranches[0][facilityType]']")
	public static WebElement FacilityType;

	@FindBy(how = How.XPATH, using = "//div[@id='mui-component-select-tranches[0][seniority]']")
	public static WebElement seniority;

	@FindBy(how = How.XPATH, using = "(//label[@id='undefined-Yes'])[1]")
	public static WebElement ECA_BackedYes;

	@FindBy(how = How.XPATH, using = "(//label[@id='undefined-No'])[1]")
	public static WebElement ECA_BackedNo;
	
	@FindBy(how = How.XPATH, using = "(//label[@id='undefined-Yes'])[1]")
	public static WebElement SecuredYes;
	
	@FindBy(how = How.XPATH, using = "(//label[@id='undefined-No'])[2]")
	public static WebElement SecuredNo;

	@FindBy(how = How.XPATH, using = "//div[@id='mui-component-select-tranches[0][distributionMethod]']")
	public static WebElement DistrubutionMethod;

	@FindBy(how = How.XPATH, using = "//input[@name='tranches[0][margin]']")
	public static WebElement Margin;

	@FindBy(how = How.XPATH, using = "//input[@name='tranches[0][commitmentFee]']")
	public static WebElement CommitmentFee;

	@FindBy(how = How.XPATH, using = "//span[text()='Delete']")
	public static WebElement DeleteTranche;

	@FindBy(how = How.XPATH, using = "//button/span[text()='Activate']")
	public static WebElement ListTranche;

	@FindBy(how = How.XPATH, using = "//span[text()='List']")
	public static WebElement SaveListing;
	
	@FindBy(how = How.XPATH, using = "//div[text()='You have not created any tranches yet.']")
	public static WebElement AfterDeleteMsg;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Borrower Name is empty']")
	public static WebElement MandatoryChecks_Msg;

	@FindBy(how= How.XPATH, using="//*[text()='Tranche successfully activated']")
	public static WebElement TrancheSuccess_Message;

	public static void ValidateLoanDetailsScreen(WebDriverWait wait) {
		//wait.until(ExpectedConditions.elementToBeClickable(Btn_CreateLoan));
		//Reusable_Functions.ButtonClick(Btn_CreateLoan);
	}

	public static void InputLoanDetails(WebDriver driver,List<String> list,WebDriverWait wait)throws InterruptedException
	{
			//Reusable_Functions.Borrower(driver,wait, Drp_BorrowerName, list.get(11),"create-loan-form-borrower-name");
		    Reusable_Functions.Borrower(driver,wait, Drp_BorrowerName, list.get(0),"create-loan-form-borrower-name");
		    Reusable_Functions.EnterTextBox(ParentName,list.get(1));
		    Reusable_Functions.EnterTextBox(GuarantorName,list.get(3));
		    Assert.assertTrue("Element is not displayed", BorrowerCountry.isDisplayed());
		    wait.until(ExpectedConditions.elementToBeClickable(BorrowerCountry));
		    Reusable_Functions.selectValue_New(driver, BorrowerCountry, list.get(2), wait);
		    Assert.assertTrue("Element is not displayed", BorrowerIndustry.isDisplayed());
		    Reusable_Functions.ScrollElementtoView(driver, wait, BorrowerIndustry);
		    Reusable_Functions.selectValue_New(driver, BorrowerIndustry, list.get(4), wait);
		    Reusable_Functions.selectValue_New(driver, CountryOfRisk, list.get(5), wait);
		    Reusable_Functions.selectValue_New(driver, PublicRating, list.get(6), wait);
		    wait.until(ExpectedConditions.elementToBeClickable(InternalRating));
		    Reusable_Functions.selectValue_New(driver, InternalRating, list.get(7), wait);
		    Reusable_Functions.DatePicker(driver, wait, IssueDate,list.get(8));
		    Reusable_Functions.selectValue_New(driver, Purpose, list.get(9), wait);
		    wait.until(ExpectedConditions.elementToBeClickable(DescriptionArea));
		    Reusable_Functions.EnterTextBox(DescriptionArea,list.get(10));	    
	}

	public static void Click_AddTranche(WebDriver driver,List<String> list,WebDriverWait wait) throws InterruptedException {
		Reusable_Functions.ButtonClick(AddTranche);
		Assert.assertTrue("Element is not displayed", TrancheCurrency.isDisplayed());
		Reusable_Functions.ScrollElementtoView(driver, wait, TrancheCurrency);
		Reusable_Functions.selectValue_New(driver, TrancheCurrency, list.get(0), wait);
			Reusable_Functions.EnterTextBox(TrancheAmount, list.get(1));
		Reusable_Functions.DatePicker(driver, wait, TrancheMaturityDate, list.get(2));
		Reusable_Functions.selectValue_New(driver, RepaymentType, list.get(3), wait);
		Reusable_Functions.selectValue_New(driver, FacilityType, list.get(4), wait);
		Reusable_Functions.selectValue_New(driver, seniority, list.get(5), wait);
		Assert.assertTrue("Element is not displayed", ECA_BackedYes.isDisplayed());
	    Reusable_Functions.ScrollElementtoView(driver, wait, ECA_BackedYes);
	    Reusable_Functions.ButtonClick_New(driver,ECA_BackedYes);
	    Reusable_Functions.ButtonClick_New(driver,SecuredYes);
	    Reusable_Functions.selectValue_New(driver, DistrubutionMethod,list.get(6), wait);
	    wait.until(ExpectedConditions.elementToBeClickable(Margin));
	    Reusable_Functions.EnterTextBox(Margin, list.get(7));
	  //  Reusable_Functions.EnterTextBox(CommitmentFee, list.get(8));
	    Reusable_Functions.ScrollElementtoView(driver, wait, ListTranche);
	   		
	}
	public static void InputLoanDetailsMEngine(WebDriver driver,List<String> list,WebDriverWait wait)throws InterruptedException
	{
			//Reusable_Functions.Borrower(driver,wait, Drp_BorrowerName, list.get(11),"create-loan-form-borrower-name");
		    Reusable_Functions.Borrower(driver,wait, Drp_BorrowerName, list.get(0),"create-loan-form-borrower-name");
		    Reusable_Functions.EnterTextBox(ParentName,list.get(1));
		    Reusable_Functions.EnterTextBox(GuarantorName,list.get(3));
		    Assert.assertTrue("Element is not displayed", BorrowerCountry.isDisplayed());
		    wait.until(ExpectedConditions.elementToBeClickable(BorrowerCountry));
		    Reusable_Functions.selectValue_New(driver, BorrowerCountry, list.get(2), wait);
		    Assert.assertTrue("Element is not displayed", BorrowerIndustry.isDisplayed());
		    Reusable_Functions.ScrollElementtoView(driver, wait, BorrowerIndustry);
		    if(!list.get(4).contentEquals(""))
			{
				Reusable_Functions.selectValue_New(driver, BorrowerIndustry, list.get(4), wait);
			}
			if(!list.get(5).contentEquals(""))
			{
				Reusable_Functions.selectValue_New(driver, CountryOfRisk, list.get(5), wait);
			}
		//Reusable_Functions.selectValue_New(driver, CountryOfRisk, list.get(5), wait);
		    Reusable_Functions.selectValue_New(driver, PublicRating, list.get(6), wait);
		    wait.until(ExpectedConditions.elementToBeClickable(InternalRating));
		    Reusable_Functions.selectValue_New(driver, InternalRating, list.get(7), wait);
		    Reusable_Functions.DatePicker(driver, wait, IssueDate,list.get(8));
		    Reusable_Functions.selectValue_New(driver, Purpose, list.get(9), wait);
		    wait.until(ExpectedConditions.elementToBeClickable(DescriptionArea));
		    Reusable_Functions.EnterTextBox(DescriptionArea,list.get(10));	
		    
	}
	public static void ClickTrancheList(WebDriverWait wait) {
		 wait.until(ExpectedConditions.visibilityOf(ListTranche));
	//	 Assert.assertTrue("Element is not displayed", ListTranche.isDisplayed());
		 Reusable_Functions.ButtonClick(ListTranche);
	}
	public static void DeleteTranche() {
		 Reusable_Functions.ButtonClick(DeleteTranche);
	}
	public static void ValidateDeletedTranche(List<String> list) {
		String actualText = AfterDeleteMsg.getText();
		Reusable_Functions.validateElement(actualText, list.get(0));
	}
	public static void ClickAddTranche_Listing(WebDriver driver,WebDriverWait wait) {
		Assert.assertTrue("Element is not displayed", AddTranche.isDisplayed());
		Reusable_Functions.ScrollElementtoView(driver, wait, AddTranche);
		 Reusable_Functions.ButtonClick(AddTranche);
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


	public static void ValidateActivateTrancheMessage(WebDriver driver, List<String> list, WebDriverWait wait) {

		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+list.get(0)+"']")));
		WebElement ele = driver.findElement(By.xpath("//*[text()='"+list.get(0)+"']"));
		String actualMsg = Reusable_Functions.waitForElementToAppear(driver, ele);
		Reusable_Functions.validateElement(actualMsg, list.get(0));*/
	}
}
