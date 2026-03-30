package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
    WebDriver driver;

    private By contactUsLink = By.linkText("Contact us");
    private By nameField     = By.name("name");
    private By emailField    = By.name("email");
    private By uploadInput   = By.name("upload_file"); // This triggers the Windows Dialog

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToContactAndTriggerUpload() throws InterruptedException {
        driver.findElement(contactUsLink).click();
        Thread.sleep(2000);
        driver.findElement(nameField).sendKeys("Test User");
        driver.findElement(emailField).sendKeys("test@mail.com");
        
        // CLICK the upload button to open the Windows "Open" dialog
        driver.findElement(uploadInput).click(); 
        Thread.sleep(2000); 
    }
}