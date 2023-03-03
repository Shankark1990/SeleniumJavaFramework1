package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "userEmail")
	WebElement userid;
	
	@FindBy(id = "userPassword")
	WebElement pass;
	
	@FindBy(id = "login")
	WebElement login_btn;
	
	@FindBy(xpath = "//div[@class='left mt-1'] /p")
	WebElement verify;
	
	
	public void loginApp(String username, String password)
	{
		userid.sendKeys(username);
		pass.sendKeys(password);
		
	}
	
	public void clickButton()
	{
		login_btn.click();
	}
	
	public boolean verifyLogin()
	{
		return verify.isDisplayed();
	}

}
