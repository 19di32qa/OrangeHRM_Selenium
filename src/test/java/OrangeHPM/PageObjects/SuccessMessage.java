package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SuccessMessage {
    WebDriver driver;
    public SuccessMessage(WebDriver driver) {
        this.driver = driver;
    }
    private By messageLocator= By.cssSelector(".oxd-toast.oxd-toast--success.oxd-toast-container--toast");

    public void isMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(messageLocator));
        Assert.assertTrue(driver.findElement(messageLocator).isDisplayed());
    }
}
