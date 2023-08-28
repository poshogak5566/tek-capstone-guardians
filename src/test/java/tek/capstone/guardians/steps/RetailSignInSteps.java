package tek.capstone.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;
import tek.capstone.guardians.utilities.DataGenerator;

public class RetailSignInSteps extends CommonUtility {
   
//We will create the object of POMFactory class to access the page objects in page 
//objects in page object classes using the get method we create in the POMFactory class
	 POMFactory factory = new POMFactory();
	 
	 @Given("User is on retail website")
	 public void userIsOnRetailWebsite() {
		 Assert.assertTrue(factory.homePage().tekschoolLogo.isDisplayed());
		 logger.info("TekSchool logo is displayed");
	
	 }
	 @When("User click on Sign in option")
	 public void userClickOnSignInOption()  {
		 click(factory.homePage().signInBtn);
		 logger.info("User clicked on signin butten");
	    
	 }
	 @And("User enter email {string} and password {string}")
	 public void userEnterEmailAndPassword(String email, String password) {
		 sendText(factory.signinpage().emailField,"Qudsia.yousefzai@tekschool.us");
		 sendText(factory.signinpage().passwordField,"Qudsia@7869916");
		 logger.info("User entered email and password");
		 
	     
	 }
	 @And("User click on login button")
	 public void userClickOnLoginButton()  {
		 click(factory.signinpage().loginBtn);
		 logger.info("User clicked on login button");
	    
	 }
	 @Then("User should be logged in into Account")
	 public void userShouldBeLoggedInIntoAccount() {
		 Assert.assertTrue(factory.accountpage().accountLink.isDisplayed());
		 logger.info("User is in account page");
	    
	 }
	 
	 @When("User click on Create New Account button")
	 public void userClickOnCreateNewAccountButton() {
		 click(factory.signinpage().newAccountBtn);
		 logger.info("New account buttun is clicked");
		 
	 }

	 @When("User fill the signUp information with below data")
	 public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		 List<Map<String,String>>accountinfo = dataTable.asMaps(String.class,String.class);
		 sendText(factory.signinpage().nameInput,accountinfo.get(0).get("name"));
		 sendText(factory.signinpage().emailInput, DataGenerator.emailGenerator());
		 sendText(factory.signinpage().passwordInput,accountinfo.get(0).get("password"));
		 sendText(factory.signinpage().confirmPasswordInput,accountinfo.get(0).get("confirmPassword"));
		 logger.info("User filled the signUp information");
		 
		 
	
	 }
	 @When("User click on SignUp button")
	 public void userClickOnSignUpButton() {
		 click(factory.signinpage().signupBtn);
		 logger.info("Uer clicked on signup buttu");

	 }
	 @Then("User should be logged into account page")
	 public void userShouldBeLoggedIntoAccountPage() {
		 Assert.assertTrue(factory.accountpage().accountLink.isDisplayed());
		 logger.info("User is into account page");

	 }




}



	

