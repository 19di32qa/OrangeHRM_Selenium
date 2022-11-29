package OrangeHPM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecruitmentPage {
    WebDriver driver;
    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
    }
    private By vacancies = By.partialLinkText("Vacancies");
    private By candidates = By.partialLinkText("Candidates");

    public WebElement getVacancies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(vacancies));
    }
    public WebElement getCandidates() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(candidates));
    }
}
