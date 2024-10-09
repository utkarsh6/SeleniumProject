package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private String path;
    private FileInputStream fi;
    private FileOutputStream fo;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    public ExcelUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;
    }

    public int getCellCount(String sheetName, int rowNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellCount;
    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        DataFormatter formatter = new DataFormatter();
        String data = formatter.formatCellValue(cell);
        workbook.close();
        fi.close();
        return data;
    }

    public List<String[]> getSpecificColumns(String sheetName, String[] columnNames) throws IOException {
        List<String[]> data = new ArrayList<>();
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        // Find the column indices for the specified column names
        row = sheet.getRow(0);
        int[] colIndices = new int[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            for (int j = 0; j < row.getLastCellNum(); j++) {
                if (row.getCell(j).getStringCellValue().equalsIgnoreCase(columnNames[i])) {
                    colIndices[i] = j;
                    break;
                }
            }
        }

        for (int i = 1; i <= getRowCount(sheetName); i++) {
            row = sheet.getRow(i);
            String[] rowData = new String[columnNames.length];
            for (int j = 0; j < columnNames.length; j++) {
                rowData[j] = getCellData(sheetName, i, colIndices[j]);
            }
            data.add(rowData);
        }

        workbook.close();
        fi.close();
        return data;
    }
}

