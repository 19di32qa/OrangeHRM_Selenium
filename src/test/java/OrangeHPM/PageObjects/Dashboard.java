package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Dashboard {
    public final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    public WebDriver driver;
    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getUserDropDown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated((By.className("oxd-userdropdown"))));
    }
    public WebElement getLogoutListElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated((By.partialLinkText("Logout"))));
    }
    public List<WebElement> getMyActions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.cssSelector(".orangehrm-todo-list .oxd-text.oxd-text--p"))));
    }
    public List<WebElement> getQuickLaunch() {
        ////button[@title="Assign Leave"]
        //.oxd-icon-button.orangehrm-quick-launch-icon
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.cssSelector(".oxd-icon-button.orangehrm-quick-launch-icon"))));
    }



}
