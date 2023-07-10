package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataComparison {
	
	public static void main(String[] args) throws IOException {
			
		String excelPath1= "C:\\Users\\HOME\\eclipse-workspace\\newworkspace\\CucumberAssessment\\Data\\Instrument_table.xlsx";
		String excelPath2= "C:\\Users\\HOME\\eclipse-workspace\\newworkspace\\CucumberAssessment\\Data\\position_details.xlsx";
		
		File f1 = new File(excelPath1);
		FileInputStream fis1 = new FileInputStream(f1);
		
		
		
		try (XSSFWorkbook excelWorkbook = new XSSFWorkbook(fis1)) {
			XSSFSheet excelSheet = excelWorkbook.getSheetAt(0);
			
			int rows = excelSheet.getPhysicalNumberOfRows();//3
			int cols = excelSheet.getRow(0).getPhysicalNumberOfCells();//2
			//String data[][]= new String[rows][cols];
			XSSFCell cell;
			for(int i =0 ; i< rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					cell = excelSheet.getRow(i).getCell(j);

					DataFormatter formatter = new DataFormatter();
					String val = formatter.formatCellValue(cell);
					
					System.out.println(val+"\t");		
				
				}
			}
		}
		
		File f2 = new File(excelPath1);
		FileInputStream fis2 = new FileInputStream(f2);
		try (XSSFWorkbook excelWorkbook = new XSSFWorkbook(fis2)) {
			XSSFSheet excelSheet = excelWorkbook.getSheetAt(0);
			
			int rows = excelSheet.getPhysicalNumberOfRows();//3
			int cols = excelSheet.getRow(0).getPhysicalNumberOfCells();//2
			//String data[][]= new String[rows][cols];
			XSSFCell cell;
			for(int p =0 ; p< rows;p++)
			{
				for(int q=0;q<cols;q++)
				{
					cell = excelSheet.getRow(p).getCell(q);

					DataFormatter formatter = new DataFormatter();
					String val1 = formatter.formatCellValue(cell);
					
					System.out.println(val1+"\t");
					
				
					
				
				}
			}
		}
		
		
	
	}
	
	
	}
	