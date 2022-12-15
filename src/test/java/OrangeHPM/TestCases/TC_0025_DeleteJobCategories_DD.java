package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class TC_0025_DeleteJobCategories_DD extends BaseClass {

    @Test
    public void deleteCategoryTest() throws IOException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getJobDropDown().click();
        adminPage.getJobCat().click();

        JobCategories jobCategories = new JobCategories(driver);
        String[][] categories = getJobCats();
        for(int i =0;i<categories.length;i++) {
            for(int j =0;j<categories[i].length;j++) {
                String value = categories[i][j];
                deleteCat(value);
            }
            SuccessMessage successMessage = new SuccessMessage(driver);
            successMessage.isMessageDisplayed();
        }
    }

    public void deleteCat(String value) {
        By confirmDeleteIcon = By.xpath("//i[@class=\"oxd-icon bi-trash oxd-button-icon\"]");
        String locator = "//*[text()=\""+value+"\"]/ancestor::div[@class=\"oxd-table-row oxd-table-row--with-border\"]//i[@class=\"oxd-icon bi-trash\"]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmDeleteIcon)).click();
    }

    public String[][] getJobCats() throws IOException {
        File file = new File( System.getProperty("user.dir")+ "/src/test/java/OrangeHPM/TestData/jobCats.xlsx");
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
