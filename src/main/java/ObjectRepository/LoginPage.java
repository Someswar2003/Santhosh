package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {

	// intilization f the WebElements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Enter Email Id']")
	private WebElement emailIdText;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement passwordText;

	@FindBy(xpath = "//button[normalize-space(text())='Submit']")
	private WebElement submitBtn;

	public void loginIntoApplication(String url, String username, String password, WebDriver driver) {
		driver.get(url);
		emailIdText.sendKeys(username);
		passwordText.sendKeys(password);
		submitBtn.click();
	}

}
