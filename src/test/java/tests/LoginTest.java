package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@DataProvider(name = "LoginData1") // To get DATA from Excel Sheet
	public Object[][] getLoginData() throws IOException {

		String filePath = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];

		for (int i = 1; i < rowCount; i++) {

			data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Username
			data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Password
		}
		ExcelUtils.closeExcel();
		return data;
	}

	//@DataProvider(name = "LoginData2") ..........To get DATA from DataProvider Method
	//public Object[][] getData() {

		//return new Object[][] { { "user1", "pass1" }, { "user2", "pass2" }, { "user3", "pass3" } };
	//}

	
	@Test(dataProvider = "LoginData1") // Here we can call the dataProvider name either "LoginData1" OR "LoginData2"

	// @Test
	// @Parameters({"username","password"}) .......To get DATA from testngData.xml

	//Move to Dev branch
	public void validLogin(String username, String password) {

		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test - ");

		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);

		Log.info("Adding credentials");
		test.info("Adding Credentails");

		// loginPage.Username("admin@yourstore.com");
		// loginPage.Password("admin");

		loginPage.Username(username);
		loginPage.Password(password);

		test.info("Clicking on Login button");
		loginPage.Login();

		System.out.println("Title of the page is : " + driver.getTitle());
		Log.info("Verifying page title");
		test.info("Verifying page title");
		// Get the title of the page
		String pageTitle = driver.getTitle();

		// Assert that the title contains the expected substring
		Assert.assertTrue(pageTitle.contains("Just a moment..."),
				"Page title does not contain the expected substring.");
		test.pass("Login Successful");
	}
}
