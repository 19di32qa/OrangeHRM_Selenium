package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private static final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver =driver;
    }
    public void getPage() {
        driver.navigate().to(url);
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
}
