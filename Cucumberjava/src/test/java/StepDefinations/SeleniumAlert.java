package StepDefinations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.BaseTestSetup;
import utilities.JcExecuter;

public class SeleniumAlert {
	
	@Given("launch the url")
	public void launch_the_url() {
		
	    BaseTestSetup.driver.get("https://www.hyrtutorials.com/");
	}

	@Then("select alert practise sesion")
	public void select_alert_practise_sesion() throws InterruptedException{
		

		WebElement Element= BaseTestSetup.driver.findElement(By.xpath("(//*[contains(text(),'Selenium Practice')])[1]"));
		WebElement SAlert= BaseTestSetup.driver.findElement(By.xpath("(//*[contains(text(),'Alert')])[1]"));
		Actions kowshik=new Actions(BaseTestSetup.driver);
		kowshik.moveToElement(Element);
	    kowshik.moveToElement(SAlert).click().build().perform();
	    BaseTestSetup.driver.navigate().refresh();
	    Thread.sleep(3000);
	    WebElement Element1= BaseTestSetup.driver.findElement(By.xpath("(//*[contains(text(),'Selenium Practice')])[1]"));
		WebElement SAlert1= BaseTestSetup.driver.findElement(By.xpath("(//*[contains(text(),'Alert')])[1]"));
		kowshik.moveToElement(Element1);
	    kowshik.moveToElement(SAlert1).click().build().perform();
	  
	    
	    BaseTestSetup.driver.findElement(By.xpath("//button[@id=\"alertBox\"]")).click();
	    
	   
	   
	  
	   
	}

	@And("click all alert buttons")
	public void click_all_alert_buttons() throws InterruptedException  {
		 Alert alert = BaseTestSetup.driver.switchTo().alert();
		    Thread.sleep(6000);
		    alert.accept();
		    BaseTestSetup.driver.findElement(By.xpath("//button[@id=\"confirmBox\"]")).click();
		    Thread.sleep(6000);
		    alert.dismiss();
		    Thread.sleep(6000);
		    WebElement element=BaseTestSetup.driver.findElement(By.xpath("//button[@id=\"promptBox\"]"));
		    JcExecuter.scrollPageByjsElement(BaseTestSetup.driver, element);
		    BaseTestSetup.driver.findElement(By.xpath("//button[@id=\"promptBox\"]")).click();
		   alert.sendKeys("Kowshik");
		    Thread.sleep(3000);
		    alert.accept();
		   
	}


}
