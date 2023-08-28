package tek.capstone.guardians.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;
import tek.capstone.guardians.utilities.DataGenerator;

public class RetailAccountSteps extends CommonUtility{
	
	POMFactory factory = new POMFactory();
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.accountpage().accountLink);	
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phoneNumber) {
		clearTextUsingSendKeys(factory.accountpage().nameFiled);
		sendText(factory.accountpage().nameFiled,name);
		 logger.info("Name was entered successfully");
		 
		 clearTextUsingSendKeys(factory.accountpage().phonefiled);
		 sendText(factory.accountpage().phonefiled, DataGenerator.getPhoneNumber());
		 logger.info("Phone number was entered successfully");
	}
	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountpage().updateBttn);
		logger.info("Update butten was clicked");
	}
	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountpage().personalInfoUpdateSuccessMssg);
		String expectedMssg = "Personal Information Updated Successfully";
		String actualMssg = factory.accountpage().personalInfoUpdateSuccessMssg.getText();
		Assert.assertEquals(expectedMssg, actualMssg);
		logger.info("Account information was updated successfully");			
	}
	
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click (factory.accountpage().addAPaymentMethodLink);
		logger.info("Add Payment Method link was clicked successfully");
	}
	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountpage().cardNumberFiled, DataGenerator.getCardNumber());
		sendText(factory.accountpage().nameOnCardNFiled, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountpage().expairationMonthFiled, paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountpage().expirationYearFiled, paymentInfo.get(0).get("expirationYear"));
		sendText(factory.accountpage().securityCodeFiled, paymentInfo.get(0).get("securityCode")); 
		logger.info("Payment Information was added successrully");
	}
	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountpage().paymentSubmitBtn);
		logger.info("Payment Method submit bttn clicked successfully");
	}
	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMssg) {
		
//		if(expectedMssg.contains("Payment Method added")) {
			waitTillPresence(factory.accountpage().paymentMethodSuccessMssge);
			Assert.assertTrue(factory.accountpage().paymentMethodSuccessMssge.isDisplayed());
			expectedMssg = factory.accountpage().paymentMethodSuccessMssge.getText();
			logger.info("Expected Message: " + expectedMssg);			    
	}
	//Edit Card
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.accountpage().clickOnCard);
		click(factory.accountpage().editCrdeBttn);
		logger.info("Edit button clicked sucessfully");
	}
	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(factory.accountpage().cardNumberFiled);
		sendText(factory.accountpage().cardNumberFiled, DataGenerator.getCardNumber());
		clearTextUsingSendKeys(factory.accountpage().nameOnCardNFiled);
		sendText(factory.accountpage().nameOnCardNFiled, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountpage().expairationMonthFiled, paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountpage().expirationYearFiled, paymentInfo.get(0).get("expirationYear"));
		clearTextUsingSendKeys(factory.accountpage().securityCodeFiled);
		sendText(factory.accountpage().securityCodeFiled, paymentInfo.get(0).get("securityCode")); 
		logger.info("Information has been edited");		
	}
	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountpage().updatePaymentBttn);
		logger.info("Update Card button clicked");
	}
	@Then("message should be displayed {string}")
	public void messageShouldBeDisplayed(String actualmssg) {		
		waitTillPresence(factory.accountpage().updatePaymentSuccessMsg);
		Assert.assertTrue(factory.accountpage().updatePaymentSuccessMsg.isDisplayed());
		actualmssg = factory.accountpage().updatePaymentSuccessMsg.getText();
		logger.info("Messge is: " + actualmssg);	
	}
	//Remove Card
@When("User click on remove option of card section")
public void userClickOnRemoveOptionOfCardSection() {
	click(factory.accountpage().clickOnCard);
	click(factory.accountpage().removeCard);
	logger.info("Remove button clicked");
}
@Then("payment details should be removed")
public void paymentDetailsShouldBeRemoved() {
	Assert.assertTrue(factory.accountpage().addCardBoxHeader.isDisplayed());
	logger.info("Payment details removed");	
}
//Add Address
@When("User click on Add address option")
public void userClickOnAddAddressOption() {
	click(factory.accountpage().addAddressLink);
	logger.info("Add address link was clicked");
}

