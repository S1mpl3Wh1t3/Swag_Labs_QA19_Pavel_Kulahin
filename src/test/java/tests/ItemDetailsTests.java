package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemDetailsPage;

public class ItemDetailsTests extends BaseTests {
    ItemDetailsPage itemDetailsPage;

    @BeforeClass
    public void initialise() {
        itemDetailsPage = new ItemDetailsPage(driver);
    }


    @Test
    public void verifyItemDescriptionOnDetailsPage() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemDescription(), ITEM_DESCRIPTION,
                "Checking the product description");
    }
}
