package StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.BaseTestSetup;

public class ScCom_ProductList {
	
	@Given("Login into sc com url")
	public void login_into_sc_com_url() {
		
		BaseTestSetup.driver.get("https://pt.sc.com/onboarding/rtob-sit/multi-country/products.html");
	}
	    
	
	@And("Get the product list and campagine")
	public void get_the_product_list_and_campagine() {
	
		List<WebElement> kowshik=BaseTestSetup.driver.findElements(By.xpath("//h3//a[@target=\"_self\"]//b"));
		List<WebElement> kow=BaseTestSetup.driver.findElements(By.xpath("//h3//a[@target=\"_self\"]"));
		for (int i=0;i<kowshik.size();i++) {
			
		System.out.println(kowshik.get(i).getText());
		System.out.println(kow.get(i).getAttribute("href"));
		                                    }
	
	                                                 }
	
}
