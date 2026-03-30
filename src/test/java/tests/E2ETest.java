package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;
import utils.FileUploadUtil;

public class E2ETest {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void testFullFlowWithItem() throws InterruptedException {
        // 1. SIGNUP & ACCOUNT CREATION
        String email = "hcl_user_" + System.currentTimeMillis() + "@gmail.com";
        loginPage.fullSignup("HCL Tester", email); 
        // Note: My previous LoginPage.java includes the 'Continue' click already.

        // 2. SELECT ITEM (Fixes the "Cart is Empty" issue)
        productPage.addAnyItemToCart();

        // 3. GO TO CART (From Top Menu)
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
        Thread.sleep(2000);

        // 4. CHECKOUT
        driver.findElement(By.linkText("Proceed To Checkout")).click();
        Thread.sleep(2000);

        // 5. CONTACT SUPPORT & FILE UPLOAD
        driver.findElement(By.linkText("Contact us")).click();
        Thread.sleep(2000);
        
        // Fill mini-form
        driver.findElement(By.name("name")).sendKeys("Tester");
        driver.findElement(By.name("email")).sendKeys(email);
        
        // Trigger Windows Dialog
        driver.findElement(By.name("upload_file")).click(); 
        Thread.sleep(2000);

        // 6. AUTOIT
        String autoIt = ConfigReader.getProperty("autoit_path");
        String image = ConfigReader.getProperty("image_path");
        FileUploadUtil.uploadFileUsingPath(autoIt, image);
        
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}