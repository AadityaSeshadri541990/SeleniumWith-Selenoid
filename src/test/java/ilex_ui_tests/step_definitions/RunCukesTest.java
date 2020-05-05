package ilex_ui_tests.step_definitions;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
		//retryCount = 0,
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		//coverageReport = true,
		jsonUsageReport = "target/cucumber-usage.json",
		usageReport = true,
		toPDF = true,
		//excludeCoverageTags = {"@flaky" },
		//includeCoverageTags = {"@Smoke" },
		outputFolder = "target/")

@CucumberOptions(
		features = "classpath:features",
		plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-ExtendedReports/report.html"},
		//tags = {"@Smoke"},
		monochrome = true
		)
public class RunCukesTest{

	@BeforeClass()
	public static void runTomcat() throws Exception {

		// prepare reports folder
		AllureReportConfigurationSetup.prepareAllureResultsFolder();
	}


	@AfterClass
	public static void writeExtentReport() {
		System.out.println("--------------After Class--------------");
		System.out.println(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml");
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/src/test/resources/extent-config.xml"));
		//Reporter.loadXMLConfig(new File(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath())));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		//Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.141.59");
		Reporter.setSystemInfo("Maven", "3.6.3");
		Reporter.setSystemInfo("Java Version", "11.02");

	}
	
}