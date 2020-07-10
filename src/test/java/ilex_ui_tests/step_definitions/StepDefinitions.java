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
/*import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;*/

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
        PageFactory.initElements(driver, Counterparty.class);

        prop = new Properties();
        String propFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
    }


    //********************IOI***************
    //@Severity(SeverityLevel.CRITICAL)
    //@Description("Login Test")
   // @Story("Story Name : MOE213")
    @Given("^User Navigates to Login Page of Ilex$")
    public void user_Navigates_to_Login_Page_of_Ilex() throws Throwable
    {
        LandingPage.Navigate_LandingPage(driver,prop.getProperty("SITUrl"),prop.getProperty("SITUIHeaderName"));
    }

    @When("^User navigated to My Network homepage$")
    public void user_navigated_to_My_Network_homepage() throws Throwable {
        //Counterparty.ValidateMyNetworkPage(wait);
    }



}