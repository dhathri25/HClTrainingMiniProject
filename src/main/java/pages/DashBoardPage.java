package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    WebDriver driver;

    // Locators
    By contactUsLink = By.linkText("Contact us");
    By logoutLink = By.linkText("Logout");
    By productsLink = By.linkText("Products");

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContactUs() {
        driver.findElement(contactUsLink).click();
    }
    
    public void clickProducts() {
        driver.findElement(productsLink).click();
    }
}