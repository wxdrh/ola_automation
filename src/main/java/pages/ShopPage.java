package pages;

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

public class ShopPage {
    WebDriver driver;
    WebDriverWait wait;

    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//div[@id='entry_217822']//input[@placeholder='Search For Products']"))
    public WebElement searchBar;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//button[normalize-space()='Search']"))
    public WebElement searchEnter;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//div[@class='carousel-item active']//img[@title='Sony VAIO']"))
    public WebElement searchElement;
    @CacheLookup
    @FindBy(how = How.XPATH, using = ("//i[@class='fas fa-shopping-cart']"))
    public WebElement addToCart;



    public ShopPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void validateOrder() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.sendKeys("Sony VAIO");
        searchEnter.click();
        wait.until(ExpectedConditions.visibilityOf(searchElement));
        wait.until(ExpectedConditions.elementToBeClickable(searchElement));
        Actions action = new Actions(driver);
        action.moveToElement(searchElement);
        Thread.sleep(5000);

    }
}
