package ilex_ui_tests.step_definitions;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Reusable_Functions {
   // public static WebDriverWait wait = Hooks.wait;
    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Reusable_Functions.class);
    public static HashMap<String, String> hashMap = new HashMap<String, String>();
    public static String[]  hd;
    public static void Take_Screenshot(WebDriver driver, Scenario scenario)
    {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
    public static void Set_PreRequisites(Scenario scenario) throws IOException {
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"//log"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"//log"));
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"+scenario.getName()));
        PropertyConfigurator.configure("log4j.properties");


    }

    public static void AddStepLogToReport(String message)
    {
        com.cucumber.listener.Reporter.addStepLog(message);
    }

    public static void AddScenarioLogToReport(String message)
    {
        com.cucumber.listener.Reporter.addScenarioLog(message);
    }

    public static  void ClearTextBox(WebElement element)
    {
        element.clear();
       log.info("Function----ClearTextBox----Element----------"+ element.getAttribute("innerText") + "Value is cleared");
    }

    public static  void EnterTextBox(WebElement element,String Text)
    {
        element.sendKeys(Text);
        log.info("Function ----EnterTextBox----Element----------"+ element.getAttribute("innerText")  + "Value entered as-------"+ Text);
    }

    public static  void ValidateTextBox(WebElement element,String Text)
    {
        System.out.println("***************element text **********"+ element.getAttribute("value"));
        Assert.assertEquals(element.getAttribute("value"),Text);
        //log.info("Function ----EnterTextBox----Element----------"+ element.getAttribute("innerText")  + "Value entered as-------"+ Text);
    }

    public static void ButtonClick(WebElement element) {
        element.click();
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", row);
        //log.info("Element----------"+ element.getAttribute("value")  + "Button Clicked");
    }

    public static void ButtonClick_New(WebDriver driver,WebElement element) {
       // element.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        //log.info("Element----------"+ element.getAttribute("value")  + "Button Clicked");
    }


	public static void Navigate(WebDriver driver, String uRL) throws InterruptedException, AWTException {
        driver.manage().deleteAllCookies();
        driver.get(uRL);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.alertIsPresent());
