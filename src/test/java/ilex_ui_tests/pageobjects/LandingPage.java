package ilex_ui_tests.pageobjects;
//import helpers.Log;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ilex_ui_tests.step_definitions.Reusable_Functions;

import java.awt.*;
import java.util.List;

	public class LandingPage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LandingPage.class);
	WebDriverWait wait  ;
	@FindBy(how=How.ID, using="search")
	public static WebElement Lnk_Home;
	@FindBy(how=How.XPATH, using="//ul[@class='list-graph']")
		public static WebElement Lst_Graph;
		@FindBy(how=How.ID, using="search")
		public static WebElement Txt_Search;
		@FindBy(how=How.XPATH, using="//a[text()='suggestions']")
		public static WebElement Lnk_Search;
		@FindBy(how=How.XPATH, using="//a[text()='report bugs / send pull requests']")
		public static WebElement Lnk_PullRequests;
		@FindBy(how=How.XPATH, using="//p[text()='repositories per programming language']")
		public static WebElement Lnk_RepositoryPerProgrammingLanguage;
		@FindBy(how=How.XPATH, using="//p[text()='active user groups']")
		public static WebElement Lnk_ActiveUser;
		@FindBy(how=How.XPATH, using="//p[text()='event locations']")
		public static WebElement Lnk_EventLocation;
		//*********************Login************************//
		@FindBy(how=How.XPATH, using="//input[@name='username']")
		public static WebElement Username;
		@FindBy(how=How.XPATH, using="//input[@name='password']")
		public static WebElement Password;
		@FindBy(how=How.XPATH, using="//span[text()='Log In']")
		public static WebElement Login;
		
		//*********************Logout*********************8//
		
		@FindBy(how=How.XPATH, using="//div[@id='root']/descendant::div/div[2]/div[1]/div[3]")
		public static WebElement Logout;
		
		//%%%%%%%%%%%%%%%%Ilex%%%%%%%%%%%%%
		
		@FindBy(how=How.XPATH, using="//*[contains(text(),'Order Capture')]")
		public static WebElement Lnk_OrderCapture;
		
		@FindBy(how=How.XPATH,using="//div[text()='Administration']/following-sibling::div")
		public static  WebElement Lnk_Administration;
		
		@FindBy(how=How.XPATH,using="//div[text()='Dashboard']")
		public static  WebElement Lnk_Dashboard;

		@FindBy(how=How.XPATH,using="//a[text()='Invitations']")
		public static  WebElement Lnk_Invitations;

		
		@FindBy(how=How.XPATH,using="//a[text()='My Loans']")
		public static  WebElement lnk_MyLoans;
		
		@FindBy(how = How.XPATH, using = "//*[text()='My Network']")
		public static WebElement Lnk_MyNetwork;
		
		@FindBy(how = How.XPATH, using = "//*[text()='Deals']")
		public static WebElement Lnk_Deals;
		
		@FindBy(how = How.XPATH, using = "//*[text()='Orders']")
		public static WebElement Lnk_Orders;

		@FindBy(how = How.XPATH, using = "//div[text()='Sell Order']//following-sibling::div/div[2]/div[1]")
		public static WebElement Row_First_SEC;
	//****************Place required to change when xpath or property changes


	public static void Navigate_LandingPage(WebDriver driver,String URL,String PageTitle) throws InterruptedException, AWTException {
		log.info("Class ------ LandingPage       Function -------Navigate_LandingPage");
		Reusable_Functions.Navigate(driver,URL);
		Reusable_Functions.waitForPageLoaded(driver);
		Thread.sleep(500);
		Reusable_Functions.ValidatePageTitle(driver,PageTitle);

	}
	
		public static void ClickOrderCapture(WebDriver driver,WebDriverWait wait) throws InterruptedException {
			log.info("Class ------ LandingPage       Function -------NavigatetoEventLocationPage");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(Lnk_OrderCapture));
			wait.until(ExpectedConditions.elementToBeClickable(Lnk_OrderCapture) );
			Reusable_Functions.linkClick(Lnk_OrderCapture);
			//Lnk_OrderCapture.click();
		}
		
		public static void ClickAdministration(WebDriverWait wait) {
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Loading... Please Wait...']")));
			wait.until(ExpectedConditions.visibilityOf(Lnk_Administration));
			Reusable_Functions.linkClick(Lnk_Administration);
			//Lnk_Administration.click();
			
		}
		public static void ClickDashboard(WebDriver driver,WebDriverWait wait) throws InterruptedException {
			wait.until(ExpectedConditions.visibilityOf(Lnk_Dashboard));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Lnk_Dashboard);
			Thread.sleep(500);
			//Reusable_Functions.linkClick(Lnk_Dashboard);
		}

		public static void ClickInvitations(WebDriver driver,WebDriverWait wait) throws InterruptedException {
			wait.until(ExpectedConditions.visibilityOf(Lnk_Invitations));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Lnk_Invitations);
			//Thread.sleep(10000);
			//Reusable_Functions.linkClick(Lnk_Dashboard);
		}

		public static void ClickMyLoans(WebDriverWait wait) {
			wait.until(ExpectedConditions.elementToBeClickable(lnk_MyLoans));
			lnk_MyLoans.click();
			
		}
		public static void ClickMyNetworks(WebDriverWait wait) {
			wait.until(ExpectedConditions.elementToBeClickable(Lnk_MyNetwork));
			Lnk_MyNetwork.click();
			
		}
		public static void ClickDeals(WebDriver driver,WebDriverWait wait) {
			wait.until(ExpectedConditions.elementToBeClickable(Lnk_Deals));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Lnk_Deals);
			//Lnk_Deals.click();
		}
		public static void ClickOrders(WebDriver driver,WebDriverWait wait) {
			wait.until(ExpectedConditions.elementToBeClickable(Lnk_Orders));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Lnk_Orders);
			//Lnk_Orders.click();

		}
		
		public static void login(WebDriverWait wait,List<String> list) throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(Username));
		    Assert.assertTrue(Username.isDisplayed());
			Reusable_Functions.EnterTextBox(Username, list.get(0));
			Reusable_Functions.EnterTextBox(Password, list.get(1));
			Reusable_Functions.ButtonClick(Login);
			//Thread.sleep(1000000);
		}
		public static void logout(WebDriver driver,WebDriverWait wait) throws InterruptedException {
			Thread.sleep(1000);
			//Reusable_Functions.ScrollElementtoView(driver, wait, Logout);
			wait.until(ExpectedConditions.elementToBeClickable(Logout));
		    Assert.assertTrue(Logout.isDisplayed());
			Reusable_Functions.ButtonClick_New(driver,Logout);
			
		}


		public static void SortSEC(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		WebElement SellOrderTable = driver.findElement(By.xpath("//div[text()='Sell Order']//following-sibling::div/div"));
		wait.until(ExpectedConditions.visibilityOf(SellOrderTable));
		Reusable_Functions.ScrollElementtoView(driver,wait,SellOrderTable);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)", "");
		WebElement Sort = driver.findElement(By.xpath("//div[text()='Sell Order']//following-sibling::div/div//span[text()='Last modified']//following-sibling::img"));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Sort);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Sort);
			Thread.sleep(500);

		}

		public static void SelectFirstSEC(WebDriver driver, WebDriverWait wait,String Status) throws InterruptedException {
		if(Status.contentEquals("Active"))
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Row_First_SEC);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath("//span[contains(text(),'Modify Order')]"))));

		}
		else if(Status.contentEquals("Cancel"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Cancelled')]")));
			WebElement e = driver.findElement(By.xpath("//*[contains(text(),'Cancelled')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
			LandingPage.SortSEC(driver,wait);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", Row_First_SEC);
		}

			}
	}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	