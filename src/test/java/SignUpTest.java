import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SignUpPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpTest {
    WebDriver driver;
    SignUpPage  signUpPage;

    @BeforeTest
    public void beforeEveryMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void signUpTest() throws InterruptedException {
        signUpPage = new SignUpPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/");
        signUpPage.validateSignUp();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
