package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TC_0008_Add_Employee_DD extends BaseClass {

    @Test(dataProvider = "employees")
    public void addEmployeeTest(String name, String middleName, String lastName) {
        LoginPage lp = new LoginPage(driver);
        lp.getPage();
        lp.setUsername(getUserName());
        lp.setPassword(getPassword());
        lp.getLoginBTN().click();
        // login success
        AsideBar asideBar = new AsideBar(driver);
        asideBar.getPimLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");

        PimPage pimPage = new PimPage(driver);
        pimPage.getAddBTN().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");

        AddEmployeePage addPage = new AddEmployeePage(driver);
        addPage.setFirstName(name);
        addPage.setMiddleName(middleName);
        addPage.setLastName(lastName);
        addPage.getSaveBtn().click();

        Profile profile = new Profile(driver);
        profile.getProfileDropDown().click();
        profile.getLogOutLink().click();



    }

    @DataProvider(name = "employees")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Dima\\Desktop\\OrangeHRM\\src\\test\\java\\OrangeHPM\\TestData\\employees.xlsx");
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
