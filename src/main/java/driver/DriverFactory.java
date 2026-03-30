package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Collections;

public class DriverFactory {
	public static WebDriver initDriver() {
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-blink-features=AutomationControlled");
	    WebDriver driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    return driver; // Extremely important!
    }
}