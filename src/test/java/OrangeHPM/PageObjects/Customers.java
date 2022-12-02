package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Customers {

    WebDriver driver;
    public Customers(WebDriver driver) {
        this.driver = driver;
    }
    private By addBtn = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary");
    private By name = By.cssSelector(".oxd-input-group .oxd-input.oxd-input--active");
    private By description = By.cssSelector("textarea");
    private By saveBtn = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");

    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }
    public WebElement getDescriptionInput() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(description));
    }
    public WebElement getNameInput() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(name));
    }
    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBtn));
    }
}
