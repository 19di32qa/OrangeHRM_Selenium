package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.annotations.Test;

public class TC_0013_LeaveApprove extends BaseClass {

    @Test
    public void leaveApproveTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getLeaveLink().click();

        LeavePage leavePage = new LeavePage(driver);
        leavePage.getApproveBtn().click();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();
    }
}
