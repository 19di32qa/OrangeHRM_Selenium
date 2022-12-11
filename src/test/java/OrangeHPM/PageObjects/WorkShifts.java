package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WorkShifts {
    WebDriver driver;
    public WorkShifts(WebDriver driver) {
        this.driver = driver;
    }
    private By addBtn = By.xpath("//button[@class =\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    private By DeleteIcon = By.xpath("//*[text()=\"Second Shift\"]/ancestor::div[@class=\"oxd-table-row oxd-table-row--with-border\"]//i[@class=\"oxd-icon bi-trash\"]");

    public WebElement getDeleteIcon() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(DeleteIcon));
    }

    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBtn));
    }
}
