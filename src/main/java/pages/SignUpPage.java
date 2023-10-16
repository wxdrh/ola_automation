package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    WebDriver driver;
    WebDriverWait wait;

    @CacheLookup
    @FindBy(how = How.XPATH, using = ("(//*[contains(text(),' My account')])[2]"))
    public WebElement myAccount;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//span[normalize-space()='Register']"))
    public WebElement register;
    @CacheLookup
    @FindBy(how = How.ID, using = ("input-firstname"))
    public WebElement firstName;
    @CacheLookup
    @FindBy(how = How.ID, using = ("input-lastname"))
    public WebElement lastName;
    @CacheLookup
    @FindBy(how = How.ID, using = ("input-email"))
    public WebElement email;
    @CacheLookup
    @FindBy(how = How.ID, using = ("input-telephone"))
    public WebElement phone;
    @CacheLookup
    @FindBy(how = How.ID, using = ("input-password"))
    public WebElement password;
    @CacheLookup
    @FindBy(how = How.ID, using = ("input-confirm"))
    public WebElement confirmPassword;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//input[@id='input-agree']"))
    public WebElement agree;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//input[@type='submit']"))
    public WebElement submit;


    public SignUpPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void validateSignUp() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(myAccount));
        wait.until(ExpectedConditions.elementToBeClickable(myAccount));
        Actions action = new Actions(driver);
        action.moveToElement(myAccount).perform();
        register.click();
        firstName.sendKeys("Ola");
        lastName.sendKeys("Mab");
        email.sendKeys("olasunkanmimabi@gmail.com");
        phone.sendKeys("1234567890");
        password.sendKeys("School111111@");
        confirmPassword.sendKeys("School111111@");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", agree);
        submit.click();
        Thread.sleep(5000);
    }
}
