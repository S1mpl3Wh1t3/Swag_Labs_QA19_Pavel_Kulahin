package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends HomePage {
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");
    private final By itemName = By.cssSelector(".inventory_item_name");
    private final By itemDescription = By.cssSelector(".inventory_item_desc");
    private final By itemPrice = By.cssSelector(".inventory_item_price");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

    public String getItemDescription() {
        return driver.findElement(itemDescription).getText();
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

}