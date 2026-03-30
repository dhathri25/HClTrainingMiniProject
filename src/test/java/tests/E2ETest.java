package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.FileUploadUtil;

public class E2ETest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");
    }

    @Test
    public void testFullJourney() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // --- 1. SIGNUP ---
        String email = "hcl_test" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("HCL Tester");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        Thread.sleep(2000); 

        // --- 2. FILL ACCOUNT DETAILS ---
        driver.findElement(By.id("password")).sendKeys("Password123!");
        driver.findElement(By.id("first_name")).sendKeys("HCL");
        driver.findElement(By.id("last_name")).sendKeys("Tester");
        driver.findElement(By.id("address1")).sendKeys("123 Automation Lane");
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
        driver.findElement(By.id("state")).sendKeys("Karnataka");
        driver.findElement(By.id("city")).sendKeys("Bangalore");
        driver.findElement(By.id("zipcode")).sendKeys("560001");
        driver.findElement(By.id("mobile_number")).sendKeys("9876543210");

        // --- 3. CREATE ACCOUNT ---
        WebElement createBtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        js.executeScript("arguments[0].click();", createBtn); 
        Thread.sleep(2000);
        
        WebElement contBtn = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        js.executeScript("arguments[0].click();", contBtn);
        Thread.sleep(2000);

        // --- 4. ADD ITEM TO CART ---
        driver.get("https://automationexercise.com/products");
        Thread.sleep(2000);
        
        WebElement addToCart = driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]"));
        js.executeScript("arguments[0].click();", addToCart);
        Thread.sleep(2000);

        WebElement viewCart = driver.findElement(By.xpath("//u[text()='View Cart']"));
        js.executeScript("arguments[0].click();", viewCart);
        Thread.sleep(2000);

        // --- 5. CHECKOUT ---
        WebElement checkoutBtn = driver.findElement(By.linkText("Proceed To Checkout"));
        js.executeScript("arguments[0].click();", checkoutBtn);
        Thread.sleep(2000);

        // --- 6. CONTACT US & AUTOIT UPLOAD ---
        WebElement contactUsLink = driver.findElement(By.linkText("Contact us"));
        js.executeScript("arguments[0].click();", contactUsLink);
        Thread.sleep(3000); 

        driver.findElement(By.name("name")).sendKeys("HCL Tester");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("subject")).sendKeys("Test Upload");
        driver.findElement(By.id("message")).sendKeys("Automated file upload test.");

        WebElement uploadBtn = driver.findElement(By.name("upload_file"));
        try {
            uploadBtn.click(); 
        } catch (Exception e) {
            new org.openqa.selenium.interactions.Actions(driver).moveToElement(uploadBtn).click().perform();
        }
        Thread.sleep(3000); 

        // EXECUTE AUTOIT
        String autoItPath = ConfigReader.getProperty("autoit_path");
        String imagePath = ConfigReader.getProperty("image_path");
        FileUploadUtil.uploadFileUsingPath(autoItPath, imagePath);

        // --- 7. VERIFICATION (Check if file is attached) ---
        Thread.sleep(5000); 
        String uploadedValue = uploadBtn.getAttribute("value");
        
        if (uploadedValue != null && !uploadedValue.isEmpty()) {
            System.out.println("✅ SUCCESS: File attached! Filename: " + uploadedValue);
        } else {
            System.out.println("❌ FAILED: The upload field is empty.");
            Assert.fail("The file was not uploaded by AutoIt.");
        }

        // Final Submission
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept(); // Handle the confirmation alert
        System.out.println("Form Submitted Successfully!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}