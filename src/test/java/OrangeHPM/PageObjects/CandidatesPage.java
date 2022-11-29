package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CandidatesPage {

    WebDriver driver;
    public CandidatesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addBtn = By.xpath("//button[text()=\" Add \"]");
    private By name = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div/input");
    private By searchName = By.xpath("//*[@type=\"submit\"]");
    private By nameOption = By.xpath("//span[text()=\"Alexios  Greek\"]");
    private By deleteIcon = By.cssSelector(".oxd-icon.bi-trash");
    private By confirmDelete = By.xpath("//button[text()= \" Yes, Delete \"]");
    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBtn));
    }
    public WebElement getNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(name));
    }
    public WebElement getNameOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(nameOption));
    }
    public WebElement getSearchBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(searchName));
    }
    public WebElement getDeleteIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteIcon));
    }
    public WebElement getConfirmDeleteBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(confirmDelete));
    }

}
