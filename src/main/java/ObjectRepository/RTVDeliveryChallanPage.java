package ObjectRepository;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class RTVDeliveryChallanPage extends WebDriverUtility {
	
	public RTVDeliveryChallanPage (WebDriver driver) {
		PageFactory.initElements(driver , this);
		
		
	}

	
	//Xpaths
	
	@FindBy(xpath = "//i[@class='zmdi zmdi-swap']")
	private WebElement hamberBtn;
	
	@FindBy(xpath = "//input[@placeholder='Search For Page']")
	private WebElement searchForPageText;
	
	@FindBy(xpath = "//a[text()=' RTV Delivery Challan ']")
	private WebElement rTVDeliveryChallanText;
	
	@FindBy(xpath = "//a[text()=' Add ']")
	private WebElement addBtnText;
	
	@FindBy(xpath = "//label[text()='Store Name']//..//span[@role='presentation']")
	private WebElement  storeNameText;
	
	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement dropDownSearch;
	
	@FindBy(xpath = "//label[text()='Vendor Name']//..//span[@role='presentation']")
	private WebElement vendorNameText;
	
	@FindBy(xpath = "//label[text()='Return Type']//..//span[@role='presentation']")
	private WebElement returnText;
	
	@FindBy(xpath = "//textarea[@formcontrolname='remarks']")
	private WebElement  remarkText;
	
	@FindBy(xpath = "//table//tr[1]//td[2]//span[@role='presentation']")
	private WebElement itemsdetailsText;
	
	@FindBy(xpath = "//table//tr[1]//td[3]//span[@role='presentation']")
	private WebElement batchNumberText;
	
	@FindBy(xpath = "//table//tr[1]//td[10]//../input")
	private WebElement returnQuantityText;
	
	@FindBy(xpath = "//table//tr[1]//td[last()]//button[@type='button']")
	private WebElement plusBtn;
	
	@FindBy(xpath = "(//button[text()=' submit ']/following-sibling::button)[1]")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[2]//a")
	private WebElement tableRTVChallanNumber;
	
	
	
	
	
	
	
	//Logics
	
	
	public void clickonThehamberBtn(WebDriver driver) {
		explictWaitForElementToBeVisible(driver, hamberBtn);
		hamberBtn.click();
	}
	
	public void enterThesearchForPageText(WebDriver driver,String page) {
		searchForPageText.sendKeys(page);
	}
	
	public void clickOnTherTVDeliveryChallanText(WebDriver driver) {
		doubleClickOnTheElement(driver, rTVDeliveryChallanText);
		rTVDeliveryChallanText.click();
	}
	
	public void clickonTheaddBtnText(WebDriver driver) {
		scroll_Up_FullPage_UsingJavaScriprExecuter(driver);

		addBtnText.click();
	}
	
	public void clickonThestoreNameText(WebDriver driver,String store) {
		dropdown(driver, storeNameText, dropDownSearch, store);
	}
        
	public void clickOnthevendorNameText(WebDriver driver,String name) {
		dropdown(driver, vendorNameText, dropDownSearch, name);
	
	}
	
	public void clickOnThereturnText(WebDriver driver,String returnType) {
		dropdown(driver, returnText, dropDownSearch, returnType);
		
	}
	
    public void enterTheremarkText(WebDriver driver ,String remark) {
    	scrollDownByUsingJavascriptExecuter(driver);
    	explictWaitForElementToBeVisible(driver, remarkText);
    	 remarkText.sendKeys(remark);
    }
    
    public void clickOnTheitemsdetailsText(WebDriver driver,String item)throws Throwable {
    	Thread.sleep(3000);
    	explictWaitForElementToBeVisible(driver, itemsdetailsText);
    	itemsdetailsText.click();
    	Thread.sleep(2000);
    	
    	explictWaitForElementToBeVisible(driver, dropDownSearch);
    	dropDownSearch.sendKeys(item,Keys.ENTER);
    	
    
    }
    
    public void clickOnThebatchNumberText(WebDriver driver,String batch) {
    	batchNumberText.click();
    	dropDownSearch.sendKeys(batch,Keys.ENTER);
    }
    
    public void enterthereturnQuantityText(WebDriver driver,String returnQuantity) {
    	returnQuantityText.sendKeys(returnQuantity);
    	
    }
    
    public void clickOntheplusBtn(WebDriver driver) {
    	plusBtn.click();
    }
    
    public void clickOnThesubmitBtn(WebDriver driver) {
    	submitBtn.click();
    }
    
    
    public void closetheJaserReport(WebDriver driver) throws Throwable {
    	  Thread.sleep(4000);
	    Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);  
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    
    public void clickOnTheokBtn(WebDriver driver) {
    	okBtn.click();
    }
    
    public void clickOnThetableRTVChallanNumber(WebDriver driver) {
    	tableRTVChallanNumber.click();
    	scrollDownTheStillEndOfThePage(driver);
    	submitBtn.click();
    	okBtn.click();
    }
    
    
}

	

