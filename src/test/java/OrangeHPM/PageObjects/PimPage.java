package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PimPage {
    WebDriver driver;
    public PimPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By addBTN = By.cssSelector(".orangehrm-paper-container .oxd-button");

    public WebElement getAddBTN() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBTN));
    }
}
