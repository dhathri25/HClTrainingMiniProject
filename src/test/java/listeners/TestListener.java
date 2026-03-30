package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;
import driver.DriverFactory;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        try {
            ScreenshotUtil.capture(
                DriverFactory.initDriver(),
                result.getName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}