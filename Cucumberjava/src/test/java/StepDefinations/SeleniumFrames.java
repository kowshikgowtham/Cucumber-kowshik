package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseTestSetup;
import utilities.JcExecuter;

public class SeleniumFrames {
	@Given("launch the URL")
	public void launch_the_URL() {

		BaseTestSetup.driver.get("https://www.hyrtutorials.com/");

	}

	@And("redirect to the dropdown navigation")
	public void redirect_to_the_dropdown_navigation() throws InterruptedException {

		WebElement Element = BaseTestSetup.driver
				.findElement(By.xpath("(//*[contains(text(),'Selenium Practice')])[1]"));
		WebElement SAlert = BaseTestSetup.driver.findElement(By.xpath("(//*[contains(text(),'Frames Practice')])[1]"));
		Actions kowshik = new Actions(BaseTestSetup.driver);
		kowshik.moveToElement(Element);
		kowshik.moveToElement(SAlert).click().build().perform();
		BaseTestSetup.driver.navigate().refresh();
		Thread.sleep(3000);
		WebElement Element1 = BaseTestSetup.driver
				.findElement(By.xpath("(//*[contains(text(),'Selenium Practice')])[1]"));
		WebElement SAlert1 = BaseTestSetup.driver.findElement(By.xpath("(//*[contains(text(),'Frames Practice')])[1]"));
		kowshik.moveToElement(Element1);
		kowshik.moveToElement(SAlert1).click().build().perform();

		// BaseTestSetup.driver.findElement(By.xpath("//button[@id=\"alertBox\"]")).click();

	}

	@Then("Select the Selenium praticse followed by the Frames praticse")
	public void select_the_selenium_praticse_followed_by_the_frames_praticse() throws InterruptedException {

		BaseTestSetup.driver.switchTo().frame("frm1");
		WebElement element = BaseTestSetup.driver.findElement(By.id("course"));
		JcExecuter.scrollPageByjsElement(BaseTestSetup.driver, element);
		Thread.sleep(5000);

		Select jsk = new Select(BaseTestSetup.driver.findElement(By.id("course")));
		jsk.selectByValue("python");

		Select multidrop = new Select(BaseTestSetup.driver.findElement(By.id("ide")));
		multidrop.selectByVisibleText("Eclipse");
		multidrop.selectByIndex(3);

	}

	@When("1st frame shouldbe selected and reidrects back to the original frame")
	public void st_frame_shouldbe_selected_and_reidrects_back_to_the_original_frame() throws InterruptedException {

		BaseTestSetup.driver.switchTo().parentFrame();
	//BaseTestSetup.driver.switchTo().defaultContent();
		JcExecuter.scrollPageupByjs(BaseTestSetup.driver);
		Thread.sleep(5000);
		//BaseTestSetup.driver.findElement(By.id("name")).sendKeys("Kowshik-Frame1 passed");
		
		WebElement sendvalue =BaseTestSetup.driver.findElement(By.id("name"));
		
		JcExecuter.JCsendkeys(BaseTestSetup.driver, sendvalue, "Kowshik-Frame1 passed");
		Thread.sleep(4000);

	}

	@Then("validate the frames present")
	public void validate_the_frames_present() {

	}

	@Then("enter the test fields in the text box")
	public void enter_the_test_fields_in_the_text_box() {

	}
}
