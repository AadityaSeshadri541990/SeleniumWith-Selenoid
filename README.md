# Working-Selenium-with-Selenoid
This Project is about Using Selenoid instead of Web Driver Manager 

#Pre Requisite Steps-Needs Installation 

1.Docker needs to be installed

2.Chrome Version 76
 
3.Firefox 68

4.Opera 62

5.Navigate to / Folder in Linux or Mac and create /tmp/videos

In case of Browser Update config for browsers needs to be changed manually 

Line ---"image": "selenoid/vnc:chrome_76.0"--- in browser config for instance



Steps to run -
 
1.git clone https://github.com/AadityaSeshadri/Working-Selenium-with-Selenoid.git

2.Navigate to Project Root Folder and type below commands 

2.1 docker-compose build (For first time Dependencies will be downloaded and will take a while)

2.2 

2.1.1To run with Chrome - root folder ->src->test->java->ilex_ui_tests.step_definitions->Hooks.java
Replace open browser function with below code 

@Before("@Smoke")
    public void openBrowser(Scenario scenario) throws IOException {
        Hooks.scenario = scenario;
        DesiredCapabilities capabilities = new DesiredCapabilities();
         //***********Chrome*********** */
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("76.0");
        //***********FireFox***********/
        //capabilities.setBrowserName("firefox");
        //capabilities.setVersion("68.0");
        //***********Opera*********** */
        //capabilities.setBrowserName("chrome");
        //capabilities.setVersion("62.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableLog", true);
        driver = new RemoteWebDriver(
                URI.create("http://selenoid:4444/wd/hub").toURL(),
                 //URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities);
        ;
        wait = new WebDriverWait(driver,20);
        
    }
    
2.1.2 Browser=Chrome docker-compose up -d (In Run time Docker compose will point to browsers_Chrome.json file in Rootfolder->BrowserConfig Folder) and starts execution 


2.2.1To run with FireFox - root folder ->src->test->java->ilex_ui_tests.step_definitions->Hooks.java
Replace open browser function with below code 

@Before("@Smoke")
    public void openBrowser(Scenario scenario) throws IOException {
        Hooks.scenario = scenario;
        DesiredCapabilities capabilities = new DesiredCapabilities();
         //***********Chrome*********** */
        //capabilities.setBrowserName("chrome");
        //capabilities.setVersion("76.0");
        //***********FireFox***********/
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("68.0");
        //***********Opera*********** */
        //capabilities.setBrowserName("chrome");
        //capabilities.setVersion("62.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableLog", true);
        driver = new RemoteWebDriver(
                URI.create("http://selenoid:4444/wd/hub").toURL(),
                 //URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities);
        ;
        wait = new WebDriverWait(driver,20);
        
    }
    
2.2.2 Browser=Firefox docker-compose up -d (In Run time Docker compose will point to browsers_Firefox.json file in Rootfolder->BrowserConfig Folder) and starts execution 

2.3.1To run with Opera - root folder ->src->test->java->ilex_ui_tests.step_definitions->Hooks.java
     Replace open browser function with below code 
     
     @Before("@Smoke")
         public void openBrowser(Scenario scenario) throws IOException {
             Hooks.scenario = scenario;
             DesiredCapabilities capabilities = new DesiredCapabilities();
              //***********Chrome*********** */
             //capabilities.setBrowserName("chrome");
             //capabilities.setVersion("76.0");
             //***********FireFox***********/
             //capabilities.setBrowserName("firefox");
             //capabilities.setVersion("68.0");
             //***********Opera*********** */
             capabilities.setBrowserName("chrome");
             capabilities.setVersion("62.0");
             capabilities.setCapability("enableVNC", true);
             capabilities.setCapability("enableVideo", true);
             capabilities.setCapability("enableLog", true);
             driver = new RemoteWebDriver(
                     URI.create("http://selenoid:4444/wd/hub").toURL(),
                      //URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                     capabilities);
             ;
             wait = new WebDriverWait(driver,20);
             
         }
         
 2.3.2 Browser=Firefox docker-compose up -d (In Run time Docker compose will point to browsers_Opera.json file in Rootfolder->BrowserConfig Folder) and starts execution 
 
 2.3
 
 2.3.1
 
 Based on browser after hitting up command wait until below message
 Creating network "cucumber-jvm-template-master_default" with the default driver
 Creating cucumber-jvm-template-master_dockerize_1    ... done
 Creating cucumber-jvm-template-master_selenoid_1  ... done
 Creating cucumber-jvm-template-master_seleniumcode_1 ... done
 Creating cucumber-jvm-template-master_selenoid-ui_1  ... done

2.3.2
Navigate to http://localhost:8080/ to see Selenoid UI 

Click on Capabilites tab on right top corner 

Select Browser dropdown expected to appear if all installations done properly 

Click on Browser Dropdown and we should be able to see browser based on selection provided in step 2.1.1 or 2.2.1 or 2.3.1 (ie-Chrome,Firefox or Opera)

When Clicked on Create Session , it should be successful in case of all steps followed properly . Manually created session can be viewed under stats Tab 

Above three steps are done by code automatically . Hence Close Manually created session

2.4 Navigate to Project root directory  and run ./run_tests.sh from Project root folder 

2.5 Browser Executes under Selenoid Container so Navigate to http://localhost:8080 and 

Session created by selenoid will be available under stats Tab

2.6 Also since Selenoid Supports vnc , we could see the execution under Stats Tab 

2.7 Once Execution is finished (One of test case is purposely made fail to check for report)
results could be verified with below docs 

2.7.1 
Project Root Folder ->ExecutionLog.log [All executions are logged and log file is created]

2.7.2
Project Root Folder ->Target Folder 

1)cucumber-ExtendedReports ->Open report.html from finder 
-it has facilities to Filter test case execution by Status(Pass,Fail) or Category (In case of Tagging provided)
-it also attach screenshot in case of test case failure embedded inside report 
2)cucumber-html-report
-default reporting structure with Cucumber ,also embeds screenshot with report 
3.Navigate to /tmp/logs for Selenoid Container Logs(/tmp/ folder is created manually by us at Pre requisite step 5)
4.Navigate to /tmp/videos for execution video 
[/tmp/logs and /tmp/videos needs to be cleared frequently to avoid over consumption]
5.Project Root Folder->surefire-reports-Could be used for CI 


2.8  
Next Steps to be implemented -

2.8.1
Based on User input in command line (Browser=Chrome docker-compose up) Set Browser to be looped 

2.8.2
Creation of /tmp/videos and logs to be automated 

2.8.3Logs to be directed to ELK (To be created under same network of docker compose)

2.8.4 Aerokube for now does not have official images for ie and safari .but work around needs to be implemented . 

2.8.5 On Windows Present Version of Docker observed issue with Mounting , needs to be resolved to run on Windows 



Known Issues - 

1. Not Tested on Windows 
2. Not Tested on Safari and IE Browsers 




Steps in Short- 
1.docker-compose build 
2.Browser=Chrome docker-compose up -d 
3. ./run_tests.sh


Features Completed:
1.IOI
2.SEC
3.Listing
4.Counterparty except Delete


