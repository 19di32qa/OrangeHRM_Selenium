package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SaveWorkShifts {
    WebDriver driver;
    public SaveWorkShifts(WebDriver driver) {
        this.driver = driver;
    }
    private By shiftName = By.xpath("//*[text()=\"Shift Name\"]/ancestor::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input");
    private By timeFrom = By.xpath("//*[text()=\"From\"]/ancestor::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//i");
    private By timeTo = By.xpath("//*[text()=\"To\"]/ancestor::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//i");
    private By saveBtn = By.xpath("//button[@type=\"submit\"]");
    private By timeDisplayed = By.xpath("//input[@class=\"oxd-input oxd-input--active oxd-time-hour-input-text\"]");
    private By arrowUp = By.xpath("//i[@class=\"oxd-icon bi-chevron-up oxd-icon-button__icon oxd-time-hour-input-up\"]");
    private By arrowDown = By.xpath("//i[@class=\"oxd-icon bi-chevron-down oxd-icon-button__icon oxd-time-hour-input-down\"]");



    public WebElement getArrowDown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(arrowDown));
    }

    public WebElement getArrowUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(arrowUp));
    }

    public WebElement getShiftName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(shiftName));
    }
    public WebElement getTimeTo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(timeTo));
    }
    public WebElement getTimeFrom() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(timeFrom));
    }
    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }
    public String getTime() {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        String time = wait.until(ExpectedConditions.presenceOfElementLocated(timeDisplayed)).getAttribute("value");
        return time;
    }
}
