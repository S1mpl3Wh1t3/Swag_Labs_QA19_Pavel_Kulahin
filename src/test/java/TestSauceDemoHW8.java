import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestSauceDemoHW8 extends BaseTests {


    By userNames = By.id("user-name");
    By passwords = By.id("password");
    By loginButtons = By.id("login-button");
    By sauceLabsBackpackAddToCarts = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    By shoppingCarts = By.className("shopping_cart_badge");
    By nameBackpacks = By.xpath("//div[text()='Sauce Labs Backpack']");
    By inventoryItemPrices = By.className("inventory_item_price");
    String itemSauceLabsBackpack = "Sauce Labs Backpack";
    String itemPriceExpectedResult = "$29.99";


    @Test
    public void testSauceDemo() {

        WebElement userName = driver.findElement(userNames);
        WebElement password = driver.findElement(passwords);
        WebElement loginButton = driver.findElement(loginButtons);
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        WebElement sauceLabsBackpackAddToCart = driver.findElement(sauceLabsBackpackAddToCarts);
        sauceLabsBackpackAddToCart.click();
        WebElement shoppingCart = driver.findElement(shoppingCarts);
        shoppingCart.click();
        WebElement nameBackpack = driver.findElement(nameBackpacks);
        Assert.assertEquals(nameBackpack.getText(), itemSauceLabsBackpack, "Checking the product name");
        WebElement inventoryItemPrice = driver.findElement(inventoryItemPrices);
        Assert.assertEquals(inventoryItemPrice.getText(), itemPriceExpectedResult,"Checking the price of an item");







    }

}

