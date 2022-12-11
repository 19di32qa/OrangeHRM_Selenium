package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayGrades {
    WebDriver driver;
    public PayGrades(WebDriver driver) {
        this.driver = driver;
    }
    private By addBtn = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    private By nameInput = By.xpath("//*[text()=\"Name\"]/ancestor::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input");
    private By saveBtn = By.xpath("//button[@type=\"submit\"]");
    private By selectCurrency = By.xpath("//div[@class=\"oxd-select-text-input\"]");
    private By currency = By.xpath("//*[contains(text(),\"USD\")]");
    private By minInput = By.xpath("//*[contains(text(),\"Min\")]/ancestor::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input");
    private By maxInput = By.xpath("//*[contains(text(),\"Max\")]/ancestor::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input");
    private By SaveBtnForCurrency = By.xpath("//*[text()=\"Add Currency\"]/parent::div//button[@type=\"submit\"]");

    public WebElement getSaveBtnCur() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(SaveBtnForCurrency));
    }
    public WebElement getSelectCurrency() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(selectCurrency));
    }
    public WebElement getCurrency() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(currency));
    }

    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }
    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBtn));
    }
    public WebElement getNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(nameInput));
    }
    public WebElement getMinSalInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(minInput));
    }
    public WebElement getMaxSalInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(maxInput));
    }
}
