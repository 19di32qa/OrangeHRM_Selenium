package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.annotations.Test;

public class TC_0014_LeaveReject extends BaseClass {
    @Test
    public void rejectTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getLeaveLink().click();

        LeavePage leavePage = new LeavePage(driver);
        leavePage.getRejectBtn().click();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();
    }
}
