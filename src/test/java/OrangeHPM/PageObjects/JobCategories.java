package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobCategories {
    WebDriver driver;
    public JobCategories(WebDriver driver) {
        this.driver = driver;
    }
    private By addBtn = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    private By name = By.xpath("//*[text()=\"Name\"]/ancestor::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input");
    private By saveBtn = By.xpath("//*[@type=\"submit\"]");
    private By deleteIcon = By.xpath("//*[text()=\"cat1\"]/ancestor::div[@class=\"oxd-table-row oxd-table-row--with-border\"]//i[@class=\"oxd-icon bi-trash\"]");
    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }
    public WebElement getNameInput() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(name));
    }
    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBtn));
    }

}
