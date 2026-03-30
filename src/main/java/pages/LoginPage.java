package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Signup Locators
    private By signupName = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    private By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    // Second Page Locators
    private By passwordField = By.id("password");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By address = By.id("address1");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobile = By.id("mobile_number");
    private By createAccBtn = By.xpath("//button[@data-qa='create-account']");
    
    // Header/Top Menu Locators
    private By continueBtn = By.xpath("//a[@data-qa='continue-button']");
    private By cartMenu = By.xpath("//a[contains(text(),'Cart')]");
    private By contactUsMenu = By.xpath("//a[contains(text(),'Contact us')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fullSignup(String name, String email) throws InterruptedException {
        driver.findElement(signupName).sendKeys(name);
        driver.findElement(signupEmail).sendKeys(email);
        driver.findElement(signupBtn).click();
        Thread.sleep(2000);

        driver.findElement(passwordField).sendKeys("Pass123!");
        driver.findElement(firstName).sendKeys("John");
        driver.findElement(lastName).sendKeys("Doe");
        driver.findElement(address).sendKeys("Test Ave 123");
        driver.findElement(state).sendKeys("NY");
        driver.findElement(city).sendKeys("New York");
        driver.findElement(zipcode).sendKeys("10001");
        driver.findElement(mobile).sendKeys("1234567890");
        Thread.sleep(2000);
        
        driver.findElement(createAccBtn).click();
        Thread.sleep(2000);

        // This "Continue" button is what unlocks the Top Menu (Cart/Contact)
        driver.findElement(continueBtn).click();
        Thread.sleep(2000);
    }

    public void clickCartInHeader() throws InterruptedException {
        driver.findElement(cartMenu).click();
        Thread.sleep(2000);
    }

    public void clickContactUsInHeader() throws InterruptedException {
        driver.findElement(contactUsMenu).click();
        Thread.sleep(2000);
    }

	public void login(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
}