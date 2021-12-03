package utilities;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Duration_functions {
	
	 public static WebDriverWait wait = null;
	 private static Logger Log = LogManager.getLogger(Duration_functions.class.getName());
    
	 /**------------------------------------------------------------------
     * Wait until options loaded in drop down
     * 
     * @param select
     *----------------------------------------------------------------------*/
    public static void waitForAjax(final Select select) throws Exception {
        wait.until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {

                if (select.getOptions().size() > 1) {
                    return true;
                }
                else {
                    return false;
                }
            }
        });
    }
    
    public static void waitForTitleisPresent(final By by) throws Exception{
    	try{
    	wait.until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {

                if (driver.findElement(by).getAttribute("title").length()>0) {
                    return true;
                }
                else {
                    return false;
                }
            }
        });
    	}
    	catch(Exception e)
    	{
    		Log.error("Error while waiting for title is present in element: "+by+e.getMessage());
    		throw new Exception("Title is not present in the element: "+by);
    	}
    }

    /**
     * Wait until page is loaded
     */
    public static void waitForPageLoad() throws Exception {
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return String.valueOf(((JavascriptExecutor) BaseTestSetup.driver).executeScript("return document.readyState")).equals("complete");
                }
            });
        }
        catch (Exception e) {
            Log.error("Error in page load wait" + " :" + e.getMessage());
            throw new Exception("Error in page load wait" + " :" + e.getMessage());
        }
    }

    public static String waitForElementNotVisible(int timeOutInSeconds, WebDriver driver, String elementXPath) {
        if ((driver == null) || (elementXPath == null) || elementXPath.isEmpty()) {

            System.out.println("Wrong usage of WaitforElementNotVisible()");
        }
        try {
            (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='loadingIndicatorImage']")));
            System.out.println("Wait for element visible");
            return null;
        }
        catch (TimeoutException e) {
            return "Build your own errormessage...";
        }
    }
    /**
     * wait till the number window size of driver is given in parameter
     * @param screenSize
     */
    public static void waitForNumberOfWindowsToBe(int screenSize){
    	try{
    	wait.until(ExpectedConditions.numberOfWindowsToBe(screenSize));
    	}
    	catch(Exception e){
    		
    	}
    }
    
    public static Boolean waitForElementVisible(int timeOutInSeconds, WebDriver driver, By by){
        try{
                (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(by));
                System.out.println("Wait for element visible");
                return Boolean.TRUE;
        }
        catch(Exception e){
                return Boolean.FALSE;
        }
    }

    
	@SuppressWarnings("deprecation")
	public static void fluentWait(By main_menu, int timeInSeconds) throws Exception {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(BaseTestSetup.driver).withTimeout(timeInSeconds, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(main_menu));
        }
        catch (Exception e) {
            Log.error(e.getMessage());
            throw new Exception("Error while waiting for element with locator " + main_menu + " :" + e.getMessage());
        }
    }
    
	
	public static void driverwait(int timeInseconds){
	 
	 BaseTestSetup.driver.manage().timeouts().implicitlyWait(timeInseconds, TimeUnit.SECONDS);		
	}
	
	
    
}
