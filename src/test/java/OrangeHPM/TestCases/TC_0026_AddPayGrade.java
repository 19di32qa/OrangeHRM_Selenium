package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.annotations.Test;

public class TC_0026_AddPayGrade extends BaseClass {

    @Test
    public void addPayGradeTest() throws InterruptedException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getJobDropDown().click();
        adminPage.getPayGradesLink().click();

        PayGrades payGrades = new PayGrades(driver);
        payGrades.getAddBtn().click();
        payGrades.getNameInput().sendKeys("Grade 7");
        payGrades.getSaveBtn().click();

//        SuccessMessage successMessage = new SuccessMessage(driver);
//        successMessage.isMessageDisplayed();
        payGrades.getAddBtn().click();
        payGrades.getSelectCurrency().click();
        payGrades.getCurrency().click();
        payGrades.getMinSalInput().sendKeys("1000");
        payGrades.getMaxSalInput().sendKeys("4000");

        payGrades.getSaveBtnCur().click();

//        successMessage.isMessageDisplayed();



    }
}
