package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.AdminPage;
import OrangeHPM.PageObjects.AsideBar;
import OrangeHPM.PageObjects.BaseClass;
import OrangeHPM.PageObjects.BaseLogin;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TC_0030_JobCategories extends BaseClass {

    @Test
    public void jobCategoriesAreDisplayedTest() throws IOException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getJobDropDown().click();
        adminPage.getJobCat().click();
        displayedCategories(getCategories(),driver);


    }
    public void displayedCategories(String[] categories, WebDriver driver) {
        for(int i =0;i< categories.length;i++) {
            By locator = By.xpath("//*[text()=\"" + categories[i] + "\"]/ancestor::div[@class=\"oxd-table-row oxd-table-row--with-border\"]");
            Assert.assertTrue(driver.findElement(locator).isDisplayed());
        }
    }

    public String[] getCategories() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OrangeHRM\\src\\test\\java\\OrangeHPM\\TestData\\categories.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");

        String[] categories = new String[sheet.getLastRowNum()];
        int l = 0;
        for(int i =1;i<= categories.length;i++) {
            categories[l]=sheet.getRow(i).getCell(0).getStringCellValue();
            l++;
        }
        return categories;

    }
}
