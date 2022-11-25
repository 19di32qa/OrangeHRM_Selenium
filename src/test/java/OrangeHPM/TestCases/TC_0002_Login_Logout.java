package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.BaseClass;
import OrangeHPM.PageObjects.Dashboard;
import OrangeHPM.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0002_Login_Logout extends BaseClass {

    @Test
    public void logOutTest() {
        LoginPage lp = new LoginPage(driver);
        lp.getPage();
        lp.setUsername(getUserName());//getUserName is from Base class
        lp.setPassword(getPassword());
        lp.getLoginBTN().click();
        // login success
        Dashboard dashboard = new Dashboard(driver);
        Assert.assertEquals(driver.getCurrentUrl(),dashboard.url);
        dashboard.getUserDropDown().click();
        dashboard.getLogoutListElement().click();
        Assert.assertEquals(driver.getCurrentUrl(),lp.url);


    }
}
