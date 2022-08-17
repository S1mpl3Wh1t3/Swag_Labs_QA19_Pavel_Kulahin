package tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTests {
    private final static String ERROR_MESSAGE_TEXT = "Epic sadface: Password is required";
    private static final String ERROR_USERNAME_MESSAGE = "Epic sadface: Username is required";
    private static final String ERROR_PASSWORD_MESSAGE = "Epic sadface: Password is required";


    @Test
    public void positiveLoginTest() {
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isProductSortContainerDisplayed(),
                "Check if the element has appeared on ProductsPage");

    }

    @Test
    public void negativeLoginTest() {
        loginPage.setUsernameInput(USERNAME);
        loginPage.setPasswordInput("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), ERROR_MESSAGE_TEXT);
    }

    @DataProvider
    public Object[][] negativeTests() {
        return new Object[][]{
                {EMPTY, PASSWORD, ERROR_USERNAME_MESSAGE},
                {USERNAME, EMPTY, ERROR_PASSWORD_MESSAGE},
                {EMPTY, EMPTY, ERROR_USERNAME_MESSAGE},
        };
    }
}