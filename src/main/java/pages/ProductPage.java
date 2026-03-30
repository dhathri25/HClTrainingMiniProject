package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    // Locators for adding an item
    private By firstProductAddBtn = By.xpath("(//a[@data-product-id='1'])[1]");
    private By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
    private By cartHeaderLink = By.xpath("//a[contains(text(),'Cart')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addAnyItemToCart() throws InterruptedException {
        // 1. Scroll a bit or just click the first 'Add to Cart' button on the home page
        driver.findElement(firstProductAddBtn).click();
        Thread.sleep(2000); // 2-second wait for pop-up

        // 2. CRITICAL: Click 'Continue Shopping' to close the overlay
        driver.findElement(continueShoppingBtn).click();
        Thread.sleep(2000);
    }
}