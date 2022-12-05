package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.annotations.Test;

public class TC_0021_AddLanguage extends BaseClass {

    @Test
    public void addLanguageTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getQualificationDropDown().click();
        adminPage.getLanguagesLink().click();

        Languages languages = new Languages(driver);
        languages.getAddBtn().click();
        languages.getNameInput().sendKeys("Italic venice");
        languages.getSaveBtn().click();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();


    }
}
