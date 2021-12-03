package utilities;

import org.openqa.selenium.By;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MouseKeyboard {
	
	
	 public static Logger Log = LogManager.getLogger(MouseKeyboard.class.getName());
	 By byLocator;
	
	 public void clickWebelement(By locator) throws Exception {
	        try {
	        	((JavascriptExecutor) BaseTestSetup.driver).executeScript("window.scrollTo(0," + BaseTestSetup.driver.findElement(locator).getLocation().y + ")");
	        	if(locator.toString().contains("tinymice")){
	        		Actions actionsClick = new Actions(BaseTestSetup.driver);
	                actionsClick.moveToElement(BaseTestSetup.driver.findElement(locator)).click(BaseTestSetup.driver.findElement(locator));        	
	            }
	        	else{
	        		BaseTestSetup.driver.findElement(locator).sendKeys(Keys.CONTROL);
	                BaseTestSetup.driver.findElement(locator).click();
	        	}
	            Log.debug("Element with locator" + locator + " is clicked");
	        }
	        catch (Exception e) {
	            Log.error("Element with locator" + locator + " is not clicked :" + e.getMessage());
	            throw new Exception("Error while Clicking the webelement identified by " + locator + e.getMessage());
	        }
	    }
	 
	  /**
	     * This method is used to navigate to custom actions and open the specified
	     * form
	     * 
	     * @param locator
	     *            and value
	     */
	    
	    
	   
	    public void customForms(By main_menu, String sub_menu) throws Exception {
	        try {
	           Thread.sleep(7000);
	         Duration_functions.wait.until(ExpectedConditions.presenceOfElementLocated(main_menu));

	            ((JavascriptExecutor) BaseTestSetup.driver).executeScript("window.scrollTo(0," + BaseTestSetup.driver.findElement(main_menu).getLocation().y + ")");
	            String onClickScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('click',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject){ arguments[0].fireEvent('onclick');}";
	            WebElement sub_Men =  BaseTestSetup.driver.findElement(By.xpath("//li[@title='"+sub_menu+"']"));
	            ((JavascriptExecutor) BaseTestSetup.driver).executeScript(onClickScript,sub_Men);
	            Duration_functions.wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	            Screenshot.GetScreenshot();
	        }
	        catch (Exception e) {
	        	Screenshot.GetScreenshot();
	            Log.error("Error while selecting " + e.getMessage());
	            throw new Exception("Error while selecting the custom form identified by " + sub_menu + " :" + e.getMessage());
	        }
	    }
	    
	    
	   

		public static void mouseOver(By by) {
	        try {
	        	
	            Actions builder = new Actions(BaseTestSetup.driver);
	            WebElement we = BaseTestSetup.driver.findElement(by);
	            Action mouseMovement=builder.moveToElement(we).build();
	            mouseMovement.perform();
	            we.click();
	           
	        }
	        catch (Exception e) {
	            Log.info(e.getMessage());
	        }
	    }
	
		
	
	}


