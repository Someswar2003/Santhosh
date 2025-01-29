package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.WebDriverUtility;

public class LogOutPage extends WebDriverUtility {
	public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//a[@role='button']//img")
	private WebElement  userNameBtn;

	@FindBy(xpath = "//i[text()=' Log Out']")
	private WebElement logOutBtn;


	/*
	 * 
	 *
	 * Business Logics
	 * 
	 * 
	 */

	public void userNameBtn(WebDriver driver) throws Throwable {
		explictWaitForElementToBeVisible(driver, userNameBtn);
		doubleClick(driver, userNameBtn);
		//  userNameBtn.click();
		  explictWaitForElementToBeVisible(driver, logOutBtn);
		  logOutBtn.click();
	}
	
//	public  void logoutBtnTheApplication (WebDriver driver) {
//		signOutBtn.click();
//	}
}