package tests;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTests {




    @Test
    public void positiveLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isProductSortContainerDisplayed(),
                "Check if the element has appeared on ProductsPage");

    }
}