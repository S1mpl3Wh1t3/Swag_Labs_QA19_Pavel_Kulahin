package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class HeaderTests extends BaseTests {

    private static final String EXPECTED_TWITTER_URL = "https://twitter.com/saucelabs";

    @Test
    public void twitterLink() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickTwitterLink();
        Assert.assertEquals(productsPage.getTwitterUrl(), EXPECTED_TWITTER_URL, "Checking the link twitter");
    }
}
