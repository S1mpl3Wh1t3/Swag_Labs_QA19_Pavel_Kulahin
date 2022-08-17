package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTests extends BaseTests {

    final static String PRODUCT_NAME = "Sauce Labs Fleece Jacket";
    private final static String CHECKOUT_COMPLETE = "CHECKOUT: COMPLETE!";
    private final static String ERROR_FIRST_NAME = "Error: First Name is required";
    private final static String ERROR_LAST_NAME = "Error: Last Name is required";
    private final static String ERROR_ZIP_POSTAL_CODE = "Error: Postal Code is required";

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
        Assert.assertEquals(checkoutCompletePage.getCheckoutComplete(), CHECKOUT_COMPLETE,
                "Checking for a Success Message");
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isProductSortContainerDisplayed(),
                "Checking what brought us to 'ProductsPage'");
    }


    @Test
    public void negativeCheckoutTests(String firstName, String lastName, String zipPostalCode, String errorMessage) {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        productsPage.clickShoppingCartButton();
        cartPage.clickCheckoutButton();
        checkoutPage.setFirstNameInput(firstName);
        checkoutPage.setLastNameInput(lastName);
        checkoutPage.setZipPostalCodeInput(zipPostalCode);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed(),
                "Checking for an error message");
        Assert.assertEquals(checkoutPage.getErrorMessageText(), errorMessage,
                "We check the appearance of an error message about an incorrect First Name entry");


    }

    @DataProvider
    public Object[][] negativeCheckoutTest() {
        return new Object[][]{
                {EMPTY, LAST_NAME, ZIP_POSTAL_CODE, ERROR_FIRST_NAME},
                {FIRST_NAME, EMPTY, ZIP_POSTAL_CODE, ERROR_LAST_NAME},
                {FIRST_NAME, LAST_NAME, EMPTY, ERROR_ZIP_POSTAL_CODE},
        };

    }

}