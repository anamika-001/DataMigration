package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Users;

public class Exceldao {
	
//	String fileName="users.xlsx";
	
	 public void readingExcel(String fileName) throws IOException {
	        try (FileInputStream file = new FileInputStream(fileName)) {
	        	XSSFWorkbook workbook = new XSSFWorkbook (file);

	        	//Get first sheet from the workbook
	        	XSSFSheet sheet = workbook.getSheetAt(0);

	        	//Get iterator to all the rows in current sheet
	        	Iterator<Row> rowIterator = sheet.iterator();

	        	
	        	while(rowIterator.hasNext()) {
					Row row = rowIterator.next();
					
					//For each row, iterate through each columns
					Iterator<Cell> cellIterator = row.cellIterator();
					while(cellIterator.hasNext()) {
						
						Cell cell = cellIterator.next();
						
						switch(cell.getCellType()) {
							case BOOLEAN:
								System.out.print(cell.getBooleanCellValue() + "\t\t\t");
								break;
							case NUMERIC:
								System.out.print(NumberToTextConverter.toText(cell.getNumericCellValue()) + "\t\t\t");
								break;
							case STRING:
								System.out.print(cell.getStringCellValue() + "\t\t\t");
								break;
						}
					}
					System.out.println("\t\t\t");
				}
				file.close();
				FileOutputStream out = 
					new FileOutputStream(fileName);
				workbook.write(out);
				out.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	 
	
	
	
	
}

