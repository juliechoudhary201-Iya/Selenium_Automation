package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest{
	
	@Test
	public void validLogin()
	{
			
		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test - ");

		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);

		Log.info("Adding credentials");
		test.info("Adding Credentails");
		loginPage.Username("admin@yourstore.com");
		loginPage.Password("admin");
//		loginPage.enterUsername(username);
//		loginPage.enterPassword(password);
		test.info("Clicking on Login button");
		loginPage.Login();

		System.out.println("Title of the page is : " + driver.getTitle());
		Log.info("Verifying page title");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...1234");

		test.pass("Login Successful");
	}
}
