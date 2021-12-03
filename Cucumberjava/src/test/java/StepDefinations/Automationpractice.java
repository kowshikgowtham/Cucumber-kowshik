package StepDefinations;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseTestSetup;

public class Automationpractice {

	public static HashMap<String, String> excelHashMapValues = new HashMap<String, String>();
	
	
	@Given("launch the Url")
	public void launch_the_url() {
		BaseTestSetup.driver.get("http://automationpractice.com");
		
	}

	@Then("user click the sign page")
	public void user_click_the_sign_page() {
		BaseTestSetup.driver.findElement(By.xpath("//*[contains(text(),\"Sign in\")]")).click();
	    
	}

	@Then("create an account")
	public void create_an_account() throws InterruptedException {
	    
		BaseTestSetup.driver.findElement(By.xpath("//input[@name=\"email_create\"]")).sendKeys("itsjustkowshik@gmail.com");
		BaseTestSetup.driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span/i")).click();
		
		Thread.sleep(10000);
	}
	

	@When("user fill the details")
	public void user_fill_the_details() throws InterruptedException {
	   
		WebElement element = BaseTestSetup.driver.findElement(By.name("id_state"));
		Actions actions = new Actions(BaseTestSetup.driver);
		actions.moveToElement(element);
		actions.perform();
		
		BaseTestSetup.driver.findElement(By.name("id_state")).click();
	Select  kowshik = new Select (BaseTestSetup.driver.findElement(By.name("id_state")));
		kowshik.selectByIndex(3);
		Thread.sleep(10000);
	}

	@When("click on the register")
	public void click_on_the_register() {
		
		WebElement element = BaseTestSetup.driver.findElement(By.xpath("//*[text()=\"Register\"]"));
		Actions actions = new Actions(BaseTestSetup.driver);
		actions.moveToElement(element);
		actions.perform();
		
		BaseTestSetup.driver.findElement(By.xpath("//*[text()=\"Register\"]")).click();
	   
	}






}