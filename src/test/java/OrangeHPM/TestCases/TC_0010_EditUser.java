package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_0010_EditUser extends BaseClass {

    @Test()
    public void editUserTest() {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();
        String name = "David";

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getPimLink().click();
        EmployeeListPage employeeListPage = new EmployeeListPage(driver);
        employeeListPage.setEmployeeName(name);
        employeeListPage.getSearchBTN().click();
        employeeListPage.getEditBtn().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber"));

        PersonalDetails personalDetails;
        personalDetails = new PersonalDetails(driver);
        String newName = "Mercy";
        personalDetails.resetFirstName(newName);
        //personalDetails.setFirstName(newName);
        //personalDetails.setMiddleName("Al");
        //personalDetails.setLastName("Johnson");
        personalDetails.getSaveBtn().click();
        // looks like there is a bug on orange hrm you can't edit there is red banner and employee isn't truly saved moreover old information is also lost but it's only for just created
        employeeListPage.getPage();
        employeeListPage.setEmployeeName(name);
        employeeListPage.getSearchBTN().click();
        Assert.assertEquals(employeeListPage.getNumberOfFound(),"No Records Found");

        employeeListPage.getPage();
        employeeListPage.setEmployeeName(newName);
        employeeListPage.getSearchBTN().click();
        Assert.assertNotEquals(employeeListPage.getNumberOfFound(),"No Records Found");
    }

    @DataProvider(name = "names")
    public Object[][] getNames() {
        return new String[][] {{"David","Mercy"},{"Mercy","David"}};
    }


}
