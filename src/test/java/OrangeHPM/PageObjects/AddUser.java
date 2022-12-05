package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddUser {
    WebDriver driver;
    public AddUser(WebDriver driver) {
        this.driver = driver;
    }
    private By userRole = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
    private By status = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div");
    private By employeeName = By.xpath("//input[@placeholder=\"Type for hints...\"]");
    private By userName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");

    private By password = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private By confirmPassword = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    private By saveBtn = By.xpath("//*[@type=\"submit\"]");
    private By optionESS = By.xpath("//*[text()=\"ESS\"]");
    private By optionEnabled = By.xpath("//*[text()=\"Enabled\"]");
    private By employee = By.xpath("//*[contains(text(),\"Odis\")]");

    public WebElement getUserRoleInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(userRole));
    }
    public WebElement getUserNameInput() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(userName));
    }
    public WebElement getStatusInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(status));
    }
    public WebElement getEmployeeNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(employeeName));

    }
    public WebElement getPasswordInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(password));
    }
    public WebElement getConfirmPasswordInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(confirmPassword));
    }
    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }
    public WebElement getOptionESS() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(optionESS));
    }
    public WebElement getOptionEnabled() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(optionEnabled));
    }
    public WebElement getOptionEmployee() {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(employee));
    }


}
