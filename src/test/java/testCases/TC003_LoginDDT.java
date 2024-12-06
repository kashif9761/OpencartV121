package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass 
{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email, String password, String exp) 
	{
		logger.info("**** Started TC_003_LoginDDT *****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.setMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.setClickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		/*if data is valid login succes - valid/Pass-logout
		                   login failed - invalid/Failed
		 *if data is invalid login succes - invalid/Failed-logout
		                     login failed - valid/Pass
		 */
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
			macc.clickLogout();
			Assert.assertTrue(true);
			}
			else
			{
			Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		    
		}
		}
		catch(Exception e)
		{
			Assert.fail("Exception Occured"+e.getMessage());
		}
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
}
