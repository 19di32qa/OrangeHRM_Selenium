package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.annotations.Test;

public class TC_0016_AddLocation extends BaseClass {

    @Test
    public void addLocationTest() throws InterruptedException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getOrganizationDropDown().click();
        adminPage.getLocationsLink().click();

        Locations locations = new Locations(driver);
        locations.getAddBtn().click();
        locations.getInputName().sendKeys("LS Office");
        Thread.sleep(1000);
        locations.getCityInput().sendKeys("Los Angeles");
        locations.getCountrySelect().click();
        locations.getCountrySelect().sendKeys("u");
        locations.getUnitedStatesOption().click();
        locations.getSaveBtn().submit();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();


    }
}
