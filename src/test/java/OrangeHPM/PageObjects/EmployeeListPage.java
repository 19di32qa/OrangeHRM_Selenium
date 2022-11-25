package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EmployeeListPage {
    WebDriver driver;
    private final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.get(url);
    }
    private final By employeeName = By.cssSelector(".oxd-autocomplete-wrapper input:first-of-type");
    private final By searchButton = By.cssSelector("button[type=\"submit\"]");
    private final By numberOfFound = By.cssSelector(".orangehrm-horizontal-padding.orangehrm-vertical-padding span");
    private final By deleteIcon = By.cssSelector(".oxd-icon.bi-trash");
    private final By confirmDeleteBtn = By.cssSelector(".oxd-icon.bi-trash.oxd-button-icon");
    private final By editBtn = By.cssSelector(".oxd-icon.bi-pencil-fill");


    public void setEmployeeName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(employeeName)).sendKeys(name);
    }
    public WebElement getSearchBTN() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(searchButton));
    }
    public String getNumberOfFound() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(numberOfFound)).getText();
    }
    public List<WebElement> getDeleteIcons() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(deleteIcon));
    }
    public WebElement getConfirmDeleteBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(confirmDeleteBtn));
    }
    public WebElement getEditBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(editBtn));
    }



}
