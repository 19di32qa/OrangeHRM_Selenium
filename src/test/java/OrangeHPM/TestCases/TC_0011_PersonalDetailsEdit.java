package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_0011_PersonalDetailsEdit extends BaseClass {
    @Test
    public void personalEditTest() throws InterruptedException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getMyInfoLink().click();

        PersonalDetails personalDetails = new PersonalDetails(driver);
        resetField(personalDetails.getFirstName());
        resetField(personalDetails.getMiddleName());
        resetField(personalDetails.getLastName());


        personalDetails.setFirstName("Alex");
        personalDetails.setMiddleName("Di");
        personalDetails.setLastName("Colder");

        personalDetails.getSaveBtn().click();

        Assert.assertTrue(personalDetails.getBanner().isDisplayed());
        isInputFieldUpdated(personalDetails.getFirstName(),"Alex");
        isInputFieldUpdated(personalDetails.getMiddleName(),"Di");
        isInputFieldUpdated(personalDetails.getLastName(),"Colder");

    }

    public void resetField(WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).doubleClick().sendKeys(Keys.DELETE).build().perform();
        //Thread.sleep(1000);
    }
    public void isInputFieldUpdated(WebElement element, String name) {
        Assert.assertEquals(element.getAttribute("value"),name);
    }

}
