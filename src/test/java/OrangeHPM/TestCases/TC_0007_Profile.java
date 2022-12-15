package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.BaseClass;
import OrangeHPM.PageObjects.BaseLogin;
import OrangeHPM.PageObjects.LoginPage;
import OrangeHPM.PageObjects.Profile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0007_Profile extends BaseClass {

    @Test
    public void profileTest() throws InterruptedException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        Profile profile =new Profile(driver);
        profile.getProfileDropDown().click();
        profile.getAboutLink().click();
        Thread.sleep(1000);
        //Assert.assertTrue(profile.getDialogDiv().isDisplayed());
        profile.closeDialogDiv();

        profile.getProfileDropDown().click();
        profile.getSupportLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/help/support");


        profile.getProfileDropDown().click();
        profile.getChangePasswordLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/pim/updatePassword");


    }
}
