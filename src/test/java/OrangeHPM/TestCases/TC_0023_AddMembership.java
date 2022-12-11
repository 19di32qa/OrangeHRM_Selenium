package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_0023_AddMembership extends BaseClass {

    @Test
    public void addMembershipTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getQualificationDropDown().click();
        adminPage.getMembershipsLink().click();

        Memberships memberships = new Memberships(driver);
        memberships.getAddBtn().click();
        memberships.getNameInput().sendKeys("The US Marketing Institute");
        memberships.getSaveBtn().submit();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();

        BaseLogout baseLogout = new BaseLogout(driver);
        baseLogout.getUserDropDown().click();
        baseLogout.getLogoutLink().click();

    }

    @Test
    public void searchMembershipTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getQualificationDropDown().click();
        adminPage.getMembershipsLink().click();

        Memberships memberships = new Memberships(driver);
        Assert.assertTrue(memberships.getMembershipToSearch("The US Marketing Institute").isDisplayed());
    }
}
