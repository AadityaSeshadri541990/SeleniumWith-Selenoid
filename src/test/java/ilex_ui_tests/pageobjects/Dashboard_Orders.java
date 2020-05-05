package ilex_ui_tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ilex_ui_tests.step_definitions.Reusable_Functions;

public class Dashboard_Orders {
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Buy Order')]//following-sibling::div/div[2]")
	public static WebElement Table_BuyOrder;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Modify Order')]")
	public static WebElement Btn_ModifyIOIOrder;

	@FindBy(how = How.XPATH, using = "//div[text()='Buy Order']//following-sibling::div/div[2]/div[1]")
	public static WebElement Row_First_IOI;

	public static void SelectIOI(WebDriver driver, String IOIName, WebDriverWait wait,String tab) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(Table_BuyOrder));

		if(tab.contentEquals("Cancel"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Cancelled')]")));
			WebElement e = driver.findElement(By.xpath("//*[contains(text(),'Cancelled')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
		}
		Thread.sleep(500);
		System.out.println("************After Wait until Table_BuyOrder*********");
		WebElement BuyOrderTable = driver.findElement(By.xpath("//div[text()='Buy Order']//following-sibling::div/div"));
		Reusable_Functions.ScrollElementtoView(driver,wait,BuyOrderTable);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)", "");
		WebElement Sort = driver.findElement(By.xpath("//div[text()='Buy Order']//following-sibling::div/div//span[text()='Last modified']//following-sibling::img"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Sort);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Sort);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Row_First_IOI);
		Thread.sleep(500);
		if(tab.contentEquals("Active"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[contains(text(),'Modify Order')]"))));
		}




		/*String Xpath = "//*[contains(text(),'Buy Order')]//following-sibling::div/div[2]//div[text()='"+IOIName+"']";
		Reusable_Functions.SelectTablerow(driver,Xpath);
		System.out.println("************after Select Row*********");
		if(tab.contentEquals("Active"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(Btn_ModifyIOIOrder));
		}
*/


		//Thread.sleep(5000);
	}
}

