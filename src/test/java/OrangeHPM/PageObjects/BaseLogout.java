package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseLogout {
    WebDriver driver;
    public BaseLogout(WebDriver driver) {
        this.driver = driver;
    }
    private By profile = By.cssSelector(".oxd-userdropdown-name");
    private By logoutLink = By.partialLinkText("Logout");

    public WebElement getUserDropDown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(profile));
    }
    public WebElement getLogoutLink() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(logoutLink));
    }

}
