package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver =driver;
    }

    public void getPage() {
        driver.navigate().to(url);
    }

    public void setUsername(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username"))).sendKeys(name);
    }
    public void setPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys(password);
    }


    public WebElement getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
    }
    public WebElement getPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
    }

    public WebElement getLoginBTN() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type=\"submit\"]")));
    }
    public WebElement getContentError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oxd-alert-content--error p")));
    }
}
