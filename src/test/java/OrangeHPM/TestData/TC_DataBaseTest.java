package OrangeHPM.TestData;

import OrangeHPM.Utilities.DataBase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TC_DataBaseTest {

    @Test
    public void getCustomers() throws IOException, SQLException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OrangeHRM\\src\\test\\java\\OrangeHPM\\TestData\\customersDatabase.xlsx");
        FileOutputStream fos = new FileOutputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet");
        ArrayList<String> arr = getCustomersFromDataBase();
        createHeader(sheet);
        createTable(sheet, arr);
        workbook.write(fos);
        fos.close();
        fos.flush();
    }
    public void createTable(Sheet sheet, ArrayList<String> arr) {
        for(int i =0;i<arr.size();i++) {
            Row row = sheet.createRow(i+1);
            Cell cell = row.createCell(0);
            cell.setCellValue(arr.get(i));
        }
    }
    public void createHeader(Sheet sheet) {
        String header[] = {"Name"};
        Row row = sheet.createRow(0);
        for(int i =0;i<header.length;i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(header[i]);
        }
    }


    public ArrayList<String> getCustomersFromDataBase() throws SQLException, FileNotFoundException {
        DataBase dataBase = new DataBase("//localhost:3306/classicmodels","Admin","12345678");
        dataBase.setConnection();
        ResultSet res = dataBase.executeStatement("select * from customers");
        ArrayList<String> arr = new ArrayList<>();
        while (res.next()) {
            arr.add(res.getString("customerName"));
        }
        return arr;
    }

}
