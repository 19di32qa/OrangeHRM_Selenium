package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Profile {
    WebDriver driver;
    public Profile(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getProfileDropDown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul[data-v-1c40f28d] li")));
    }
    public WebElement getAboutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("About")));
    }
    public WebElement getSupportLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Support")));
    }
    public WebElement getChangePasswordLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Change Password")));
    }
    public WebElement getDialogDiv() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oxd-dialog-container-default--inner")));
    }
    public WebElement getLogOutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Logout")));
    }
    public void closeDialogDiv() {
        driver.findElement(By.cssSelector(".oxd-dialog-close-button.oxd-dialog-close-button-position")).click();
    }

}
