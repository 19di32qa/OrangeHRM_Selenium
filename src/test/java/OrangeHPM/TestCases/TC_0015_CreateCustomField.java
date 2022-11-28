package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TC_0015_CreateCustomField extends BaseClass {

    @Test
    public void customFieldTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getPimLink().click();

        PimPage pimPage = new PimPage(driver);
        pimPage.getConfigurationDropdown().click();
        pimPage.getCustomFieldsLink().click();

        CustomFields customFields = new CustomFields(driver);
        customFields.getAddBtn().click();
        customFields.getFieldName().sendKeys("test field1");
        List<WebElement> ls = customFields.getSelects();
        boolean selectCheck = true;
        for(int i =0;i<ls.size();i++) {
            ls.get(i).click();
            List<WebElement> personalDetailsLs = customFields.getPersonalDetailsOption();
            if(personalDetailsLs.size()>0 && selectCheck) {
                personalDetailsLs.get(0).click();
                selectCheck = false;
            }
            else{
                customFields.getTextOrNumberOption().get(0).click();
            }
        }
        customFields.getSaveBtn().click();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();


    }
}
