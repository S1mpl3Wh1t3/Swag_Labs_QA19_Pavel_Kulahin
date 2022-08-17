import org.openqa.selenium.By;

public class Locators {

    public class CheckboxesTest {

        By idLocator = By.id("login-button");
        By nameLocator = By.name("login-button");
        By classNameLocator = By.className("bot_column");
        By tagNameLocator = By.tagName("form");
        By linkTextLocator = By.linkText("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        By partialLinkTextLocator = By.partialLinkText("carry.allTheThings() with the sleek, streamlined Sly Pack that melds");
        By xpathAttributeLocator = By.xpath("//button[@data-test='back-to-products']");
        By xpathLocatorText = By.xpath("//div[text()='Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.']");
        By xpathPartialAttributeMatchLocator = By.xpath("//select[contains(@data-test,'product_sort')]");
        By xpathPartialTextMatchLocator = By.xpath("//div[contains(text(),'des')]");
        By xpathAndLocator = By.xpath("//button[@class='btn btn_secondary btn_small cart_button' and @data-test='remove-sauce-labs-backpack']");
        By xpathAncestorLocator = By.xpath("//button[@id='remove-sauce-labs-bike-light']//ancestor::div");
        By xpathDescendant = By.xpath("//div[@class='bm-burger-button']//descendant::button");
        By xpathFollowingSibling = By.xpath("//li[@class='social_facebook']//following-sibling::li");
        By xpathParent = By.xpath("//option[@value='az']//parent::select");
        By xpathPrecedingSiblingLocator = By.xpath("//img[@class='bm-icon']//preceding-sibling::button");
        By cssClassLocator = By.cssSelector(".product_sort_container");
        By cssClass1Locator = By.cssSelector(".submit-button.btn_action");
        By cssClass2Locator = By.cssSelector(".login-box .submit-button ");
        By cssIdLocator = By.cssSelector("#login-button");
        By cssTagNameLocator = By.cssSelector("footer");
        By cssTagNameClassLocator = By.cssSelector("select.product_sort_container");
        By cssAttributeValueLocator = By.cssSelector("[data-test='product_sort_container']");
        By cssAttributeValue1Locator = By.cssSelector("[rel~='noreferrer']");
        By cssAttributeValue2Locator = By.cssSelector("[name|='add']");
        By cssAttributeValue3Locator = By.cssSelector("a[href^='https']");
        By cssAttributeValue4Locator = By.cssSelector("button[name$='backpack']");
        By cssAttributeValue5Locator = By.cssSelector("a[href*='twitter']");
    }
}
