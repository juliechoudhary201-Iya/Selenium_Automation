package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void validLogin()
	{
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.Username("admin@yourstore.com");
		loginpage.Password("admin");
		loginpage.Login();
		
		System.out.println("This is the title of page: "+ driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}
}
