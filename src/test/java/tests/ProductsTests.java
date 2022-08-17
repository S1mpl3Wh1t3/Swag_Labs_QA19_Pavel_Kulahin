package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTests {
    final static String PRODUCT_NAME = "Sauce Labs Backpack";

    @Test
    public void verifyItemPriceOnProductsPage() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductPrice(PRODUCT_NAME), "$29.99",
                "Checking the price of a product");

    }

    @Test
    public void verifyItemNameOnProductsPage() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductName(PRODUCT_NAME), PRODUCT_NAME,
                "Checking the product name");

    }

    @Test
    public void verifyItemDescriptionOnProductsPage() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductDescription(PRODUCT_NAME),
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                "Checking the product description");

    }
}