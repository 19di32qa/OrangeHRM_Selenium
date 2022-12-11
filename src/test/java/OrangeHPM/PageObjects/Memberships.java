package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Memberships {
    WebDriver driver;
    public Memberships(WebDriver driver) {
        this.driver = driver;
    }
    private By addBtn = By.xpath("//button[@class = \"oxd-button oxd-button--medium oxd-button--secondary\"]");
    private By name = By.xpath("//*[text()=\"Name\"]/ancestor::div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input");
    private By saveBtn = By.xpath("//button[@type=\"submit\"]");
    //private By membershipToSearch = By.xpath("//*[text()=\"The US Marketing Institute\"]");

    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBtn));
    }
    public WebElement getNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(name));
    }
    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }
    public WebElement getMembershipToSearch(String membership) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String locator = "//*[text()=\""+membership+"\"]";
        System.out.println(locator);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
}
