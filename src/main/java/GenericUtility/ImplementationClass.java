package GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "---starts");

	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "----execution successfully");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "---excecution failure");
		System.out.println(result.getThrowable());

		try {

			String path = new WebDriverUtility().takeScreenShot(BaseClass.sdriver, methodName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "----excecution Skipped");
		System.out.println(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		result.getMethod().getMethodName();
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		result.getMethod().getMethodName();
	}

	public void onStart(ITestContext context) {
		System.out.println("execution started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("execution Finished");
	}

}
