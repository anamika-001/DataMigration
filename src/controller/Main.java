package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.Databasedao;
import dao.Exceldao;
import utility.ConnectionManager;

public class Main {
	

      public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
    	
    	System.out.println("YOUR DATA IN EXCEL");
    	Exceldao excel=new Exceldao();
    	try {
			excel.readingExcel("users.xlsx");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    	String File="users.xlsx";
    	try {
    		
    		FileInputStream inputStream=new FileInputStream(File);
    		
    		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
    		
    		XSSFSheet sheet=workbook.getSheetAt(0);
    		
    		Iterator<Row> rowIterartor =sheet.iterator();
    		
    		Row row;
    		for(int i=1; i<=sheet.getLastRowNum();i++) {
    			row =(Row) sheet.getRow(i);
    			
    			byte id =(byte) row.getCell(0).getNumericCellValue();
    			String name = row.getCell(1).getStringCellValue();
    			String city =row.getCell(2).getStringCellValue();
    			String Contact =NumberToTextConverter.toText(row.getCell(3).getNumericCellValue());
    			
    			String tablename=File.split("[.]")[0];
    			
    			String sql="INSERT INTO "+tablename+" (id ,name ,city , contact)VALUES('"+id+"','"+name+"','"+city+"','"+Contact+"')";
    			
    			PreparedStatement statement=ConnectionManager.getConnection().prepareStatement(sql);
    			statement.execute();
    			System.out.println("import rows"+i);
    		}
    		System.out.println("Successfully imported data from excel to database");
    	}
    	
    	catch (ClassNotFoundException e) 
    	  {
    	     e.printStackTrace();
    	  }
    	  catch (SQLException e) 
    	  {
    	     e.printStackTrace();
    	  }   
    	System.out.println("YOUR DATA IN DATABASE");
    	Databasedao db=new Databasedao();
    	db.getAllUsers();
    	
    }
}
