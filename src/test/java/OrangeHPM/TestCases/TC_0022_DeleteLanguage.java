package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.annotations.Test;

public class TC_0022_DeleteLanguage extends BaseClass {

    @Test
    public void deleteLangTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getQualificationDropDown().click();
        adminPage.getLanguagesLink().click();

        Languages languages = new Languages(driver);
        languages.getLanguageToDelete().click();
        languages.getConfirmDeleteBtn().click();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();
    }
}
