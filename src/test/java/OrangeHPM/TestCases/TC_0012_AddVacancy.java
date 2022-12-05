package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.annotations.Test;

public class TC_0012_AddVacancy extends BaseClass {

    @Test
    public void addVacancyTest() throws InterruptedException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getRecruitmentLink().click();

        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.getVacancies().click();

        VacanciesPage vacanciesPage = new VacanciesPage(driver);
        vacanciesPage.getAddBtn().click();
        vacanciesPage.getVacancyName().sendKeys("Test-Admin");
        vacanciesPage.getJobTitleWhenAddingVacancy().click();
        vacanciesPage.setJobTittle();
        vacanciesPage.setHiringManger("Odis");
        Thread.sleep(1000);
        vacanciesPage.selectAutoOption();
        vacanciesPage.clickSaveBtn();


    }
}
