package StepDefinations;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.BaseTestSetup;

public class Addtocart {
	
	@Given("Launch the url")
	public void launch_the_url() {
	    // Write code here that turns the phrase above into concrete actions
	   BaseTestSetup.driver.get("http://automationpractice.com");
	}

	@And("select the Woman dress and eveneing dress")
	public void select_the_woman_dress_and_eveneing_dress() {
	   
		WebElement mainmenu= BaseTestSetup.driver.findElement(By.xpath("(//*[@title=\"Women\"])[1]"));
		Actions actions=new Actions(BaseTestSetup.driver);
		actions.moveToElement(mainmenu);
		WebElement submenu= BaseTestSetup.driver.findElement(By.xpath("(//*[@title=\"Summer Dresses\"])[1]"));
		actions.moveToElement(submenu);
		actions.click().build().perform();
		
	}

	@Then("click the slider")
	public void click_the_slider() throws InterruptedException {
	   
		
	WebElement slider=	BaseTestSetup.driver.findElement(By.xpath("//div[@class=\"ui-slider-range ui-widget-header ui-corner-all\"]"));
	Actions action=new Actions(BaseTestSetup.driver);
	action.click(slider);
	action.moveByOffset(0, 5).click().build().perform();
	Thread.sleep(2000);
	
	
	
	}
	
		
	}

