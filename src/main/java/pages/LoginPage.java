package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By Username = By.id("Email");
	private By Password = By.id("Password");
	private By Login = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	
	public LoginPage(WebDriver driver)
	{
		this.driver =driver; 
	}

	public void Username(String username)
	{
		driver.findElement(Username).clear();
		driver.findElement(Username).sendKeys(username);
	}
	public void Password(String password)
	{
		driver.findElement(Password).clear();
		driver.findElement(Password).sendKeys(password);
	}
	public void Login()
	{
		driver.findElement(Login).click();
		
	}

}
