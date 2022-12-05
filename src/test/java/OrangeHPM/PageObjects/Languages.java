package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Languages {
    WebDriver driver;
    public Languages(WebDriver driver) {
        this.driver = driver;
    }
    private By addBtn = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary");
    private By name = By.cssSelector(".oxd-form-row .oxd-input.oxd-input--active");
    private By saveBtn = By.xpath("//button[@type=\"submit\"]");

    private By ItalicLanguageToDelete = By.xpath("//*[contains(text(),\"Ita\")]/ancestor::div[@class=\"oxd-table-row oxd-table-row--with-border\"]//i[@class=\"oxd-icon bi-trash\"]");
    private By confirmDeleteBtn = By.cssSelector(".oxd-icon.bi-trash.oxd-button-icon");

    public WebElement getConfirmDeleteBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(confirmDeleteBtn));

    }
    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBtn));
    }
    public WebElement getNameInput() {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(name));
    }
    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }
    public WebElement getLanguageToDelete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(ItalicLanguageToDelete));
    }
}
