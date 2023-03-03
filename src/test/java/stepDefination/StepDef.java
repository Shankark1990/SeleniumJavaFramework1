package stepDefination;

import java.util.ResourceBundle;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class StepDef {
	
	WebDriver driver;
	LoginPage lp;
	Logger logs;
	ResourceBundle rb;
	
	String br;
	
	@Before
	public void setup()
	{
//		logs=LogManager.getLogger(getClass());
//		rb=ResourceBundle.getBundle("config");
//		br=rb.getString("browser");
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		System.out.println("Scenario status is =====>"+scenario.getName());
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			
		}
		
		driver.quit();
	}
	
	@Given("user open url {string}")
	public void user_open_url(String path) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(path);
	}
	
	
	@When("user enter username {string} and password {string}")
	public void user_enter_username_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		
		lp=new LoginPage(driver);
		lp.loginApp(string, string2);
	    
	}

	@When("click on login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	   lp.clickButton();
	}

	@Then("Verify login is successfully or not")
	public void verify_login_is_successfully_or_not() {
	    // Write code here that turns the phrase above into concrete actions
	   boolean match=lp.verifyLogin();
	   Assert.assertTrue(match);
	}


}
