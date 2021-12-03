package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {
	
	 public static String screenshotDir = SetupPropertiesLoader.getProperty("screenshot_dir", "config");
	
	 public static void GetScreenshot(){
		 System.out.println(screenshotDir);
	      File scrFile = ((TakesScreenshot)BaseTestSetup.driver).getScreenshotAs(OutputType.FILE);
	      String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime());
	      int randNo=(int)Math.random() ;
	      String conString= String.valueOf(randNo);
	      timeStamp.concat(conString );
	      System.out.println("conString"+timeStamp);
	      
	     
	      try {
	    	  FileUtils.copyFile(scrFile, new File(screenshotDir + timeStamp + ".png"));
	      } catch (IOException e1) {
	          e1.printStackTrace();
	      }
	  }
	
	
}
