package tek.capstone.guardians.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class RetailHomePage extends BaseSetup{
	
	
//We will create a constructor and by using the initElements method from  pageFactory
//class we will initialize our page objects in this class
	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(linkText = "TEKSCHOOL")
	public WebElement tekschoolLogo;
		
	@FindBy(id = "signinLink") 
	public WebElement signInBtn;

	@FindBy(id="hamburgerBtn") 
	public WebElement allOptions; 
	
	@FindBy(xpath = "//div[@class='sidebar__content']//span")
	public List<WebElement> sideBarOptions;
	
	@FindBy(xpath = "//div[@class='sidebar_content-item']//span")
	public List<WebElement> sideBarAllOptions;
	
	
//	@FindBy(xpath="//div[@class='sidebar__content']//span")
//	public List<WebElement> sideBarAllOptions;
	
//	@FindBy(xpath="//div[@class='modal__content h-screen w-80 ']//span")
//    public List<WebElement> sideBarOptions;
	
	
	
	@FindBy(id="contentHeader")
	public WebElement departmentHeader;
	
	@FindBy(id ="signinBtn")
	public WebElement signIn;//Case locator
	
	
	
	
	
	
	
	
}
