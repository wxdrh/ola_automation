import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver ;
    LoginPage loginPage;

    @BeforeTest
    public void beforeEveryMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test

    public void loginTest() throws InterruptedException {
        loginPage = new LoginPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/");
        loginPage.clickMyAccount();


    }



    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}



