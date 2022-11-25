package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TC_0009_DeleteEmployeeDDT extends BaseClass {
    @Test(dataProvider = "employees to delete")
    public void deleteEmployee(String name) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getPage();
        loginPage.setUsername(getUserName());
        loginPage.setPassword(getPassword());
        loginPage.getLoginBTN().click();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getPimLink().click();

        PimPage pimPage = new PimPage(driver);

        EmployeeListPage employeeListPage = new EmployeeListPage(driver);
        employeeListPage.setEmployeeName(name);
        employeeListPage.getSearchBTN().click();
        //Assert.assertFalse(employeeListPage.getNumberOfFound().equals("No Records Found"));
        Assert.assertNotEquals(employeeListPage.getNumberOfFound(),"No Records Found");
        List<WebElement> ls = employeeListPage.getDeleteIcons();
        Assert.assertTrue(ls.size()!=0);
        for (WebElement el:ls) {
            el.click();
            employeeListPage.getConfirmDeleteBtn().click();
        }
        Profile profile = new Profile(driver);
        profile.getProfileDropDown().click();
        profile.getLogOutLink().click();
    }

    @DataProvider(name = "employees to delete")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Dima\\Desktop\\OrangeHRM\\src\\test\\java\\OrangeHPM\\TestData\\employeeToDelete.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("sheet1");
        int rows = sheet.getLastRowNum();

        String[][] employees = new String[rows][sheet.getRow(0).getLastCellNum()];
        int l = 0;
        for (int i = 1; i <= rows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                employees[l][j] = row.getCell(j).getStringCellValue();
            }
            l++;
        }
        return employees;

    }

}
