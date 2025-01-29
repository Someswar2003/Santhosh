package GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.ByteArrayInputStream;

public class AllureTestListeners implements ITestListener {

//	@Override
//	public void onTestStart(ITestResult iTestResult) {
//		Allure.step(iTestResult.getName() + " has started.");
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult iTestResult) {
//		Allure.attachment("Test passed", "Yay, test passed!");
//	}
//
//	@Override
//	public void onTestFailure(ITestResult iTestResult) {
//		Allure.attachment("Test failed", "Oops, test failed!");
//		BaseClass baseClass = new BaseClass();
//		WebDriver driver = baseClass.sdriver;
//		WebDriverUtility wutil = new WebDriverUtility();
//		byte[] screenshot = wutil.takeScreenShotAllureReports(driver);
//		if (screenshot != null) {
//			Allure.attachment("Screenshot", new ByteArrayInputStream(screenshot));
//		}
//	}
//
//	
//
////	@Override
////	public void onTestFailure(ITestResult iTestResult) {
////	    Allure.attachment("Test failed", "Oops, test failed!");
////	    BaseClass baseClass = new BaseClass();
////	    WebDriver driver = baseClass.sdriver;
////	    WebDriverUtility wutil = new WebDriverUtility();
////	    byte[] screenshot = wutil.takeScreenShotAllureReports(driver);
////	    if (screenshot != null) {
////	        // Annotate the screenshot before attaching
////	        byte[] annotatedScreenshot = annotateScreenshot(driver, screenshot, iTestResult);
////	        Allure.attachment("Screenshot", new ByteArrayInputStream(annotatedScreenshot));
////	    }
////	}
////
////	private byte[] annotateScreenshot(WebDriver driver, byte[] screenshot, ITestResult iTestResult) {
////	    try {
////	        BufferedImage image = ImageIO.read(new ByteArrayInputStream(screenshot));
////
////	        // Get the XPath of the element that caused the failure
////	        String xpath = getXPathOfFailedElement(iTestResult);
////	        WebElement element = driver.findElement(By.xpath(xpath));
////
////	        // Highlight the element by drawing a rectangle around it
////	        highlightElement(image, element);
////
////	        // Save the annotated image to a byte array
////	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
////	        ImageIO.write(image, "png", outputStream);
////	        return outputStream.toByteArray();
////	    } catch (IOException e) {
////	        e.printStackTrace();
////	        return null;
////	    }
////	}
////
////	private String getXPathOfFailedElement(ITestResult iTestResult) {
////	    // Get the exception that caused the test failure
////	    Throwable throwable = iTestResult.getThrowable();
////
////	    // Check if the exception is of type WebDriverException or its subclasses
////	    if (throwable instanceof WebDriverException) {
////	        WebDriverException webDriverException = (WebDriverException) throwable;
////
////	        // Extract information from the exception message or stack trace
////	        String exceptionMessage = webDriverException.getMessage();
////	        StackTraceElement[] stackTrace = webDriverException.getStackTrace();
////
////	        // Perform parsing or regex operations on the exception message or stack trace
////	        // to identify the element that caused the failure and extract its details
////
////	        // Example: Extracting XPath from exception message using regex
////	        Pattern pattern = Pattern.compile("xpath=\\\"(.*?)\\\"");
////	        Matcher matcher = pattern.matcher(exceptionMessage);
////	        if (matcher.find()) {
////	            return matcher.group(1);
////	        }
////
////	        // If XPath is not found in the exception message, you can also analyze
////	        // the stack trace or any other available information to identify the element
////	    }
////
////	    // If unable to determine the XPath, return a placeholder or null
////	    return "//img[@alt='logo']";
////	}
////
////	private void highlightElement(BufferedImage image, WebElement element) {
////	    try {
////	        Graphics2D graphics = image.createGraphics();
////	        graphics.setColor(Color.RED);
////	        Point elementLocation = element.getLocation();
////	        Dimension elementSize = element.getSize();
////	        graphics.drawRect(elementLocation.getX(), elementLocation.getY(), elementSize.getWidth(), elementSize.getHeight());
////	        graphics.dispose();
////	    } catch (Exception e) {
////	        e.printStackTrace();
////	    }
////	}
//
//	@Override
//	public void onTestSkipped(ITestResult iTestResult) {
//		Allure.step(iTestResult.getName() + " was skipped.", Status.SKIPPED);
//	}
//	
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//	}
//
//	@Override
//	public void onStart(ITestContext iTestContext) {
//	}
//
//	@Override
//	public void onFinish(ITestContext iTestContext) {
//
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult iTestResult) {
//	}
}
