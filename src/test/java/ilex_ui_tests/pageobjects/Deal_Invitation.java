package ilex_ui_tests.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ilex_ui_tests.step_definitions.Reusable_Functions;

import java.util.List;

//import jdk.internal.org.jline.utils.Log;

public class Deal_Invitation {

	
	@FindBy(how=How.XPATH,using = "//div[text()='Your invitations to buy']//following::div[1]//div[@class='table-content']/div[1]")
	public static WebElement Tbl_Row1_InviotationtoBuy;

	@FindBy(how=How.XPATH,using = "//button[@id='invite-accept-invitation']/span[1]")
	public static WebElement Btn_AcceptInvitation;

	@FindBy(how=How.XPATH,using = "//button[@id='invite-decline-invitation']")
	public static WebElement Btn_DeclineInvitation;

	@FindBy(how=How.ID,using = "invite-size-of-interest")
	public static WebElement Txt_SizeofInterest;

	@FindBy(how=How.ID,using = "invite-level-of-interest")
	public static WebElement Drp_LevelofInterest;

	@FindBy(how=How.ID,using = "invite-estimated-decision-date")
	public static WebElement Date_DecisionDate;

	@FindBy(how=How.XPATH,using = "//div[text()='Deal subject to NDA']//following-sibling::div//input[@type='checkbox']")
	public static WebElement ChkBox_NDA;

	@FindBy(how=How.XPATH,using="//div[contains(@class,'AcceptInvitationHeader__borrower-name')]")
	public static WebElement Lbl_InvestorSelection_BuyerCompanyName;

	@FindBy(how=How.XPATH,using="//div[contains(text(),'My Sells')]/parent::div[1]//div[contains(@class,'DealsSummary__deal-summary-row')]")
	public static WebElement Tbl_Row_FirstSelDeal;

	@FindBy(how=How.XPATH,using="//div[contains(text(),'My Buys')]/parent::div[1]//div[contains(@class,'DealsSummary__deal-summary-row')]")
	public static WebElement Tbl_Row_FirstBuyDeal;

	@FindBy(how=How.XPATH,using="//div[contains(text(),'Dealing Room')]")
	public static WebElement Tab_DealingRoom;

	@FindBy(how=How.ID,using="secondary-bidding-size-of-interest")
	public static WebElement Txt_Bid_SizeofInterest;

	@FindBy(how=How.ID,using="secondary-bidding-price")
	public static WebElement Txt_Bid_Price;

	@FindBy(how=How.XPATH,using="//button[@id='secondary-bidding-submit']/span[1]")
	public static WebElement Btn_Bid;

	@FindBy(how=How.XPATH,using="//button[@id='secondary-bidding-accept']/span[1]")
	public static WebElement Btn_AcceptOffer;

	//@FindBy(how=How.XPATH,using="//button[@id='secondary-bidding-submit']/span[1]")
	@FindBy(how=How.XPATH,using="//span[text()='Offer']")
	public static WebElement Btn_Offer;

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Deal Room')]")
	public static WebElement Btn_DealingRoom_Seller;

	@FindBy(how=How.XPATH,using="//button[@id='secondary-confirmation-confirm']/span[1]")
	public static WebElement Btn_Seller_Confirm;

	@FindBy(how=How.XPATH,using="//div[contains(@class,'SecondaryConfirmation__content')]/p[1]")
	public static WebElement Lbl_BuyerDealConfirmation_Buyer_Seller;

	@FindBy(how=How.XPATH,using="//div[contains(@class,'SecondaryConfirmation__content')]/p[2]")
	public static WebElement Lbl_BuyerDealConfirmation_DealInfo1;

	@FindBy(how=How.XPATH,using="//div[contains(@class,'SecondaryConfirmation__content')]/p[3]")
	public static WebElement Lbl_BuyerDealConfirmation_DealInfo2;


	//div[contains(text(),'Dealing Room')]






