package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.ProductsPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected final String USERNAME = "standard_user";
    protected final String PASSWORD = "secret_sauce";
    protected String FIRST_NAME = "First";
    protected String LAST_NAME = "Last";
    protected String ZIP_POSTAL_CODE = "12345";
    protected String EMPTY = "";
    protected String PRODUCT_NAME = "Sauce Labs Bolt T-Shirt";
    protected String ITEM_DESCRIPTION = "Get your testing superhero on with the Sauce Labs bolt T-shirt. " +
            "From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @BeforeMethod
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}