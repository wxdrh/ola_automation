import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ShopPage;

public class ShopTest {
    WebDriver driver;
    ShopPage shopPage;

    @BeforeTest
    public void beforeEveryMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void shopTest() throws InterruptedException {
        shopPage = new ShopPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/");
        shopPage.validateOrder();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
