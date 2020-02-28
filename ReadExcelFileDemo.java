package TestNGPrograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileDemo {

	static Object[][] obj = null;
	
	public static void main(String [] args) throws IOException {
		
		ReadExcelFileDemo demo = new ReadExcelFileDemo() ;
		obj =demo.InputExcelFile();

		//String[][] arrStr = new String[3][4];
		for (int i = 0; i < obj.length; i++) {
			for (int j = 0; j < obj[i].length; j++) {
				System.out.print(obj[i][j] + " ");
			}
			System.out.println("");
		}		
		
		
	}

	public Object[][] InputExcelFile() throws IOException {
	System.out.println("Inside InputExcelFile");
	FileInputStream fis = new FileInputStream("C:\\Users\\sony\\Desktop\\Input.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	int rows = sheet.getLastRowNum();
	int cols = sheet.getRow(0).getLastCellNum();
	obj = new Object[rows][cols-1];
	for (int i =1; i<=rows; i++) {
		Row row = sheet.getRow(i);
		int column = row.getLastCellNum();
		for (int j = 1; j<column; j++)
		{
			Cell cell = row.getCell(j);
			//System.out.println(cell.getCellType());
			switch(cell.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				obj[i-1][j-1]="";
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				obj[i-1][j-1]=cell.getBooleanCellValue();
				break;
			case Cell.CELL_TYPE_ERROR:
				obj[i-1][j-1]="";
				break;
			case Cell.CELL_TYPE_NUMERIC:
				obj[i-1][j-1]=cell.getNumericCellValue();
				break;
			case Cell.CELL_TYPE_STRING:
				obj[i-1][j-1]=cell.getStringCellValue();
				//System.out.println("Get String cell type");
				break;
			}
		}
	}
	workbook.close();
	return obj;
	}
	}
