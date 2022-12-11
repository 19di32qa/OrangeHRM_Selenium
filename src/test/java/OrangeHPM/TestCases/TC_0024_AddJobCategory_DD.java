package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TC_0024_AddJobCategory_DD extends BaseClass {

    @Test
    public void addJobCategoryTest() throws IOException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getJobDropDown().click();
        adminPage.getJobCat().click();

        String[][] categories = getJobCats();
        for(int i =0;i<categories.length;i++) {
            for(int j =0;j<categories[i].length;j++) {
                JobCategories jobCategories = new JobCategories(driver);
                jobCategories.getAddBtn().click();
                jobCategories.getNameInput().sendKeys(categories[i][j]);
                jobCategories.getSaveBtn().click();
            }
            SuccessMessage successMessage = new SuccessMessage(driver);
            successMessage.isMessageDisplayed();
        }
    }

    public String[][] getJobCats() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OrangeHRM\\src\\test\\java\\OrangeHPM\\TestData\\jobCats.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");
        String[][] cats = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        int l = 0;
        for(int i =1;i<=cats.length;i++) {
            Row row = sheet.getRow(i);
            for(int j =0;j<row.getLastCellNum();j++) {
                System.out.println(row.getCell(j).getStringCellValue());
                cats[l][j] = row.getCell(j).getStringCellValue();
            }
            l++;
        }
        return cats;
    }
}
