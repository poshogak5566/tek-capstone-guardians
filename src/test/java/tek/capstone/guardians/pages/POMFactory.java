package tek.capstone.guardians.pages;

import tek.capstone.guardians.base.BaseSetup;

public class POMFactory extends BaseSetup{
	
	
	
	private RetailSignInPage signinpage;
	private RetailHomePage homePage;
	private RetailAccountPage accountpage;
	private RetailOrderPage orderPage;

	public POMFactory() {
	        this.homePage = new RetailHomePage();
	        this.signinpage = new RetailSignInPage();
	        this.accountpage = new RetailAccountPage();
	        this.orderPage = new RetailOrderPage();
	
	}
	
    public RetailHomePage homePage() {
	        return this.homePage;
	    }
    public RetailSignInPage signinpage() {
    	
    	return this.signinpage;
    }
   
    public RetailAccountPage accountpage() {
    	return this.accountpage;
    	
    }
    
    public RetailOrderPage orderPage() {
    	return this.orderPage;
    }
}