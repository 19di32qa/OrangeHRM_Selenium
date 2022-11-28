package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomFields {
    WebDriver driver;
    public CustomFields(WebDriver driver) {
        this.driver = driver;
    }
    private By addBtn = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary");
    private By saveBtn = By.xpath("//button[@type=\"submit\"]");
    private By fieldName = By.cssSelector(".oxd-input-group.oxd-input-field-bottom-space .oxd-input");
    private By inputSelects = By.cssSelector(".oxd-select-text.oxd-select-text--active");

    private By personalDetailsOption = By.xpath("//*[contains(text(),\"Personal\")]");
    private By textOrNumberOption = By.xpath("//*[contains(text(),\"Text\")]");


    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfElementLocated(addBtn));
    }
    public WebElement getFieldName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfElementLocated(fieldName));
    }
    public List<WebElement> getSelects() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(inputSelects));
    }
    public List<WebElement> getPersonalDetailsOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(personalDetailsOption));
    }

    public List<WebElement> getTextOrNumberOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(textOrNumberOption));
    }
    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }
}
