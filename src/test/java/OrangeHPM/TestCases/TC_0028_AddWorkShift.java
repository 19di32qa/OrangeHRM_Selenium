package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TC_0028_AddWorkShift extends BaseClass {
    @Test(dataProvider = "shifts")
    public void addShiftTest(String name,int timeFrom, int timeTo) throws IOException {
        BaseLogin baseLogin = new BaseLogin(driver);
        baseLogin.login();

        AsideBar asideBar = new AsideBar(driver);
        asideBar.getAdminLink().click();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.getJobDropDown().click();
        adminPage.getWorkShifts().click();

        WorkShifts workShifts = new WorkShifts(driver);
        workShifts.getAddBtn().click();

        SaveWorkShifts saveWorkShifts = new SaveWorkShifts(driver);
        saveWorkShifts.getShiftName().sendKeys((String) name);
        setTimeFrom((Integer) timeFrom);
        setTimeTo((Integer) timeTo);
        saveWorkShifts.getSaveBtn().click();

        SuccessMessage successMessage = new SuccessMessage(driver);
        successMessage.isMessageDisplayed();

        BaseLogout baseLogout = new BaseLogout(driver);
        baseLogout.getUserDropDown().click();
        baseLogout.getLogoutLink().click();


    }



    @DataProvider(name = "shifts")
    public Object[][] getData() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OrangeHRM\\src\\test\\java\\OrangeHPM\\TestData\\workShifts.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");
        Object[][] shifts = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        int l=0;
        for (int i =1;i<=sheet.getLastRowNum();i++) {
            Row row = sheet.getRow(i);
            for(int j =0;j<row.getLastCellNum();j++) {
                Cell cell = row.getCell(j);
                Object value;
                if(cell.getCellType() == CellType.STRING) {
                    value = cell.getStringCellValue();
                }
                else {
                    int number = (int) Math.round(cell.getNumericCellValue());
                    value = number;
                }
                shifts[l][j] = value;
            }
            l++;
        }
        return shifts;
    }

    public void setTimeTo(int timeTo) {
        SaveWorkShifts saveWorkShifts = new SaveWorkShifts(driver);
        saveWorkShifts.getTimeTo().click();
        String time = saveWorkShifts.getTime();

        int t = Integer.parseInt(time.substring(1));
        while(t!=timeTo) {
            if(t>timeTo) {
                saveWorkShifts.getArrowDown().click();
            }
            else if(t<timeTo){
                saveWorkShifts.getArrowUp().click();
            }
            time = saveWorkShifts.getTime();
            t = Integer.parseInt(time.substring(1));
        }
    }
    public void setTimeFrom(int timeFrom) {
        SaveWorkShifts saveWorkShifts = new SaveWorkShifts(driver);
        saveWorkShifts.getTimeFrom().click();
        String time = saveWorkShifts.getTime();

        int t = Integer.parseInt(time.substring(1));
        while(t!=timeFrom) {
            if(t>timeFrom) {
                saveWorkShifts.getArrowDown().click();
            }
            else if(t<timeFrom){
                saveWorkShifts.getArrowUp().click();
            }

            time = saveWorkShifts.getTime();
            if(time.equals("10")||time.equals("11")||time.equals("12")) {
                t = Integer.parseInt(time);
            }
            else {
                t = Integer.parseInt(time.substring(1));
            }
        }
    }

}
