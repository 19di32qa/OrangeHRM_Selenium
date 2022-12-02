package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class TC_0020_AddProject_DD extends BaseClass {

    @Test(dataProvider = "projects")
    public void addProjectTest(String name, String desc) throws InterruptedException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getTimeLink().click();

        Time time = new Time(driver);
        time.getProjectInfo().click();
        time.getProjectsLink().click();

        Projects projects = new Projects(driver);
        projects.getAddBtn().click();
        projects.getNameInput().sendKeys(name);
        projects.getDescInput().sendKeys(desc);
        projects.getCustomerInput().sendKeys("Internal");
        projects.getCustomerOption().click();
        Thread.sleep(1000);
        projects.getSaveBtn().submit();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();

        BaseLogout baseLogout = new BaseLogout(driver);
        baseLogout.getUserDropDown().click();
        baseLogout.getLogoutLink().click();

    }

    @DataProvider(name = "projects")
    public Object[][] getCustomers() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Dima\\Desktop\\OrangeHRM\\src\\test\\java\\OrangeHPM\\TestData\\projects.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");
        String projects[][] = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        int l = 0;
        for(int i =1;i<=projects.length;i++) {
            Row row = sheet.getRow(i);
            for(int j =0;j<row.getLastCellNum();j++) {
                projects[l][j] = row.getCell(j).getStringCellValue();
            }
            l++;
        }
        return projects;
    }
}
