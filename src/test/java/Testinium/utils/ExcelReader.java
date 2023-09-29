package Testinium.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.nio.file.Paths;

public class ExcelReader {
    public String cellValue(int rowNum, int cellNum) {
        try {
            String excelLocation = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "products.xlsx").toString();
            Workbook workbook = new XSSFWorkbook(excelLocation);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(cellNum);
            String value = cell.getStringCellValue();
            return value;
        } catch (Exception e) {
            return e.toString();
        }
    }
}
