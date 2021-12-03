package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class BaseTestSetup {

    public static WebDriver driver = null;
   
    private static Logger Log = LogManager.getLogger(BaseTestSetup.class.getName());

    public static String applicationURL = SetupPropertiesLoader.getProperty("url", "config.properties");

	
    
    private enum BrowserType {
        ie, chrome, firefox;
    }

    public static void setDriver(String browserType, String appURL) throws Exception {

        BrowserType browser_Type = BrowserType.valueOf(browserType);

        switch (browser_Type) {
            case chrome:
                driver = initChromeDriver(appURL);
                break;
            case firefox:
                driver = initFirefoxDriver(appURL);
                break;
            case ie:
                System.out.println("browser : " + browserType + " is ie, Launching IE11 as browser of choice..");
                driver = initIEDriver(appURL);
                System.out.println(driver.getWindowHandle().toString());
        }
    }

    /**
     * This method is to initialize the chrome driver and launch the URL
     * 
     * @param Application
     *            URL
     * @throws Throwable
     */
    private static WebDriver initChromeDriver(String appURL) throws Exception {
        try {
            System.out.println("Launching google chrome with new profile..");
            try{
            System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Kowshik\\\\eclipse-workspace\\\\Cucumberjava\\\\src\\\\test\\\\resources\\\\Drivers\\\\chromedriver.exe");
            }
            catch(Exception e)
            {
            	System.out.println("Path not supported");
            }
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.addArguments("disable-extensions");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(chromeOptions);
            Duration_functions.wait = new WebDriverWait(driver, 50);
            Thread.sleep(60);
            driver.navigate().to(appURL);

            return driver;
        }
        catch (Exception e) {
            Log.error(e.getMessage());
            return null;
        }
    }
    
    /**
     * This method is to initialize the firefox driver and launch the URL
     * 
     * @param Application
     *            URL
     * @throws Throwable
     */
    private static WebDriver initFirefoxDriver(String appURL) throws Exception {
        System.out.println("Launching Firefox browser..");
        driver = new FirefoxDriver();
        Duration_functions.wait= new WebDriverWait(driver, 50);
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    /**
     * This method is to initialize the ie driver and launch the URL
     * 
     * @param Application
     *            URL
     * @throws Throwable
     */
    @SuppressWarnings("deprecation")
	private static WebDriver initIEDriver(String appURL) throws Exception {
        System.out.println("Launching IE browser..");
        System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");

        DesiredCapabilities cap = new DesiredCapabilities();
        DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
        DesiredCapabilities.internetExplorer().setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
        DesiredCapabilities.internetExplorer().setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        DesiredCapabilities.internetExplorer().setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        DesiredCapabilities.internetExplorer().setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
        DesiredCapabilities.internetExplorer().setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.ACCEPT);
        DesiredCapabilities.internetExplorer().setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
        
        
        driver = new InternetExplorerDriver(cap);
        Duration_functions.wait = new WebDriverWait(driver, 70);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(appURL);
        return driver;
    }
    
    /**
     * This method is to kill the browser
     * 
     * @throws Throwable
     */
   
    public static void tearDown() throws Exception {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
            Thread.sleep(5000);
            driver.quit();
        }
        catch (Exception e) {
            Log.error(e.getMessage());
            throw new Exception("Failed while executing the Browserkill.bat file");
        }
    }

	
    
Properties prop;

 
public Properties LoadConfigProperties() throws IOException{
	        File propFile = new File(SetupPropertiesLoader.getProperty("ConfigFilePath", "config.properties"));
	        
	        FileInputStream fileInput = null;
	        try{
	            fileInput = new FileInputStream(propFile);
	        } catch (FileNotFoundException e){
	            e.printStackTrace();
	        }

	        Properties prop = new Properties();
	        //Load properties file
	        try{
	            prop.load(fileInput);
	        }catch (IOException e){
	            e.printStackTrace();
	        }
	       System.out.println(prop);
	       return prop;
	    }
    

}