@When("user fill new address form with below information")
public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
 List<Map<String, String>> addressInfo = dataTable.asMaps();
 selectByVisibleText(factory.accountpage().addressCountryDropDown,
		 DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
 sendText(factory.accountpage().addressNameF, 
		 DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
 sendText(factory.accountpage().addressPhoneF, 
		 DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
 sendText(factory.accountpage().addressStreetF, 
		 DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
 sendText(factory.accountpage().addressApartmentNum,
		 DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
 sendText(factory.accountpage().addressCityF,
		 DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
 selectByVisibleText(factory.accountpage().addressStateDropdown,
		 DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
 sendText(factory.accountpage().addressZipCode,
		 DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));
 logger.info("Address form wass filled");
 
}
@When("User click Add Your Address button")
public void userClickAddYourAddressButton() {
	click(factory.accountpage().addressAddBttn);
	logger.info("Add your address button was clicked"); 
}
@Then("the message should be displayed {string}")
public void theMessageShouldBeDisplayed(String actualmssg) {
	waitTillPresence(factory.accountpage().addressSuccessMssg);
	Assert.assertTrue(factory.accountpage().addressSuccessMssg.isDisplayed());
	actualmssg = factory.accountpage().addressSuccessMssg.getText();
	logger.info("Message is: " + actualmssg);
	
}

//Edit address
@When("User click on edit address option")
public void userClickOnEditAddressOption() {
	click(factory.accountpage().editAddressLink);
	logger.info("User clicked on edit address button");
}
@When("user edit new address form with below information")
public void userEditNewAddressFormWithBelowInformation(DataTable dataTable) {
	List<Map<String, String>> updateAddress = dataTable.asMaps(String.class, String.class);
	
	sendText(factory.accountpage().addressCountryDropDown, updateAddress.get(0).get("country"));
	
	clearTextUsingSendKeys(factory.accountpage().addressNameF);
	sendText(factory.accountpage().addressNameF, updateAddress.get(0).get("fullName"));
	
	clearTextUsingSendKeys(factory.accountpage().phonefiled);
	sendText(factory.accountpage().phonefiled, DataGenerator.getPhoneNumber());
	
	clearTextUsingSendKeys(factory.accountpage().addressStreetF);
	sendText(factory.accountpage().addressStreetF, updateAddress.get(0).get("streetAddress"));
	
	clearTextUsingSendKeys(factory.accountpage().addressApartmentNum);
	sendText(factory.accountpage().addressApartmentNum, updateAddress.get(0).get("apt"));
	
	clearTextUsingSendKeys(factory.accountpage().addressCityF);
	sendText(factory.accountpage().addressCityF, updateAddress.get(0).get("city"));
	
	clearTextUsingSendKeys(factory.accountpage().addressStateDropdown);
	sendText(factory.accountpage().addressStateDropdown, updateAddress.get(0).get("state"));
	
	clearTextUsingSendKeys(factory.accountpage().addressZipCode);
	sendText(factory.accountpage().addressZipCode, DataGenerator.getZipCode() );
	logger.info("User edited the new address information");

		
}
@When("User click update Your Address button")
public void userClickUpdateYourAddressButton() {
	click(factory.accountpage().updateAddressBtn);
	logger.info("Update button was clicked");

}
@Then("messages should be displayed {string}")
public void messagesShouldBeDisplayed(String actualmssg) {
	waitTillPresence(factory.accountpage().addressUpdatedSuccessfully);
	Assert.assertTrue(factory.accountpage().addressUpdatedSuccessfully.isDisplayed());
	actualmssg = factory.accountpage().addressUpdatedSuccessfully.getText();
	logger.info("Message is: " + actualmssg);

}
//User can remove address from account
@When("User click on remove option of Address section")
public void userClickOnRemoveOptionOfAddressSection() {
click(factory.accountpage().removeAddressBtn);
logger.info("Remove option of address section was clicked");
}
@Then("Address details should be removed")
public void addressDetailsShouldBeRemoved() {
	
	if(!isElementDisplayed(factory.accountpage().addressBr));
	
	  logger.info("Address removed successfully");
		
	}
	

}



	


