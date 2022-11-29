package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.annotations.Test;

public class TC_0018_DeleteCandidate extends BaseClass {

    @Test
    public void deleteCandidateTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getRecruitmentLink().click();

        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.getCandidates().click();

        CandidatesPage candidatesPage = new CandidatesPage(driver);
        candidatesPage.getNameInput().sendKeys("Alexios");
        candidatesPage.getNameOption().click();
        candidatesPage.getSearchBtn().click();
        candidatesPage.getDeleteIcon().click();
        candidatesPage.getConfirmDeleteBtn().click();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();

    }
}
