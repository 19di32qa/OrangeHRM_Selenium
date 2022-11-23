package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.BaseClass;
import OrangeHPM.PageObjects.LoginPage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.CancellationException;

public class TC_0003_Login_DD extends BaseClass {

    @Test(dataProvider = "UserData")
    public void loginDDT(String name, String password, String result) {
        LoginPage lp = new LoginPage(driver);
        lp.getPage();
        lp.setUsername(name);
        lp.setPassword(password);
        lp.getLoginBTN().click();
        if(result.equals("Login Failed")) {
            Assert.assertEquals(lp.getContentError().getText(),"Invalid credentials");
        }
        else if (result.equals("Login Passed")) {
            Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        }

    }


    @DataProvider(name = "UserData")
    public Object[][] testSheet() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/OrangeHPM/TestData/username&password.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rows =sheet.getLastRowNum() - sheet.getFirstRowNum();
        String obj[][] = new String[rows][sheet.getRow(0).getLastCellNum()-1];
        int l =0;
        for(int i =1;i<=rows;i++) {
            Row row = sheet.getRow(i);
            for(int j =0;j<row.getLastCellNum()-1;j++) {
                obj[l][j] =row.getCell(j).getStringCellValue();
            }
            l++;
        }

        return  obj;
    }
}
