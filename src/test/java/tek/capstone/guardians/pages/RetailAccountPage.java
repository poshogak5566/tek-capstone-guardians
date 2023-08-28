package tek.capstone.guardians.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.guardians.base.BaseSetup;

public class RetailAccountPage extends BaseSetup{
	
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "accountLink")
    public WebElement accountLink;
	
	@FindBy(id = "nameInput")
	public WebElement nameFiled;
	
	@FindBy(id = "personalPhoneInput")
	public WebElement phonefiled;
	
	@FindBy(xpath = "//button[text()='Update']")
	public WebElement updateBttn;
	
	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdateSuccessMssg;
	
	@FindBy(xpath = "//p[text()='Add a payment method']")
	public WebElement addAPaymentMethodLink;
	
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumberFiled;
	
	@FindBy(id = "nameOnCardInput")
	public WebElement nameOnCardNFiled ;
	
	@FindBy(id = "expirationMonthInput")
	public WebElement expairationMonthFiled;
	
	@FindBy(id = "expirationYearInput")
	public WebElement expirationYearFiled;
	
	@FindBy(id = "securityCodeInput")
	public WebElement securityCodeFiled;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement paymentSubmitBtn;
	
	@FindBy(xpath ="//div[text()='Payment Method added sucessfully']")
	public WebElement paymentMethodSuccessMssge;

	@FindBy(xpath = "//button[@class='text-blue-800 cursor-pointer hover:underline' and text()='Edit']")
	public WebElement editCrdeBttn;
	
	@FindBy(id = "paymentSubmitBtn")
	public WebElement updatePaymentBttn;
	
	@FindBy(xpath = "//div[text()='Payment Method updated Successfully']")
    public WebElement updatePaymentSuccessMsg;
	
	@FindBy(xpath = "//div[@class='false account__payment-item']")
	public WebElement clickOnCard;
	
	 @FindBy(xpath = "//button[text()='remove']")
	    public WebElement removeCard;
	 
	 @FindBy(xpath = "//h1[@class='account__payment-new-title']")
	    public WebElement addCardBoxHeader;
	 
	 @FindBy(xpath = "//div[starts-with(@class,'account__address-new-')]")
	 public WebElement addAddressLink;
	  
	 @FindBy(id = "countryDropdown")
	 public WebElement addressCountryDropDown;
	 
	 @FindBy(id = "fullNameInput")
	 public WebElement addressNameF;
	 
	 @FindBy(id = "phoneNumberInput")
	 public WebElement addressPhoneF;
	 
	 @FindBy(id = "streetInput")
	 public WebElement addressStreetF;
	 
	 @FindBy(id = "apartmentInput")
	 public WebElement addressApartmentNum;
	  
	 @FindBy(id = "cityInput")
	 public WebElement addressCityF;
	
	@FindBy(name = "state")
	public WebElement addressStateDropdown;
	
	@FindBy(id = "zipCodeInput")
	public WebElement addressZipCode;
	
	@FindBy(id = "addressBtn")
	public WebElement  addressAddBttn;
	
	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressSuccessMssg;
	
	//update address
	@FindBy(xpath = "//button[@class='account__address-btn' and text()='Edit'][1]")
    public WebElement editAddressLink;
	
	@FindBy(id = "addressBtn")
	public WebElement updateAddressBtn;
	
	@FindBy(xpath = "//div[text()='Address Updated Successfully']")
	public WebElement addressUpdatedSuccessfully;
	
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeAddressBtn;
	
	@FindBy(css = "div.account__address-single")
	public WebElement addressBr;
	
	
	
	
	
	
	
	
	
	
}
