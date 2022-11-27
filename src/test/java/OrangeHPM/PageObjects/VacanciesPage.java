package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VacanciesPage {
    WebDriver driver;
    public VacanciesPage(WebDriver driver) {
        this.driver =driver;
    }
    private By jobTittle = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div");
    private By job = By.xpath("//*[(text()='Account Assistant')]");
    private By vacancySelect = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div");
    private By vacancy = By.xpath("//*[(text()='Account Assistant)]");

    private By addBtn = By.cssSelector(".oxd-icon.bi-plus.oxd-button-icon");
    private By vacancyName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/input");
    private By jobTitleWhenAdding = By.cssSelector(".oxd-select-text.oxd-select-text--active");
    private By hiringMangerInput = By.cssSelector("input[placeholder=\"Type for hints...\"]");
    private By saveBtn = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
    private By autoOption = By.cssSelector(".oxd-autocomplete-option");


    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addBtn));
    }

    public WebElement getVacancyName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(vacancyName));
    }
    public WebElement getJobTitleWhenAddingVacancy() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(jobTitleWhenAdding));
    }
    public void setJobTittle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(job)).click();
    }
    public void setHiringManger(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(hiringMangerInput)).sendKeys(name);
    }
    public void clickSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn)).submit();
    }
    public void selectAutoOption() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(autoOption)).click();
    }

}