	public static void SelectFirstRowDealInvitation(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(Tbl_Row1_InviotationtoBuy));
		Reusable_Functions.clickLink(driver,Tbl_Row1_InviotationtoBuy);
		wait.until(ExpectedConditions.elementToBeClickable(Btn_DeclineInvitation));
	}

	public static void EnterDealsInvitation_Info(WebDriver driver, WebDriverWait wait, List<String> list) throws InterruptedException {
		Reusable_Functions.EnterTextBox(Txt_SizeofInterest,list.get(0));
		Reusable_Functions.selectValue_New(driver, Drp_LevelofInterest, list.get(1), wait);
		Reusable_Functions.DatePicker(driver,wait,Date_DecisionDate,list.get(2));
	}

	public static void ClickNDA_Accept(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		Reusable_Functions.ScrollElementtoView(driver,wait,ChkBox_NDA);
		Reusable_Functions.clickLink(driver,ChkBox_NDA);
		Reusable_Functions.ScrollElementtoView(driver,wait,Lbl_InvestorSelection_BuyerCompanyName);
		//Thread.sleep(3000);
		Reusable_Functions.ButtonClick_New(driver,Btn_AcceptInvitation);


	}

	public static void SelectFirstSellDeral(WebDriver driver,WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(Tbl_Row_FirstSelDeal));
		Reusable_Functions.clickLink(driver,Tbl_Row_FirstSelDeal);

	}

	public static void SelectFirstBuyDeral(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(Tbl_Row_FirstBuyDeal));
		Reusable_Functions.clickLink(driver,Tbl_Row_FirstBuyDeal);
		wait.until(ExpectedConditions.elementToBeClickable(Tab_DealingRoom));
	}

	public static void DealingRoomTab(WebDriver driver, WebDriverWait wait) {
		Reusable_Functions.clickLink(driver,Tab_DealingRoom);
		wait.until(ExpectedConditions.visibilityOf(Txt_Bid_SizeofInterest));

	}

	public static void DealingRoomBuyer(WebDriver driver, WebDriverWait wait, List<String> list) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(Txt_Bid_Price));
		//Reusable_Functions.ClearTextBox(Txt_Bid_Price);
		//Reusable_Functions.ClearTextBox(Txt_Bid_SizeofInterest);
		Reusable_Functions.EditTextBox(Txt_Bid_Price,list.get(1));
		Reusable_Functions.EditTextBox(Txt_Bid_SizeofInterest,list.get(0));
		Thread.sleep(1000);

	}

	public static void ClickDealingRoomButton(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(Btn_DealingRoom_Seller));
		Reusable_Functions.ButtonClick(Btn_DealingRoom_Seller);
	}

	public static void DealingRoomSeller(WebDriver driver, WebDriverWait wait, List<String> list) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(Txt_Bid_Price));
		Reusable_Functions.EditTextBox(Txt_Bid_SizeofInterest,list.get(0));
		Reusable_Functions.EditTextBox(Txt_Bid_Price,list.get(1));


	}

	public static void DealingRoomTab_Seller(WebDriver driver, WebDriverWait wait) {
		Reusable_Functions.clickLink(driver,Tab_DealingRoom);
		wait.until(ExpectedConditions.elementToBeClickable(Btn_DealingRoom_Seller));
		Reusable_Functions.ButtonClick(Btn_DealingRoom_Seller);

	}

	public static void DealingRoomTab_Buyer(WebDriver driver, WebDriverWait wait) {
		Reusable_Functions.clickLink(driver,Tab_DealingRoom);


	}

	public static void DealingRoomClickBid(WebDriver driver, WebDriverWait wait) {
		Reusable_Functions.ButtonClick(Btn_Bid);

	}

	public static void DealingRoomClickAcceptOfer(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(Btn_AcceptOffer));
		Thread.sleep(2000);
		Reusable_Functions.ButtonClick(Btn_AcceptOffer);
		//Btn_AcceptOffer.click();
	}

	public static void Seller_Confirm(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(Btn_Seller_Confirm));
		Reusable_Functions.ButtonClick(Btn_Seller_Confirm);

	}

	public static void Buyer_Confirm(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(Btn_Seller_Confirm));
		Reusable_Functions.ButtonClick(Btn_Seller_Confirm);
	}

	public static void ValidateDealConfirmation(WebDriver driver, WebDriverWait wait,List<String> list) {

		wait.until(ExpectedConditions.visibilityOf(Lbl_BuyerDealConfirmation_Buyer_Seller));
		Assert.assertEquals(list.get(0),Lbl_BuyerDealConfirmation_Buyer_Seller.getText());
		Assert.assertEquals(list.get(1),Lbl_BuyerDealConfirmation_DealInfo1.getText());
		Assert.assertEquals(list.get(2),Lbl_BuyerDealConfirmation_DealInfo2.getText());
		System.out.println("Deal confirmatioon text 1 ------------------>"+ Lbl_BuyerDealConfirmation_Buyer_Seller.getText());
		System.out.println("Deal confirmatioon text 2------------------>"+ Lbl_BuyerDealConfirmation_DealInfo1.getText());
		System.out.println("Deal confirmatioon text 2------------------>"+ Lbl_BuyerDealConfirmation_DealInfo2.getText());


	}

	public static void DealingRoomClickOfer(WebDriver driver, WebDriverWait wait) throws InterruptedException {

		Thread.sleep(2000);
		System.out.println("*************After Sleep***********");
		wait.until(ExpectedConditions.elementToBeClickable(Btn_Offer));
		System.out.println("*************After Wait***********");
		//Btn_Offer.click();
		Reusable_Functions.ButtonClick_New(driver,Btn_Offer);
		System.out.println("*************After Click***********");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='OFFER']")));
		System.out.println("*************After Offer Text***********");
	}
}
