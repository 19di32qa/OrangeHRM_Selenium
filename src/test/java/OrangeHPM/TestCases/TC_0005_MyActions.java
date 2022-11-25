package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.BaseClass;
import OrangeHPM.PageObjects.Dashboard;
import OrangeHPM.PageObjects.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_0005_MyActions extends BaseClass {

    @Test
    public void myActionsDashboardTest() {
        LoginPage lp = new LoginPage(driver);
        lp.getPage();
        lp.setUsername(getUserName());//getUserName is from Base class
        lp.setPassword(getPassword());
        lp.getLoginBTN().click();
        // login success

        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        Dashboard dashboard = new Dashboard(driver);
        List<WebElement> ls = dashboard.getMyActions();
        for (WebElement el:ls) {
            String text = el.getText();
            if(text.contains("Leave Requests to Approve")) {
                el.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
                driver.navigate().back();
            }
            else if(text.contains("Pending Self Review")){
                el.click();
                Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/performance/myPerformanceReview");
                driver.navigate().back();
            }
//            else if(text.contains("Candidate to Interview")) { there are unexpected errors on recruitment page
//                el.click();
//                Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates?statusId=4");
//            }

        }


    }
}
