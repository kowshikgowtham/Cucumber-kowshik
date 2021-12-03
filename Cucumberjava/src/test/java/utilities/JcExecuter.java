package utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JcExecuter {
	
	 private static Logger Log = LogManager.getLogger(JcExecuter.class.getName());
	
	public static void flash(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++)
			changeColor("rgb(0,200,0)",element,driver);
		changeColor(bgcolor,element,driver);
		
	}
	
	
	public static void changeColor(String color,WebElement element,WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		utilities.Screenshot.GetScreenshot();
		
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			
			Log.error("Failed to highighlight the element"+" :"+e.getMessage());
            
		}
		
	}
	public static void drawborder(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'",element);
		utilities.Screenshot.GetScreenshot();
	}
	
	public static void generateAlert(String message,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
		 
	}
	
	public static void ClickByJS(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();",element);

	}
	
	public static void rereshbrowserByjs(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		
	}
	
	public static String getTitleByjs(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
	String title=js.executeScript("return document.title;").toString();
	System.out.println(title);
		return title;
	}
	
	public static String getInnerWordsofpage(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
	String pageText=js.executeScript("return document.documentElement.innertext;").toString();
	System.out.println(pageText);
		return pageText;
	}
	
	public static void scrollPageByjs(WebDriver driver) {
		
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript(("window.scrollTo(0,document.body.scrollHeight)"));
		
		
	}
	
public static void scrollPageByjsElement(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();",element);
		
	}
	
public static void scrollPageupByjs(WebDriver driver) {
	
	JavascriptExecutor js=((JavascriptExecutor) driver);
	js.executeScript(("window.scrollTo(document.body.scrollHeight,0)"));
	
	
}

public static void JCsendkeys(WebDriver driver,WebElement element,String Svalue) {
	
	JavascriptExecutor js=((JavascriptExecutor) driver);
	js.executeScript("arguments[0].value='"+Svalue+"'",element);
	
	
}

	
}
