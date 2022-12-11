package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.annotations.Test;

public class TC_0029_DeleteShift extends BaseClass {

    @Test
    public void deleteShift() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getJobDropDown().click();
        adminPage.getWorkShifts().click();

        WorkShifts workShifts = new WorkShifts(driver);
        workShifts.getDeleteIcon().click();

        ConfirmDeleteMenu confirmDeleteMenu = new ConfirmDeleteMenu(driver);
        confirmDeleteMenu.getYesBtn().click();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();

    }
}
