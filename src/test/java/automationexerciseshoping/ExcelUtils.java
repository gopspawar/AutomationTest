package automationexerciseshoping;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

    private Workbook workbook;

    public ExcelUtils(String excelFilePath) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);
        workbook = WorkbookFactory.create(fileInputStream);
    }

    public String getCellData(String sheetName, int rowNumber, int cellNumber) 
    {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist in the Excel file.");
        }
        Row row = sheet.getRow(rowNumber);
        if (row == null) {
            throw new IllegalArgumentException("Row " + rowNumber + " does not exist in the sheet " + sheetName + ".");
        }
        Cell cell = row.getCell(cellNumber);
        if (cell == null) {
            throw new IllegalArgumentException("Cell " + cellNumber + " does not exist in row " + rowNumber + " of sheet " + sheetName + ".");
        }
        return cell.toString();
    }
}
