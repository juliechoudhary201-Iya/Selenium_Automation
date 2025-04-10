package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {
	
	private WebDriver driver;
	
	//Defined for the Page Factory
	@FindBy(id="Email")
	WebElement Username;
	
	@FindBy(id="Password")
	WebElement Password;
	
	//@FindBy(xpath="//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[4]/button")
	@FindBy(css = "button[type='submit']")
	WebElement Login;
	
	
	//private By Username = By.id("Email"); ......USED IN POM
	//private By Password = By.id("Password");......USED IN POM
	//private By Login = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button"); ......USED IN POM
	
	public LoginPage(WebDriver driver)
	{
		this.driver =driver; 
		PageFactory.initElements(driver, this); //Defined for the Page Factory
	}

	public void Username(String username)
	{
		Username.clear();   //Defined for the Page Factory
		Username.sendKeys(username);   //Defined for the Page Factory
		
		//driver.findElement(Username).clear(); ......USED IN POM
		//driver.findElement(Username).sendKeys(username); ......USED IN POM
	}
	public void Password(String password)
	{
		Password.clear(); //Defined for the Page Factory
		Password.sendKeys(password); //Defined for the Page Factory
		
		//driver.findElement(Password).clear(); ......USED IN POM
		//driver.findElement(Password).sendKeys(password); ......USED IN POM
	}
	public void Login()
	{
		Log.info("Cicking Login button...");
		Login.click(); //Defined for the Page Factory
		
		//driver.findElement(Login).click(); ......USED IN POM
		
	}

}
