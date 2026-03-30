package utils;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    static XSSFSheet sheet;

    public static void loadExcel(String path) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
    }

    public static String getData(int row, int col) {
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }
}