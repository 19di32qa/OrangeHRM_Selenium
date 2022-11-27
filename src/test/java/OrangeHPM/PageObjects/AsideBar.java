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
    private By MyInfo = By.partialLinkText("My Info");
    private By recruitment = By.partialLinkText("Recruitment");
    private By leave = By.partialLinkText("Leave");

    public WebElement getAdminLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(admin));
    }
    public WebElement getPimLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(pim));
    }
    public WebElement getMyInfoLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(MyInfo));

    }
    public WebElement getRecruitmentLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(recruitment));
    }
    public WebElement getLeaveLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(leave));
    }
}
