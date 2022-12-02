package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Time {
    WebDriver driver;
    public Time(WebDriver driver) {
        this.driver =driver;
    }
    private By projectInfo = By.xpath("//*[contains(text(),\"Project\")]");
    private By customers = By.partialLinkText("Customers");
    private By projects = By.partialLinkText("Projects");

    public WebElement getProjectInfo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(projectInfo));
    }
    public WebElement getCustomersLink() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(customers));
    }
    public WebElement getProjectsLink() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(projects));
    }

}