//        System.out.println("***************1****************");
//        Alert alert = driver.switchTo().alert();
//        System.out.println("***************2****************");
//        System.out.println("Is Alert Detecrted"+ alert.getText());
//        Actions a = new Actions(driver);
//
//        Thread.sleep(1000);
//        a.sendKeys(Keys.chord("aaaasasassa"));
        //alert.sendKeys(String.valueOf(Keys.TAB));
        //alert.authenticateUsing(new UserAndPassword("sdsdsdsdsd",""));
        //alert.sendKeys(Keys.chord("sdsdsdsdsd"));
        //alert.sendKeys("dmsjd;osjdopjsd;od;oksodk;lskdksd");
        System.out.println  ("***************3****************");
       //alert.sendKeys(Keys.chord("s,bkjsbdkskhskhdkhsdshds"));

    //    alert.accept();


        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //alert.authenticateUsing(new UserAndPassword("abc@comp.com",""));
       driver.manage().window().maximize() ;
        log.info("Function ----Navigate----Navigated to Page and Maximized");

    }
    
 
	public static void waitForPageLoaded(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
        log.info("Function ----waitForPageLoaded----Synchronized untill Page Loaded");
	}

    public static void ValidatePageTitle(WebDriver driver, String pageTitle) {
        //System.out.println("Title of Page --------"+ driver.getTitle());
        System.out.println("Title of Page------------------->"+driver.getTitle());
        Assert.assertEquals(pageTitle.trim(),driver.getTitle().trim());
        //driver.getTitle().contentEquals(pageTitle);
        log.info("Function ----ValidatePageTitle----Page Title is Validated");
    }

    public static void DatePicker(WebDriver driver,WebDriverWait wait,WebElement date_goodUntil, String s) throws InterruptedException
    {
        int expectedmonth=0;
        int presentmonth=Calendar.getInstance().get(Calendar.MONTH);
        presentmonth +=1;
         String[] tempArray;
        String delimiter = "-";
        tempArray = s.split(delimiter, -1);
        switch(tempArray[1])
        {
            case "January":
                expectedmonth=1;
                break;
            case "February":
                expectedmonth=2;
                break;
            case "March":
                expectedmonth=3;
                break;
            case "April":
                expectedmonth=4;
                break;
            case "May":
                expectedmonth=5;
                break;
            case "June":
                expectedmonth=6;
                break;
            case "July":
                expectedmonth=7;
                break;
            case "August":
                expectedmonth=8;
                break;
            case "September":
                expectedmonth=9;
                break;
            case "October":
                expectedmonth=10;
                break;
            case "November":
                expectedmonth=11;
                break;
            case "December":
                expectedmonth=12;
                break;
        }

        date_goodUntil.click();
        driver.findElement(By.xpath("//*[@class ='MuiTypography-root MuiPickersToolbarText-toolbarTxt MuiTypography-subtitle1']")).click();
       driver.findElement(By.xpath("//*[@class ='MuiPickersYearSelection-container']/child::div[text()='"+tempArray[0]+"']")).click();
        while(!driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-alignCenter']")).getText().contentEquals(tempArray[1]+" "+tempArray[0]))
        {
            if(expectedmonth<presentmonth)
            {
                driver.findElement(By.xpath("//div[@class='MuiPickersSlideTransition-transitionContainer MuiPickersCalendarHeader-transitionContainer']//parent::div/button")).click();

            }
            else
            {
                driver.findElement(By.xpath("//div[@class='MuiPickersSlideTransition-transitionContainer MuiPickersCalendarHeader-transitionContainer']//following-sibling::button")).click();
            }
            Thread.sleep(500);
        }
        List<WebElement> date =  driver.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body2 MuiTypography-colorInherit' and text()='"+tempArray[2]+"']"));
        //System.out.println("Count of date" + date.size());
        Actions actions = new Actions(driver);
        actions.click(date.get(0)).perform();
        if(driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersDay-day MuiPickersDay-daySelected']")).size()==0)
        {
            actions.click(date.get(1)).perform();
        }
        driver.findElement(By.xpath("//*[text()='OK']")).click();
        //Thread.sleep(10000);


    }

    public static void SelectDropDown(WebDriver driver, WebElement drp_borrower, String s) throws InterruptedException {

        String[] tempArray;
        String delimiter = "/";
        tempArray = s.split(delimiter, -1);
        System.out.println("Length"+ tempArray.length);
        for(int i=0;i<tempArray.length;i++)
        {
          //  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", drp_borrower);
        	drp_borrower.click();
            //Thread.sleep(50000);
           driver.findElement(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")).click();
         //  findElement.sendKeys(Keys.ESCAPE);
        }
    }
    
    public static void selectValue_New(WebDriver driver, WebElement slt_minSpread, String s,WebDriverWait wait) throws InterruptedException
    {
        String Jscript = "var clickEvent = document.createEvent ('MouseEvents');clickEvent.initEvent ('mousedown', true, true);arguments[0].dispatchEvent (clickEvent);";
        ((JavascriptExecutor) driver).executeScript(Jscript, slt_minSpread);
        Thread.sleep(500);
        WebElement findElement = driver.findElement(By.xpath("//ul[@role='listbox']//li[text()='"+s+"']"));
        findElement.click();
        findElement.sendKeys(Keys.ESCAPE);
    }

/*    public static void SelectValue(WebDriver driver, WebElement slt_minSpread, String s,WebDriverWait wait) throws InterruptedException
    {
        String Jscript = "var clickEvent = document.createEvent ('MouseEvents');clickEvent.initEvent ('mousedown', true, true);arguments[0].dispatchEvent (clickEvent);";
        ((JavascriptExecutor) driver).executeScript(Jscript, slt_minSpread);
        Thread.sleep(500);
        driver.findElement(By.xpath("//ul[@role='listbox']//li[text()='"+s+"']")).click();

    }*/
    public static void Borrower(WebDriver driver,WebDriverWait wait, WebElement drp_borrower, String s,String ID) throws InterruptedException {

        String[] tempArray;
        String delimiter = "/";
        tempArray = s.split(delimiter, -1);
        System.out.println("Length"+ tempArray.length);
        for(int i=0;i<tempArray.length;i++)
        {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", drp_borrower);
            System.out.println("@@@@@@@@@@@");
            driver.findElement(By.id(ID)).sendKeys(s);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")));
            driver.findElement(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")).click();
          //  driver.findElement(By.xpath("(//*[contains(text(),'"+tempArray[i]+"')])[1]")).click();
        }
        
    }
    public static void BorrowerMultiple(WebDriver driver,WebDriverWait wait, WebElement drp_borrower, String s,String ID) throws InterruptedException {

        String[] tempArray;
        String delimiter = "/";
        tempArray = s.split(delimiter, -1);
        System.out.println("Length"+ tempArray.length);
        for(int i=0;i<tempArray.length;i++)
        {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", drp_borrower);
            System.out.println("@@@@@@@@@@@");
          //  driver.findElement(By.id(ID)).sendKeys(s);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")));
            driver.findElement(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")).click();
            
        }
    }
    /*public static void BorrowerMult(WebDriver driver,WebDriverWait wait, WebElement drp_borrower,String s,String ID) throws InterruptedException {

        String[] tempArray;
        String delimiter = "/";
        tempArray = s.split(delimiter, -1);
        System.out.println("Length"+ tempArray.length);
        for(int i=0;i<tempArray.length;i++)
        {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", drp_borrower);
            System.out.println("@@@@@@@@@@@");
          //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")));
          //  WebElement elementx = driver.findElement(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]"));
            List<WebElement> lstDrp = driver.findElements(By.xpath("//*[text() ='"+tempArray[i]+"']"));
            System.out.println(lstDrp.get(0).getText());
            lstDrp.get(0).click();
            
          //*[contains(text(),'"+tempArray[i]+"')]
            //*(text() = '"+tempArray[i]+"')
        }
           // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")));
         //   driver.findElement(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")).click();
            
        }*/

    public static void BorrowerMult(WebDriver driver,WebDriverWait wait, WebElement drp_borrower,String s,String ID) throws InterruptedException {


            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", drp_borrower);
            System.out.println("@@@@@@@@@@@");
            //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")));
            //  WebElement elementx = driver.findElement(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]"));
            List<WebElement> lstDrp = driver.findElements(By.xpath("//*[text() ='"+s+"']"));
            System.out.println(lstDrp.get(0).getText());
            lstDrp.get(0).click();

    }

    
    public static void createAndInputAsset(WebDriver driver,WebDriverWait wait, WebElement assetDrpDown,String ID)
    {
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", assetDrpDown);
        driver.findElement(By.id(ID)).sendKeys("@@@@");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'+ Create Asset')]")));
        driver.findElement(By.xpath("//*[contains(text(),'+ Create Asset')]")).click();
       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create Loan']")));
    }
    

    public static void ScrollElementtoView(WebDriver driver,WebDriverWait wait, WebElement element)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }



    public static void linkClick(WebElement element) {
    	element.click();
    }
    
    public static void SelectAutoDropDown(WebDriver driver,WebElement element, String s) throws InterruptedException {

        String[] tempArray;
        String delimiter = ",";
        tempArray = s.split(delimiter, -1);
        System.out.println("Length"+ tempArray.length);
        for(int i=0;i<tempArray.length;i++)
        {
        	element.click();
            //Thread.sleep(500);
            driver.findElement(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")).click();

        }
    }
    public static void validateContainerValue(List<String> list1,List<String> list2,List<WebElement> wb) {
    		for(int i=0;i<list1.size();i++) {
    			if(list1.get(i)!=null){
    				for(int j=i;j<list2.size();j++) {
    					Assert.assertNotEquals(list2.get(j), wb);
    				}
    			}
    		}
    }
    public static void validateElement(String actualText,String expectedText) {
		Assert.assertEquals("Actual & Expected Values are not equal", expectedText, actualText);
		
    	}
    
    public static String loanXpath(WebDriver driver,String st) {
		WebElement textOfElement = driver.findElement(By.xpath("//span[text()='"+st+"']//following-sibling::span"));
		return textOfElement.getText();
    	}
    public static String waitForElementToAppear(WebDriver driver, WebElement element) {
    	try {
    		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
    				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

    		fluentWait.until(ExpectedConditions.visibilityOf(element));
    		String actualText = element.getText();
    		log.info(actualText);
    		return actualText;
    	} catch (Exception e) {
    		log.info("Error occured while waiting for element");
    		
    	}
		return null;
    }
    public static void selectGridValue(WebDriver driver,String s) {
    	List<WebElement> allGridValue = driver.findElements(By.xpath("//div[@class='src-pages-MyNetwork-___MyNetwork__my-network-table___3Altd']"));
    	for(WebElement wb: allGridValue ) {
    		if(wb.getText()==s) {
    			wb.click();
    		}
    	}
    }
    public static void clickLink(WebDriver driver,WebElement element) {
    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public static void selectAsset(WebDriver driver,WebDriverWait wait, WebElement assetDrpDown,String ID,String s,WebElement id,WebElement trancheName) throws InterruptedException
    {  
    //	((JavascriptExecutor) driver).executeScript("arguments[0].click();", assetDrpDown);
//    	Actions builder = new Actions(driver);
//    	System.out.println("#######^^^^^^&&&&&&&&&&&&");
//    	Thread.sleep(2000);
//    	builder.moveToElement(id).click().sendKeys(s).moveToElement(trancheName).click().build();
//    	Thread.sleep(2000);
//    	System.out.println("#######^^^^^^&&&&&&&&&&&&");
//    	builder.perform();	
//    }
    	//((JavascriptExecutor) driver).executeScript("arguments[0].click();", assetDrpDown);
    //	Thread.sleep(5000);
    //    driver.findElement(By.id(ID)).sendKeys(s);
        
//        String[] tempArray;
//        String delimiter = "/";
//        tempArray = s.split(delimiter, -1);
//        System.out.println("Length"+ tempArray.length);
//        for(int i=0;i<tempArray.length;i++)
//        {
//          //  System.out.println("@@@@@@@@@@@");
//            driver.findElement(By.id(ID)).sendKeys(s);
//           
//            Actions act = new Actions(driver);
//            act.moveToElement(trancheName).click();
//            
//            
         //   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")));
         //   driver.findElement(By.xpath("//*[contains(text(),'"+tempArray[i]+"')]")).click();
         //   driver.findElement(By.xpath("(//*[contains(text(),'"+tempArray[i]+"')])[1]")).click();
     //   } 
        
     //   Thread.sleep(2000);
    //    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+s+"')]")));
     //   driver.findElement(By.xpath("//*[contains(text(),'"+s+"')]")).click();
    //    driver.findElement(By.xpath("(//*[contains(text(),'"+s+"')])[1]")).click();
    }
    
  public static String getTrancheName(WebElement element) {
	   String actTrancheTitle = element.getText();
		return actTrancheTitle;
    }
  
  public static void iterateTable(WebDriver driver,String orderName,String secName) throws InterruptedException {
	  WebElement BuyTable = driver.findElement(By.xpath("//div[contains(@class,'src-components-Dashboards-orders-____OrderTable__order-table___1bTZn')]"));
		//Get all web elements by tag name 'tr'
	  List<WebElement> Colheader = driver.findElements(By.xpath("(//div[contains(@class,'TableHeader__container___1luXI')])[1]"));
	  int i = -1, findPos = -1;
	  int matchPos = -1;
	  
	  List<String> header = new ArrayList<String>();
	  for(WebElement wb : Colheader) {
		  System.out.println(wb.getText());
		  hd = wb.getText().split("\\r?\\n");
	  }
	  
	  for(i = 0; i < hd.length; i++) {
		  if(hd[i].trim().equals("Name")) {
			 findPos = i; 
		  }
		  if(hd[i].trim().equals("Matching status")) {
			  matchPos = i; 
		 }
		  
	  }
	
	  System.out.println(findPos);
	  System.out.println(matchPos);
	  
	  List<WebElement> rowVals = BuyTable.findElements(By.xpath("(//div[contains(@class,'TableHeader__container___1luXI')])[1]/following-sibling::div"));
	  
	  for(WebElement wb : rowVals) {
		  hd = wb.getText().split("\\r?\\n"); 
	  }
	  for(int k =findPos;k<hd.length;) {
		  System.out.println(k + " " + i);
		  if(hd[k].equalsIgnoreCase(orderName)) {
			  System.out.println(hd[matchPos]);	
			  log.info("Matching Status : " + hd[matchPos] );
			  Reporter.addStepLog("IOI Name :  " + orderName);
			  Reporter.addStepLog("IOI Name :  " + orderName + "  validate with  " + secName + "  SEC Value ");
			  Reporter.addStepLog("Matching Status for + '"+orderName +"' + is : " + hd[matchPos]); 
			  Reporter.addStepLog("-------------------------------------------------------------------");
		  }
		  k=k+i;
		  matchPos = matchPos+i;  
	  }
	  Thread.sleep(500);	 
}
  public static void selectIOIName(WebDriver driver,String s) {
	  
	  String[] tempArray;
	  String delimiter = "/";
      tempArray = s.split(delimiter, -1);
	//  WebElement BuyTable = driver.findElement(By.xpath("//div[contains(@class,'src-components-Dashboards-orders-____OrderTable__order-table___1bTZn')]"));
	//  List<WebElement> rowVals = BuyTable.findElements(By.xpath("(//div[contains(@class,'TableHeader__container___1luXI')])[1]/following-sibling::div"));
      
      for(int i=0;i<tempArray.length;i++)
      {
          List<WebElement> lstDrp = driver.findElements(By.xpath("//*[text() ='"+tempArray[i]+"']"));
          System.out.println(lstDrp.get(0).getText());
          lstDrp.get(0).click();
	  
  }
  }


    public static void SelectTablerow(WebDriver driver, String formedXpathRow) {
        WebElement row  = driver.findElement(By.xpath(formedXpathRow));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", row);
    }

    public static void ValidateDropDownSelectedValue(WebElement drp_industry, String s)
    {
        Assert.assertEquals(drp_industry.getText(),s);
    }

    public static void EditTextBox(WebElement element,String newvalue) throws InterruptedException {

    int y  =  element.getAttribute("value").length();
        for (int i=0;i<y;i++)
        {
            element.sendKeys(Keys.BACK_SPACE);
        }
        element.sendKeys(newvalue);

    }
}
   
