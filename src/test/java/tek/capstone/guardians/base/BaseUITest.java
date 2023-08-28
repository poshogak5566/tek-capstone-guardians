package tek.capstone.guardians.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.capstone.guardians.utilities.CommonUtility;

public class BaseUITest extends CommonUtility {
	
	@Before
	public void setupTests() {
		super.setupBrowser();
	}
	
	@After
	public void closeTests(Scenario scenario) {
     if (scenario.isFailed()) {
    	 byte[] screenshot = takeScreenShotAsBytes();
    	 scenario.attach(screenshot, "iamge/png", scenario.getName() + "scenario Failed");
     }
     
     super.quitBrowser();
}
}