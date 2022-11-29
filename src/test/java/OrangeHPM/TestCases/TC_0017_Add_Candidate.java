package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.annotations.Test;

public class TC_0017_Add_Candidate extends BaseClass {

    @Test
    public void addCandidateTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getRecruitmentLink().click();

        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.getCandidates().click();

        CandidatesPage candidatesPage = new CandidatesPage(driver);
        candidatesPage.getAddBtn().click();

        AddCandidate addCandidate = new AddCandidate(driver);
        addCandidate.getFirstName().sendKeys("Alexios");
        addCandidate.getLastName().sendKeys("Greek");
        addCandidate.getEmailInput().sendKeys("alex1@example.com");
        addCandidate.getVacancySelect().click();
        addCandidate.getAdminOption().click();
        addCandidate.getSaveBtn().submit();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();





    }
}
