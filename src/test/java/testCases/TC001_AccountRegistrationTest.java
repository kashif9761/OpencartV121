package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	

@Test(groups={"Regression", "Master"})
public void verfiy_account_registration()
{
	logger.info("***** Starting TC_001_AccountRegistrationTest ******");
	//logger.debug("This is a debug log message");
	try
	{
	HomePage hp=new HomePage(driver);
	hp.setMyAccount();
	logger.info("Clicked on MyAccount Link...");
	
	hp.setRegistr();
	logger.info("Clicked on Registeration Link...");
	
	AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
	
	logger.info("Providing customer details...");
	regPage.setFirstName(randomeString().toUpperCase());
	regPage.setLastName(randomeString().toUpperCase());
	//Thread.sleep(2000);
	regPage.setEmail(randomeString()+"@gmail.com");
	regPage.setTelephone(randomeNumber());
	
	String password=randomeAlphaNumberic();
			   
	regPage.setPassword(password);
	regPage.setConfirmPassword(password);
	regPage.setCheckedPrivacyPolicy();
	regPage.clickContinue();
	
	logger.info("Validating expected message...");
	
	String confmsg=regPage.getMsgConfirmation();
	if(confmsg.equals("Your Account Has Been Created!"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("Test Failed...");
		logger.debug("Debug logs...");
		Assert.assertTrue(false);
	}
	//Assert.assertEquals(act_msg, "Your Account Has Been Created!");
	}
	catch(Exception e)
	{
		Assert.fail();
		
	}
	
	logger.info("***** Finished TC_001_AccountRegistrationTest ******");
	
	}
}	  
    

