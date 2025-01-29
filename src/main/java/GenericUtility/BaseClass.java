package GenericUtility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.LogOutPage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains Implementation of all Basic configuration Annotations
 * 
 * @author Sudarshan
 *
 */
public class BaseClass extends WebDriverUtility {

	public WebDriver driver = null;
	public static WebDriver sdriver;
	public FileUtility futil = new FileUtility();
	public ExcelUtility eutil = new ExcelUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();

	@BeforeSuite
	public void bsuite() {

	}

	@BeforeTest
	public void btest() {

	}

	/*
	 * @throws Throwable
	 */
	@BeforeClass
	public void bclass() throws Throwable {
		String browserName = futil.getProperyKeyValue("browser");

		String url = futil.getProperyKeyValue("url");
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			DesiredCapabilities caps = new DesiredCapabilities();
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

			// Show Notification
			Map<String, Object> prefs = new HashMap<String, Object>();
			Map<String, Object> profile = new HashMap<String, Object>();
			Map<String, Object> contentSettings = new HashMap<String, Object>();
			contentSettings.put("notifications", 1);
			profile.put("managed_default_content_settings", contentSettings);
			prefs.put("profile", profile);
			options.setExperimentalOption("prefs", prefs);

			// SET CAPABILITY
			caps.setCapability(ChromeOptions.CAPABILITY, options);

			// camera
			options.addArguments("use-fake-device-for-media-stream");
			options.addArguments("use-fake-ui-for-media-stream");

			// print preview app
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			options.addArguments("--kiosk");
			options.addArguments("--kiosk-printing");
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			options.addArguments("--remote-allow-origins=*");

			options.addArguments("--disable-extensions");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-plugins");
			options.addArguments("--enable-accelerated-2d-canvas");
			options.addArguments("--enable-accelerated-vpx-decode");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

			// options.addArguments("--headless");
			// options.setHeadless(true);

			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launch browser is " + browserName);

		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("launch browser is " + browserName);
		} else {
			System.out.println("Specify Valid broswer");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		sdriver = driver;
	}

	/**
	 * This Annotation is used to Login to the Application
	 * 
	 * @throws Throwable
	 */
	@BeforeMethod
	public void bmethod() throws Throwable {
		String url = futil.getProperyKeyValue("url");
		String username = futil.getProperyKeyValue("username");
		String password = futil.getProperyKeyValue("password");
		LoginPage page = new LoginPage(driver);
		page.loginIntoApplication(url, username, password, driver);
	}

	/**
	 * This Annotation is used to Sign Out the Application
	 * 
	 * @throws Throwable
	 */
	@AfterMethod
	public void amethod() throws Throwable {
		LogOutPage lp = new LogOutPage(driver);
		lp.userNameBtn(driver);
	}

	/**
	 * This Annotation is used to Close the Browser
	 */
	@AfterClass
	public void aclass() {
		driver.quit();
		System.out.println("Close the Browser");
	}

	@AfterTest
	public void atest() {

	}

	@AfterSuite
	public void asuite() {

	}

}
