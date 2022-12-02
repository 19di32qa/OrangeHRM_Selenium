package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Projects {
    WebDriver driver;
    public Projects(WebDriver driver) {
        this.driver = driver;
    }
    private By addBtn = By.cssSelector(".orangehrm-header-container .oxd-button.oxd-button--medium.oxd-button--secondary");
    private By nameInput = By.cssSelector(".oxd-input-group .oxd-input.oxd-input--active");
    private By customerInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div/input");
    private By customer = By.xpath("//*[text()=\"Internal\"]");
    private By saveBtn = By.xpath("//*[@type=\"submit\"]");
    private By desc = By.cssSelector("textarea");
    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBtn));
    }
    public WebElement getDescInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(desc));
    }
    public WebElement getNameInput() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(nameInput));
    }
    public WebElement getCustomerInput() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(customerInput));
    }
    public WebElement getCustomerOption() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(customer));
    }
    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }

}
