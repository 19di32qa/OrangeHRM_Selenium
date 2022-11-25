package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.AdminPage;
import OrangeHPM.PageObjects.AsideBar;
import OrangeHPM.PageObjects.BaseClass;
import OrangeHPM.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0004_AddUser extends BaseClass {

    @Test(enabled = false)
    public void addUserTest() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.getPage();
        lp.setUsername(getUserName());
        lp.setPassword(getPassword());
        lp.getLoginBTN().click();
        // login success
        AsideBar aside = new AsideBar(driver);
        aside.getAdminLink().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        AdminPage admin = new AdminPage(driver);
        admin.getAddBtn().click();
        admin.getElement(admin.userRole).click();
        admin.getElement(admin.optionESS).click();
        admin.getElement(admin.status).click();
        admin.getElement(admin.optionEnabled).click();
        admin.getElement(admin.employeeName).sendKeys("Odis");

        admin.getElement(admin.employee).click();
        admin.getElement(admin.userName).sendKeys("GodTesting");
        admin.getElement(admin.password).sendKeys("Ad12345678!");
        admin.getElement(admin.confirmPassword).sendKeys("Ad12345678!");
        Thread.sleep(1000);

        admin.getElement(admin.saveBtn).submit();






    }
}
