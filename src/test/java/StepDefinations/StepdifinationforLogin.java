package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pagefectory.LoginPage;

public class StepdifinationforLogin {
	WebDriver driver;
	LoginPage login;

	/// Hooks
	@Before
	public void setupfirst() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		
		//
		// // Create a WebDriver instance for Chrome
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Setup runed  before senario");
		Thread.sleep(3000);
	}

	@After
	public void close() {
		driver.quit();
	}

	/// Scenario start

	@Given("brower got opened with details")
	public void brower_got_opened_with_details() throws InterruptedException {
		System.out.println("lOGIN SCENARIO RUN STARTED");
		driver.get("http://demo.t3-framework.org/joomla30/index.php/en/");
		Thread.sleep(2000);

	}

	@And("User move to Layout dropdown")
	public void user_move_to_layout_dropdown() throws InterruptedException {
		WebElement web = driver.findElement(By.xpath("//a[text()='Layout ']"));
		Actions act = new Actions(driver);
		act.moveToElement(web).build().perform();
		// login = new LoginPage(driver);
		// login.moveToLayout();
		Thread.sleep(3000);
	}

	@When("User enter userid and password")
	public void user_enter_userid_and_password() {
		login = new LoginPage(driver);
		login.userId("banshi");
		login.password("12345");
	}

	@And("click on Login button")
	public void click_on_login_button() {
		login.login();
	}

	@Then("User should navigate to Warning page")
	public void user_should_navigate_to_warning_page() throws InterruptedException {

		login.validatepage();
		Thread.sleep(4000);

	}

}
