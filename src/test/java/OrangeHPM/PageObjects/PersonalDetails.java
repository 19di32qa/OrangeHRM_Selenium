package OrangeHPM.PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalDetails extends BaseClass{
    WebDriver driver;
    public PersonalDetails(WebDriver driver) {
        this.driver = driver;
    }
    private final By firstName =By.name("firstName");
    private final By middleName = By.name("middleName");
    private final By lastName = By.name("lastName");
    private final By SaveBTN = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
    private final By banner = By.cssSelector(".oxd-toast.oxd-toast--success.oxd-toast-container--toast");

    public WebElement getMiddleName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(middleName));
    }
    public WebElement getLastName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(lastName));
    }
    public WebElement getFirstName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
    }
    public WebElement getBanner() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(banner));
    }


    public void setFirstName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName)).sendKeys(name);
    }
    public void resetFirstName(String edit) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(firstName)).getAttribute("value"));
        Actions actions = new Actions(driver);
        WebElement el =wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        actions.moveToElement(el).doubleClick().sendKeys(Keys.DELETE).sendKeys(edit).build().perform();



    }
    public void setMiddleName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(middleName)).sendKeys(name);
    }
    public void setLastName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(lastName)).sendKeys(name);
    }
    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(SaveBTN));
    }

}
