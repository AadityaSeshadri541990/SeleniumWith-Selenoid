package ilex_ui_tests.step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URI;
import java.sql.*;
import java.util.Properties;

public class Hooks {

    final Logger logger = Utilites.getLogData(Logger.class.getName());
    public static RemoteWebDriver driver = null;
    public static WebDriverWait wait;
    public static Scenario scenario;
    public static String OS_Name;
    public static Properties prop;
    public static InputStream inputStream;
    public static File temp;

    @Before()
    public void start_execution() throws Throwable {

        // FileUtils.deleteDirectory(new
        // File(System.getProperty("user.dir")+"/recordings"));
        // new File(System.getProperty("user.dir")+"/recordings").mkdirs();
        // MyScreenRecorder.startRecording("navigationTest");

        prop = new Properties();
        String propFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
        // System.out.println("*******************Start Execution*******************");
        String exec = prop.getProperty("Execution_Strategy");
        String docker = prop.getProperty("Docker");
        System.out.println("*******************exec*******************" + exec
                + "*******************docker*******************" + docker);
        if (exec.contentEquals("local"))
        {
            if (docker.contentEquals("Y"))
            {
                System.out.println("*********Inside Docker*********");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("83.0");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);

                 driver = new RemoteWebDriver(
                        URI.create("http://selenoid:4444/wd/hub").toURL(),
                        capabilities
                );
               /* Hooks.scenario = scenario;
                wait = new WebDriverWait(driver, 20);
                System.out.println("Wait");*/
                ;
            }
           /* temp = new File(System.getProperty("user.dir") + "/ExecutionLog.txt");
            if (temp.exists())
            {
                RandomAccessFile raf = new RandomAccessFile(temp, "rw");
                raf.setLength(0);
            }
            System.out.println("-------------Recordings Deleted---------------");
            Hooks.scenario = scenario;
            String FIREFOX = "firefox";
            String IE = "ie";
            String DEFAULT = "chrome";
            String browser = prop.getProperty("Browser");
            if (browser.equals("IE"))
            {
            driver = new InternetExplorerDriver();
            }
            else if (browser.equals("CHROME"))
            {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            }
            else if (browser.equals("CHROME-HEADLESS"))
            {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
            }
            else if (browser.equals("FIREFOX"))
            {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            }*/
        }
        /*else if (exec.contentEquals("EC2"))
        {
            System.out.println("exec_strategy as EC2");
            //DeleteDataTestDB();
            System.out.println("Test");
            WebDriverManager.chromedriver().setup();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            System.out.println("-------------Inside Chrome Headless-----------");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
            System.out.println("Test ChromeDriver");
        }*/

    }

    @After(order = 1)
    public void embedScreenshot(Scenario scenario) throws Exception {
        System.out.println("----------------Order = 1----------------");

        if (scenario.isFailed()) {
             System.out.println("--------------Scenario Failed----------------");
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try{
                // System.out.println("--------------1----------------");
                // This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir")
                        + "/target/cucumber-ExtendedReports/screenshots/" + screenshotName + ".png");
                 System.out.println("--------------2----------------");
                FileUtils.copyFile(sourcePath, destinationPath);
                com.cucumber.listener.Reporter.addScreenCaptureFromPath(destinationPath.getAbsolutePath().toString());
                 System.out.println("--------------3----------------");
                //driver.quit();
                // System.out.println("--------------Scenario Failed last
                // line----------------");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        driver.quit();
        // MyScreenRecorder.stopRecording();
    }

    public static void DeleteDataTestDB() throws Throwable {
        String dbName = prop.getProperty("RDS_DBNAME");
        String userName = prop.getProperty("RDS_USERNAME");
        String password = prop.getProperty("RDS_PASSWORD");
        String hostname = prop.getProperty("RDS_HOSTNAME");
        String port = prop.getProperty("RDS_PORT");
        System.out.println("*************Hostname******" + hostname);
        System.out.println("*************Post******" + port);
        System.out.println("*************Databasename******" + dbName);
        String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName;
        try {
            System.out.println("Loading driver...");
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }
        Connection conn = null;
        Statement readStatement1 = null;
        try {
            // conn = DriverManager.getConnection(jdbcUrl);
            conn = DriverManager.getConnection(jdbcUrl, userName, password);

            readStatement1 = conn.createStatement();
            readStatement1.executeUpdate("TRUNCATE table negotiation CASCADE;");
            readStatement1.executeUpdate("TRUNCATE table primary_negotiation CASCADE;");
            readStatement1.executeUpdate("TRUNCATE table invitation CASCADE;");
            readStatement1.executeUpdate("TRUNCATE table buy_interest CASCADE;");
            readStatement1.executeUpdate("TRUNCATE table sell_order CASCADE;");
            readStatement1.executeUpdate("TRUNCATE table \"order\" CASCADE;");
            readStatement1.executeUpdate("TRUNCATE table tranche CASCADE;");
            readStatement1.executeUpdate("TRUNCATE table listing CASCADE;");
            conn.commit();
            conn.close();

        } catch (SQLException ex) {
            // Handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            System.out.println("Closing the connection.");
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException ignore) {
                }
        }

    }

}