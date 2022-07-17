package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTests extends BaseTests{
    final static String PRODUCT_NAME = "Sauce Labs Fleece Jacket";

    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;
    HomePage homePage;

    @BeforeClass
    public void initialise() {

        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        homePage = new HomePage(driver);
    }
    @Test
    public void positiveCheckoutTests() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        homePage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.continueCheckout("Pavel", "Kulahin", "32412");
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isBackHomeButtonDisplayed(),
                "Checking the appearance of the 'BACKHOME' button");
        Assert.assertEquals(checkoutCompletePage.getCheckoutComplete(), "CHECKOUT: COMPLETE!",
                "Checking for a Success Message");
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isProductSortContainerDisplayed(),
                "Checking what brought us to 'ProductsPage'");
    }

}