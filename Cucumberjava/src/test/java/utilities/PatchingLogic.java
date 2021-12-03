package utilities;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class PatchingLogic {
	
	public static Logger Log = LogManager.getLogger(Duration_functions.class.getName());

		public static int getvideotime() throws Exception {
			
			
		    MouseKeyboard.mouseOver(By.xpath("//div[@class='ytp-chrome-controls']"));
		    WebElement time=Duration_functions.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.ytp-time-duration")));
			String arr[] = time.getText().split(":", 3);
			int min= Integer.parseInt(arr[0])*60;     
			int sec= Integer.parseInt(arr[1]);    		
			return (min+sec);
			}
		
		public static void audioLength(int time) throws Exception {
	        try {
	        	
	        	 MouseKeyboard.mouseOver(By.xpath("//div[@class='ytp-chrome-controls']"));
				//Duration_functions.driverwait(20);
	           while(BaseTestSetup.driver.findElements(By.xpath("//span[@class='ytp-ad-simple-ad-badge']/div")).size()!=0) {
					time =PatchingLogic.getvideotime();
					System.out.println("Into time loop");
					System.out.println(time);
					Duration_functions.waitForElementVisible(10, BaseTestSetup.driver,By.xpath("//button[@class='ytp-ad-skip-button ytp-button']"));
					BaseTestSetup.driver.findElement(By.xpath("//button[@class='ytp-ad-skip-button ytp-button']")).click();
					
	           }
	            
	        }
	        catch (Exception e) {
	            Log.error("Error in page load wait" + " :" + e.getMessage());
	            throw new Exception("Error in page load wait" + " :" + e.getMessage());
	        }
	    }


		
		
		
		
}
