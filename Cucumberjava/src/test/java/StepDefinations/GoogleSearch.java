package StepDefinations;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.codoid.products.exception.FilloException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseTestSetup;
import utilities.DataProvider;
import utilities.JcExecuter;
//import utilities.Duration_functions;
//import utilities.MouseKeyboard;
import utilities.PatchingLogic;
import utilities.Screenshot;



public class GoogleSearch {

	public static HashMap<String, String> excelHashMapValues = new HashMap<String, String>();

	@Given("Application verifys the application url login page")
	public void Url_Verification() throws InterruptedException {
BaseTestSetup.driver.get("https://www.youtube.com/");
	Thread.sleep(1000);
	WebElement element=	BaseTestSetup.driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer/a/tp-yt-paper-button"));
//JcExecuter.flash(element,BaseTestSetup.driver);	
JcExecuter.drawborder(element,BaseTestSetup.driver);	
//JcExecuter.ClickByJS(element,BaseTestSetup.driver);

	String a=(BaseTestSetup.driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer/a/tp-yt-paper-button")).getText());
		System.out.println(a);
		if (a.equals("SIGN IN"))
		{
			System.out.println("Home page verification sucessful");
			Screenshot.GetScreenshot();
			System.out.println("Kowshik"+excelHashMapValues.get("Song name"));
		}
		else
		{
			System.out.println("Home page verification unsucessful");
		} 
	}  

	@When("user search for a song {string}")
	public void Song_search(String song) throws FilloException, IOException, InterruptedException{

		BaseTestSetup.driver.findElement(By.name("search_query")).sendKeys(Keys.CONTROL+"a");
		Thread.sleep(700);
		BaseTestSetup.driver.findElement(By.name("search_query")).sendKeys(DataProvider.extractExcelData(song,excelHashMapValues).get(("Second Song")));
		BaseTestSetup.driver.findElement(By.id("search-icon-legacy")).click();
		Screenshot.GetScreenshot();
	}


	@Then("Playing the song")
	public void Play_song() throws Exception {

		BaseTestSetup.driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		BaseTestSetup.driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-"
			+ "section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/ytd-thumbnail"
				+ "/a/yt-img-shadow/img")).click();

		Thread.sleep(3000);
		int time =PatchingLogic.getvideotime();
		
		if (time<180)
		{
			PatchingLogic.audioLength(time);
			}
	
		    time =PatchingLogic.getvideotime();
			System.out.println("youtube sucess");
			JcExecuter.scrollPageByjs(BaseTestSetup.driver);
			System.out.println(time);
			
			Thread.sleep(time*1000);
			
			
		System.out.println("Last step");

	}



}
