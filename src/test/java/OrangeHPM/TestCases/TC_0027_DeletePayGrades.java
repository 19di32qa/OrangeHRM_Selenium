package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TC_0027_DeletePayGrades extends BaseClass {

    @Test
    public void deleteGradeTest() throws IOException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getJobDropDown().click();
        adminPage.getPayGradesLink().click();

        PayGrades payGrades = new PayGrades(driver);
        String[][] grades = getGradesToDelete();
        for(int i =0;i<grades.length;i++) {
            for (int j =0;j<grades[i].length;j++) {
                deleteGrade(grades[i][j]);
            }
            SuccessMessage successMessage = new SuccessMessage(driver);
            successMessage.isMessageDisplayed();
        }
    }

    public String[][] getGradesToDelete() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OrangeHRM\\src\\test\\java\\OrangeHPM\\TestData\\GradesToDelete.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet");
        String grades[][] = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        int l =0;
        for(int i =1;i<=grades.length;i++) {
            Row row = sheet.getRow(i);
            for(int j =0;j<row.getLastCellNum();j++) {
                grades[l][j] = row.getCell(j).getStringCellValue();
            }
            l++;
        }
        return grades;
    }

    public void deleteGrade(String grade) {
        String value = "//*[text()=\""+grade+"\"]/ancestor::div[@class=\"oxd-table-row oxd-table-row--with-border\"]//i[@class=\"oxd-icon bi-trash\"]";
        ////*[text()="Grades 6"]/ancestor::div[@class="oxd-table-row oxd-table-row--with-border"]//i[@class="oxd-icon bi-trash"]
        System.out.println(value);
        By locator = By.xpath(value);
        By confirm = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(confirm)).click();

    }
}
