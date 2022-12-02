package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TC_0019_AddCustomer_DD extends BaseClass {

    @Test(dataProvider = "customers")
    public void addCustomerTest(String name, String description) throws InterruptedException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getTimeLink().click();

        Time time = new Time(driver);
        time.getProjectInfo().click();
        time.getCustomersLink().click();

        Customers customers = new Customers(driver);
        customers.getAddBtn().click();
        customers.getNameInput().sendKeys(name);
        customers.getDescriptionInput().sendKeys(description);
        Thread.sleep(1000);
        customers.getSaveBtn().submit();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();

        BaseLogout baseLogout = new BaseLogout(driver);
        baseLogout.getUserDropDown().click();
        baseLogout.getLogoutLink().click();



    }

   @DataProvider(name = "customers")
    public Object[][] getCustomers() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Dima\\Desktop\\OrangeHRM\\src\\test\\java\\OrangeHPM\\TestData\\customers.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");
        String customers[][] = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        int l = 0;
        for(int i =1;i<=customers.length;i++) {
            Row row = sheet.getRow(i);
            for(int j =0;j<row.getLastCellNum();j++) {
                customers[l][j] = row.getCell(j).getStringCellValue();
            }
            l++;
        }
        return customers;
    }
}
