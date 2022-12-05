package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.BaseClass;
import OrangeHPM.PageObjects.BaseLogin;
import OrangeHPM.PageObjects.Dashboard;
import OrangeHPM.PageObjects.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_0006_QuickLaunchTest extends BaseClass {

    @Test
    public  void quickLaunchTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        Dashboard dashboard = new Dashboard(driver);
        List<WebElement> ls = dashboard.getQuickLaunch();

        for (WebElement el:ls) {
            String title = el.getAttribute("title");
            System.out.println(title);
            if(title.equals("Assign Leave")) {
                el.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave");
                driver.navigate().back();
            }
            if(title.equals("Leave List")) {
                el.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
                driver.navigate().back();
            }
            if(title.equals("Timesheets")) {
                el.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/time/viewEmployeeTimesheet");
                driver.navigate().back();
            }
            if(title.equals("Apply Leave")) {
                el.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
                driver.navigate().back();
            }
            if(title.equals("My Leave")) {
                el.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewMyLeaveList");
                driver.navigate().back();
            }
            if(title.equals("My Timesheet")) {
                el.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/time/viewMyTimesheet");
                driver.navigate().back();
            }

        }
    }

}
