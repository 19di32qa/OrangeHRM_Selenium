package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AsideBar {

    WebDriver driver;
    public AsideBar(WebDriver driver) {
        this.driver = driver;
    }
    private By admin = By.partialLinkText("Admin");
    private By pim = By.partialLinkText("PIM");

    public WebElement getAdminLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(admin));
    }
    public WebElement getPimLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(pim));
    }
}
