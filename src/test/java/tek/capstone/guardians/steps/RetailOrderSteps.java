package tek.capstone.guardians.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import tek.capstone.guardians.pages.POMFactory;
import tek.capstone.guardians.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility{
	
	 POMFactory factory = new POMFactory();
	 
	 @Then("User change the category to {string}")
	 public void userChangeTheCategoryTo(String category) {
     selectByVisibleText(factory.orderPage().allDepartmentDropdown, category); 
     logger.info("Category was selected from dropdown");
		 
	 }
	 @Then("User search for an item {string}")
	 public void userSearchForAnItem(String kasaOutdoorSmartPlug) {
		 sendText(factory.orderPage().searchInputField, kasaOutdoorSmartPlug);
		 logger.info("Item name was entered");
		 
	 }
	 @Then("User click on Search icon")
	 public void userClickOnSearchIcon() {
		 click(factory.orderPage().searchBttn);
		 logger.info("Search button was clicked");
		 
	 }
	 @Then("User click on item")
	 public void userClickOnItem() {
		 click(factory.orderPage().itemKasaOutdoorSmartPlug);
			 logger.info("Item clicked");
		 
	 }
	 @Then("User select quantity {string}")
	 public void userSelectQuantity(String itemQty) {
		 selectByVisibleText(factory.orderPage().qtyDropdown, itemQty);
		 logger.info("Item quantity was selected");	 
	 }
	 @Then("User click add to Cart button")
	 public void userClickAddToCartButton() {
		 click(factory.orderPage().addToCardBttn);
		 logger.info("Add item to the cart button was selected");

		 
	 }
	 @Then("the cart icon quantity should change to {string}")
	 public void theCartIconQuantityShouldChangeTo(String itemQtyInTheCart) {
		 Assert.assertEquals(itemQtyInTheCart, factory.orderPage().cartItemQty.getText());
		 logger.info("Item qty in the cart was validated");

	 }
	 
	 //add item to the cart and place your order
	 
	 @Then("User change the category to {string} Apex Legends")
	 public void userChangeTheCategoryToApexLegends(String electronics) {
		 selectByVisibleText(factory.orderPage().allDepartmentDropdown, electronics);
		 logger.info("Category changed to electronics");
	
	 }
	 @Then("User search for an item {string} Apex Legends")
	 public void userSearchForAnItemApexLegends(String apexLegends) {
		 sendText(factory.orderPage().searchInputField, apexLegends);
		 logger.info("Iten name was entered");

	 }
	 @Then("User click on item Apex Legends")
	 public void userClickOnItemApexLegends() {
		 click(factory.orderPage().apexLegendsItem);
		 logger.info("Item Apex Legends was clicked");

	 }
	 @Then("User select quantity {string} for Apex Legends")
	 public void userSelectQuantityForApexLegends(String apexLegendsQty) {
		 click(factory.orderPage().qtyDropdown);
		 selectByVisibleText(factory.orderPage().qtyDropdown, apexLegendsQty);
		 logger.info("Apex Legends qty was changed");

	 }
	 @Then("the cart icon quantity should change to {string} Apex Legends")
	 public void theCartIconQuantityShouldChangeToApexLegends(String itemQtyInTheCart) {
	if(factory.orderPage().cartItemQty.equals(itemQtyInTheCart)) {
		 logger.info("Item qty in the cart was validated");
	}

	 }
	 @Then("User click on Cart option")
	 public void userClickOnCartOption() {
		 click(factory.orderPage().cartBttn);
		 logger.info("Cart button was clicked");
	
	 }
	 @Then("User click on Proceed to Checkout button")
	 public void userClickOnProceedToCheckoutButton() {
		 click(factory.orderPage().proceedToCheckoutBttn);
		 logger.info("Proceed to ckeck out button was clicked");
	
	 }
	 @Then("User click on Place Your Order")
	 public void userClickOnPlaceYourOrder() {
		 click(factory.orderPage().PlaceOrderBttn);
		 logger.info("Place your order button was clicked successfully");		 
	 } 
	 @Then("A message should be displayed {string}")
	 public void aMessageShouldBeDisplayed(String actualmssg) {
		 waitTillPresence(factory.orderPage().orderPlacedSuccessfullyMssg);
		 Assert.assertTrue(factory.orderPage().orderPlacedSuccessfullyMssg.isDisplayed());
		 actualmssg = factory.orderPage().orderPlacedSuccessfullyMssg.getText();
		 logger.info("Message is: " + actualmssg);	 
	 }

	 //cancel Order
	 @Then("User click on Orders section")
	 public void userClickOnOrdersSection() {
		 click(factory.orderPage().orderLink);
		 logger.info("Order link was clicked");

	 }
	 @Then("User click on first order in list")
	 public void userClickOnFirstOrderInList() {
		 List<WebElement> listOfOrders = factory.orderPage().listOfOrders;
		 for(int i = 0; i < listOfOrders.size(); i++) {
			 if(listOfOrders.get(i).getText().equalsIgnoreCase("Hide Details")) {
				 
			 }else if (listOfOrders.get(i).getText().equalsIgnoreCase("Show Details")) {
				click(factory.orderPage().listOfOrders.get(i));
			 }
		 }
		 logger.info("First order in the list is clicked");
	 }
	 @Then("User click on Cancel The Order button")
	 public void userClickOnCancelTheOrderButton() {
		List<WebElement> cancelBttns = factory.orderPage().cancelOrderBttn;
		for(int i = 0; i < cancelBttns.size(); i++) {
			click(cancelBttns.get(0));
		}
		logger.info("Order Cancel button was clicked");
	
	 }
	 @Then("User select the cancelation Reason {string}")
	 public void userSelectTheCancelationReason(String cancelationReason) {
		 selectByVisibleText(factory.orderPage().reasonForCancelation, cancelationReason);
		 logger.info("Cancelation reason was selected");
	
	 }
	 @Then("User click on Cancel Order button")
	 public void userClickOnCancelOrderButton() {
		 click(factory.orderPage().cancelationOrderBttn);
		 logger.info("Cancel Order Button was clicked");
	
	 }
	 @Then("a cancelation message should be displayed {string}")
	 public void aCancelationMessageShouldBeDisplayed(String CancelationSuccessMssg) {
		 Assert.assertEquals(CancelationSuccessMssg, factory.orderPage().orderCancelledSuccessMssg.getText());
		 logger.info("Cancelation success message was verified successfully");
	
	 }
	 //return order
	 @Then("User clicks on Orders section")
	 public void userClicksOnOrdersSection() {
		 click(factory.orderPage().orderLink);
		 logger.info("The first order was clicked");
	 }
 
	 @Then("User clicks on first order in list")
	 public void userClicksOnFirstOrderInList() {
		 click(factory.orderPage().firstOrderOnTheList);
		 logger.info("User clicked on first order");
	 }

	 @Then("User click on Return Items button")
	 public void userClickOnReturnItemsButton() {
		 click(factory.orderPage().returnOrderBttn);
		 logger.info("User clicked on return item button");

	 }
	 @Then("User select the Return Reason {string}")
	 public void userSelectTheReturnReason(String item) {
		 selectByVisibleText(factory.orderPage().listOfReturnReason, item);
		 logger.info("User selected the return reason");
	 }
		 

	 @Then("User select the drop off service {string}")
	 public void userSelectTheDropOffService(String fedEX) {
		 selectByVisibleText(factory.orderPage().dropOffOptions, fedEX);
		 logger.info("User selected the drop off service");
	 }

	 @Then("User click on Return Order button")
	 public void userClickOnReturnOrderButton() {
		 click(factory.orderPage().submitReturnOrder);
		 logger.info("User clicked on return order bttn");
	 }

	 @Then("cancelation message should be displayed {string}")
	 public void cancelationMessageShouldBeDisplayed(String message) {
		 waitTillPresence(factory.orderPage().returnConfirmMssg);
		 Assert.assertTrue(message,factory.orderPage().returnConfirmMssg.isDisplayed());
		 logger.info("Return was successful");		 
	 }

	 //Review on order place
	 @Then("User click on the Orders section")
	 public void userClickOnTheOrdersSection() {
		 click(factory.orderPage().orderLink);
		 logger.info("User clicked on the orders section");

	 }
	 @Then("User click on the first order in list")
	 public void userClickOnTheFirstOrderInList() {
		 click(factory.orderPage().firstOrderOnTheList);
		 logger.info("The first order on the list was clicked");

	 }
	 @Then("User click on Review button")
	 public void userClickOnReviewButton() {
		 click(factory.orderPage().reviewBtn);
		 logger.info("Review Bttn was clicked");

	 }
	 @Then("User write Review headline {string} and {string}")
	 public void userWriteReviewHeadlineAnd(String string, String string2) {
		 sendText(factory.orderPage().headlineInputField, string);
		 sendText(factory.orderPage().commentField, string2);
		 logger.info("User wrote review headline");

	 }
	 @Then("User click Add your Review button")
	 public void userClickAddYourReviewButton() {
		 click(factory.orderPage().addReviewBtn);
		 logger.info("Add your review button was clicked");

	 }
	 @Then("a review message should be displayed {string}")
	 public void aReviewMessageShouldBeDisplayed(String message) {
		 waitTillPresence(factory.orderPage().reviewAddedSuccessMsg);
		// String actualText = getText(factory.orderPage().reviewAddedSuccessMsg);
		 Assert.assertTrue(factory.orderPage().reviewAddedSuccessMsg.isDisplayed());
		 logger.info("Review message displayed");
		 

	 }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	     
}
