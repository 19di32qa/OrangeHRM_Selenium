package OrangeHPM.PageObjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {

    WebDriver driver;
    public AdminPage(WebDriver driver) {
        this.driver =driver;
    }

    private By organizationDropDown = By.xpath("//span[contains(text(),\"Organization\")]");
    private By locationsLink = By.partialLinkText("Locations");

    private By addBTN = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    private By qualificationsDropDown = By.xpath("//*[contains(text(),\"Qualif\")]");
    private By Languages = By.xpath("//*[contains(text(),\"Lang\")]");


    public WebElement getOrganizationDropDown() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(organizationDropDown));
    }
    public WebElement getLocationsLink() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locationsLink));
    }
    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBTN));
    }
    public WebElement getQualificationDropDown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(qualificationsDropDown));
    }
    public WebElement getLanguagesLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(Languages));
    }

    public void searchByUserName(String str) {
        String locator = ".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
    }

}
