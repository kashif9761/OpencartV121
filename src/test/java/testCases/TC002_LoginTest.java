package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity", "Master"})
	public void Verify_LoginTest()
	{
		logger.info("***** Starting TC_002_LoginTest *****");
		logger.debug("capturing application debug logs....");
		try
		{
		//Home Page
		HomePage hp=new HomePage(driver);
		hp.setMyAccount();
		logger.info("clicked on myaccount link on the home page..");
		hp.clickLogin();
		logger.info("clicked on login link under myaccount..");
		
		//Login Page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.setClickLogin();
		logger.info("clicked on ligin button..");
		
		//My Account Page
		MyAccountPage macc=new MyAccountPage(driver);
		
		boolean targetPage=macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Starting TC002_LoginTest *****");
	}
}
