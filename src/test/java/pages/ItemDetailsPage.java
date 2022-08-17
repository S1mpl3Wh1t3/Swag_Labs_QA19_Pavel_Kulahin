package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailsPage extends HomePage {
    private final By backToProductsButton = By.id("back-to-products");
    private final By addToCartButton = By.cssSelector("button[id^=add-to-cart]");
    private final By itemName = By.cssSelector(".inventory_details_name");
    private final By itemPrice = By.cssSelector(".inventory_details_price");
    private final By itemDescription = By.cssSelector(".inventory_details_desc");


    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
    }

    public void clickBackToProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(backToProductsButton));
        driver.findElement(backToProductsButton).click();
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getItemDescription() {
        return driver.findElement(itemDescription).getText();
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }


}