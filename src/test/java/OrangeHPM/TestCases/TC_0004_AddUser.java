package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0004_AddUser extends BaseClass {

    @Test()
    public void addUserTest() throws InterruptedException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();
        // login success
        AsideBar aside = new AsideBar(driver);
        aside.getAdminLink().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        AdminPage admin = new AdminPage(driver);
        admin.getAddBtn().click();

        AddUser addUser = new AddUser(driver);
        addUser.getUserRoleInput().click();
        addUser.getOptionESS().click();
        addUser.getStatusInput().click();
        addUser.getOptionEnabled().click();

        WebElement el = addUser.getEmployeeNameInput();
        Actions actions = new Actions(driver);
        actions.moveToElement(el).click(el).sendKeys("Adalwin").build().perform();

        addUser.getOptionEmployee().click();
        addUser.getUserNameInput().sendKeys("Adelwar Test");
        addUser.getPasswordInput().sendKeys("Ad12345678!");
        addUser.getConfirmPasswordInput().sendKeys("Ad12345678!");
        Thread.sleep(2000);
        addUser.getSaveBtn().submit();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();




    }
}
