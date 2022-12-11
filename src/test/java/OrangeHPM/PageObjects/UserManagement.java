package OrangeHPM.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserManagement {
    WebDriver driver;
    public UserManagement(WebDriver driver) {
        this.driver = driver;
    }
    private By userName = By.xpath("//*[text()=\"Username\"]/ancestor::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input");
    private By employeeName = By.xpath("//*[text()=\"Employee Name\"]/ancestor::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input");
    private By searchBtn = By.xpath("//*[@type=\"submit\"]");

    private By userToDelete = By.xpath("//*[contains(text(),\"Adelwar\")]/ancestor::div[@class=\"oxd-table-row oxd-table-row--with-border\"]//i[@class=\"oxd-icon bi-trash\"]");
    private By confirmDeleteBtn = By.xpath("//i[@class=\"oxd-icon bi-trash oxd-button-icon\"]");

    public WebElement getConfirmDeleteBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(confirmDeleteBtn));
    }

    public WebElement getSearchBtn() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(searchBtn));
    }
    public WebElement getUserNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(userName));
    }
    public WebElement getEmployeeNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(employeeName));
    }
    public WebElement getEmployeeToDeleteByName() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(userToDelete));
    }
}
