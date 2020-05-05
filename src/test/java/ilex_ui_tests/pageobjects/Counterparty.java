package ilex_ui_tests.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import ilex_ui_tests.step_definitions.Reusable_Functions;

public class Counterparty {
	
	@FindBy(how = How.XPATH, using = "//*[text()='My Network']")
	public static WebElement Network_lnk;
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'My Network')]")
	public static WebElement Validate_MyNetwork;
	
	@FindBy(how = How.XPATH, using = "//input[@id='my-network-input-search']")
	public static WebElement SearchBar_Counterparty;
	
	@FindBy(how = How.XPATH, using = "//div[@id='my-network-contacts-tab']")
	public static WebElement ContactsTab_Counterparty;
	
	@FindBy(how = How.XPATH, using = "//div[@id='my-network-groups-tab']")
	public static WebElement GroupsTab_Counterparty;
		
	@FindBy(how = How.XPATH, using = "//span[text()='Create Group']")
	public static WebElement CreateGroup_Counterparty;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Add Contact']")
	public static WebElement Add_Contact;

	@FindBy(how = How.XPATH, using = "//h1[text()='Add new contact']")
	public static WebElement AddNew_Contact;

	@FindBy(how = How.XPATH, using = "//input[@id='contact-modal-firstName']")
	public static WebElement FirstName;

	@FindBy(how = How.XPATH, using = "//input[@id='contact-modal-lastName']")
	public static WebElement LastName;

	@FindBy(how = How.XPATH, using = "//input[@id='contact-modal-title']")
	public static WebElement Title;

	@FindBy(how = How.XPATH, using = "//input[@id='contact-modal-company']")
	public static WebElement Company;
			
    @FindBy(how = How.XPATH, using = "//input[@id='contact-modal-country']")
	public static WebElement Country;

	@FindBy(how = How.XPATH, using = "//input[@id='contact-modal-emailAddress']")
	public static WebElement Email;

	@FindBy(how = How.XPATH, using = "//input[@id='contact-modal-officeNumber']")
	public static WebElement Office_Number;

	@FindBy(how = How.XPATH, using = "//input[@id='contact-modal-mobileNumber']")
	public static WebElement Mobile_Number;

	@FindBy(how = How.XPATH, using = "//button[@id='contact-modal-cancel']")
	public static WebElement Cancel_button;

	@FindBy(how = How.XPATH, using = "//button[@id='contact-modal-submit']")
	public static WebElement Create_button;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Create Group')]")
	public static WebElement Create_group;
	
	@FindBy(how = How.XPATH, using = "//button[@id='group-modal-submit']")
	public static WebElement Create_Button_group;
	
	@FindBy(how = How.XPATH, using = "//button[@id='group-modal-cancel']")
	public static WebElement Cancel_Button_group;
	
	@FindBy(how = How.XPATH, using = "//h2[text()='Create group']")
	public static WebElement Validate_Create_group;
	
	@FindBy(how = How.XPATH, using = "//input[@id='group-modal-groupName']")
	public static WebElement Group_Name;

	@FindBy(how = How.XPATH, using = "//input[@id='group-modal-contactsList']")
	public static WebElement Group_ContactList;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'2QhJa')]//span)[3]//img[1]")
	public static WebElement Modify_Pen;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'ftK-9')])[4]//img[1]")
	public static WebElement Modify_Pen_User;
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Edit contact')]")
	public static WebElement EditContact_Window;
	
	@FindBy(how = How.XPATH, using = "//button[@id='contact-modal-submit']")
	public static WebElement Click_EditBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='my-network-groups-tab']")
	public static WebElement Click_GroupsTab;
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Edit group')]")
	public static WebElement EditGroup_Window;
	
	@FindBy(how = How.XPATH, using = "//input[@id='group-modal-groupName']")
	public static WebElement GroupName;
	
	@FindBy(how = How.XPATH, using = "//button[@id='group-modal-submit']")
	public static WebElement Click_EditGroupBtn;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Loading... Please Wait...']")
	public static WebElement Loading_Page;
			
			//Validate My Network Page
			public static void ValidateMyNetworkPage(WebDriverWait wait) throws InterruptedException {
				wait.until(ExpectedConditions.visibilityOf(Validate_MyNetwork));
				Assert.assertTrue(Validate_MyNetwork.isDisplayed());

			}
			public static void Click_AddContact() {
			 Reusable_Functions.ButtonClick(Add_Contact);
			}
			public static void Validate_AddNewContactWindow(WebDriverWait wait) {
				Assert.assertTrue(AddNew_Contact.isDisplayed());
				wait.until(ExpectedConditions.visibilityOf(AddNew_Contact));
			}
			public static void Contact_Details(WebDriver driver,WebDriverWait wait,List<String> list) throws InterruptedException {
				Reusable_Functions.EnterTextBox(FirstName, list.get(0));
				Reusable_Functions.EnterTextBox(LastName, list.get(1));
				Reusable_Functions.EnterTextBox(Title, list.get(2));
				Reusable_Functions.EnterTextBox(Company, list.get(3));
				Reusable_Functions.ScrollElementtoView(driver, wait, Country);
				Reusable_Functions.SelectDropDown(driver, Country,list.get(4));
				Reusable_Functions.EnterTextBox(Email, list.get(5));
				Reusable_Functions.ScrollElementtoView(driver, wait, Create_button);
				Reusable_Functions.EnterTextBox(Office_Number, list.get(6));
				Reusable_Functions.EnterTextBox(Mobile_Number, list.get(7));
			}	
			public static void Click_CreateBtn() throws InterruptedException {
				 Reusable_Functions.ButtonClick(Create_button);
				 Thread.sleep(500);
				 Reusable_Functions.ButtonClick(Cancel_button);
				}
			public static void Click_CancelBtn()  {
				 Reusable_Functions.ButtonClick(Cancel_button);
				}
			public static void Click_CreateGrp() {
				 Reusable_Functions.ButtonClick(Create_group);
				}
			public static void Click_CreateBtnGrp(WebDriverWait wait) throws InterruptedException {
				//wait.until(ExpectedConditions.elementToBeClickable(Create_Button_group));
				//Thread.sleep(5000);
				Reusable_Functions.ButtonClick(Create_Button_group);
				}
			public static void Click_CancelBtnGrp() {
				 Reusable_Functions.ButtonClick(Cancel_Button_group);
				}			
			public static void Validate_GroupWindow(WebDriverWait wait) {
				Assert.assertTrue(Validate_Create_group.isDisplayed());
				wait.until(ExpectedConditions.visibilityOf(Validate_Create_group));
				}
			public static void Enter_GroupDetails(WebDriver driver,WebDriverWait wait,List<String> list) throws InterruptedException {
				Reusable_Functions.EnterTextBox(Group_Name, list.get(0));
			//	Assert.assertTrue(Group_ContactList.isDisplayed());
			//	wait.until(ExpectedConditions.elementToBeClickable(Group_ContactList));
				Reusable_Functions.SelectDropDown(driver, Group_ContactList, list.get(1));
				}	
			public static void ModifyUserValue(WebDriver driver,List<String> list,WebDriverWait wait) throws InterruptedException {
				Reusable_Functions.EnterTextBox(SearchBar_Counterparty,list.get(0));	
				Thread.sleep(2000);
				Reusable_Functions.selectGridValue(driver, list.get(0));
				Reusable_Functions.ButtonClick(Modify_Pen_User);
				Assert.assertTrue(EditContact_Window.isDisplayed());
				wait.until(ExpectedConditions.visibilityOf(EditContact_Window));
				Reusable_Functions.EnterTextBox(FirstName,list.get(1));
				Reusable_Functions.ScrollElementtoView(driver, wait, Click_EditBtn);
				Reusable_Functions.ButtonClick(Click_EditBtn);
				//validation part is pending for modify value for user
			}
			public static void Click_GroupsTab() {
				Reusable_Functions.ButtonClick(Click_GroupsTab);
				}	
			public static void ModifyGroupValue(WebDriver driver,List<String> list,WebDriverWait wait) throws InterruptedException {
				Reusable_Functions.EnterTextBox(SearchBar_Counterparty,list.get(0));	
				Thread.sleep(2000);
				Reusable_Functions.selectGridValue(driver, list.get(0));
				Reusable_Functions.ButtonClick(Modify_Pen);
				Assert.assertTrue(EditGroup_Window.isDisplayed());
				wait.until(ExpectedConditions.visibilityOf(EditGroup_Window));
				Reusable_Functions.EnterTextBox(GroupName,list.get(1));
				Reusable_Functions.ScrollElementtoView(driver, wait, Click_EditGroupBtn);
				Reusable_Functions.ButtonClick(Click_EditGroupBtn);
				//validation part is pending for modify value for group
				}	
			public static void NavigateToGroupTab(WebDriver driver,WebDriverWait wait) throws InterruptedException {
				Reusable_Functions.waitForElementToAppear(driver, Loading_Page);
			// info(Loading_Page.getText());
				Thread.sleep(2000);
				Assert.assertTrue(Cancel_Button_group.isDisplayed());
				Reusable_Functions.ButtonClick(Cancel_Button_group);
				Reusable_Functions.ButtonClick(GroupsTab_Counterparty);
				}
}

