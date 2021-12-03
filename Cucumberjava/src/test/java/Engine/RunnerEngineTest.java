package Engine;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.BaseTestSetup;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinations"},tags= "@kowshik",

monochrome = true,
plugin={"pretty","json:target/Reports/JsonReports/cucumber.json"
		,"junit:target/Reports/JunitReports/cucumber.xml","html:target/Reports/Htmlreports/cucumber.html"}
		)
public class RunnerEngineTest { 

	public static Logger Log= LogManager.getLogger(RunnerEngineTest.class.getName());

	@BeforeClass
	public static void launching_browser() throws Exception {

		Log.info("###############################################################################");
		Log.info("##################===Test Suite Execution Started===###########################");
		Log.info("###############################################################################");

		BaseTestSetup.setDriver("chrome", BaseTestSetup.applicationURL);
	}

    @AfterClass
	public static void Close_Browser() throws Exception {

		Log.info("#################################################################################");
		Log.info("#####################===Test Suite Execution Completed===########################");
		Log.info("#################################################################################");

		System.out.println("Last step browser kill");	
		BaseTestSetup.tearDown();

	}






}
