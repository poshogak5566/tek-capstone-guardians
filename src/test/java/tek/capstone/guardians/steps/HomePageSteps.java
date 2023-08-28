package tek.capstone.guardians.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;

public class HomePageSteps extends CommonUtility {
	
	POMFactory factory = new POMFactory();
	
	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allOptions);
		logger.info("All options clickd");
		

	}//here we use list of list and the index for all should be (0) because its one line
	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
     List<List<String>>sidbaroption = dataTable.asLists(String.class);
		for (int i = 0; i < sidbaroption.get(0).size(); i++) {
   Assert.assertTrue(isElementDisplayed(getDriver().findElement(
		   By.xpath("//div[@class='modal__content h-screen w-80 ']//span[text()='"
                        +sidbaroption.get(0).get(i)+"']"))));
			logger.info(sidbaroption.get(0).get(i)+" is present");
			
		}

	}
	
	@When("User on {string}")
	public void userOn(String department) {
		List<WebElement> departments = factory.homePage().sideBarOptions;
		for(int i = 0; i < departments.size(); i++) {
			if(departments.get(i).getText().equalsIgnoreCase(department)) {
				departments.get(i).click();
				break;
			}
		}
	}
	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> departmentOptions = dataTable.asLists(String.class);
		List<WebElement> options = factory.homePage().sideBarAllOptions;
		for(int i = 0; i < departmentOptions.get(0).size(); i++) {
			for(WebElement elements : options) {
				if(elements.getText().equalsIgnoreCase(departmentOptions.get(0).get(i))) {
					Assert.assertTrue(elements.isDisplayed());
					logger.info("The option " + elements.getText() + " is present");
				}
			}
		}
		
	}
	
	
	

}
