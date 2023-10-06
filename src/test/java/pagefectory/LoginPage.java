package pagefectory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//a[text()='Layout ']")
	WebElement drd_Layout;
	@FindBy(xpath = "//input[@name='username']")
	WebElement txt_uname;
	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_pass;
	@FindBy(xpath = "//input[@name='Submit']")
	WebElement btn_submit;
	@FindBy(xpath = "//h4[text()='Warning']")
	WebElement txt_validate;
	@FindBy(xpath = "//p[text()='Username and password do not match or you do not have an account yet.']")
	WebElement txt_highlight;

	WebDriver driver;

	public LoginPage(WebDriver driver1)

	{
		this.driver = driver1;

		/// initialise the element for that need to user initElements of pagefactory class, then only when ever this
		/// class will call any where all webelement will inisialised

		PageFactory.initElements(driver1, this); /// here we can also wtite class name .class intead of this

	}

	public void moveToLayout()

	{
		Actions act = new Actions(driver);
		act.moveToElement(drd_Layout).build().perform();

	}

	public void userId(String userid)

	{
		txt_uname.sendKeys(userid);

	}

	public void password(String userpass) {
		txt_pass.sendKeys(userpass);

	}

	public void login() {
		btn_submit.click();

	}

	public void validatepage() {
		String str = txt_validate.getText();
		if (str.equals("Warning")) {
			highlight(txt_highlight);
		}

	}

	public void highlight(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);

	}
}
