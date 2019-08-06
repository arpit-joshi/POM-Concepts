package com.lojack.qa.util;

import com.lojack.qa.base.TestBase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LoginData extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=20;
	
	public static  String TEST_DATASHEET_PATH ="C:\\Users\\arpit1.joshi\\eclipse-workspace\\POMConcepts\\userPassword.xlsx";
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		
		FileInputStream file=null;
		
		try {
			file=new FileInputStream(TEST_DATASHEET_PATH);
		}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	    }
		
		try {
			book=WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//sheet=book.getSheet(sheetName);
		sheet=book.getSheet(sheetName);
		
		Object [][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i=0; i < sheet.getLastRowNum(); i++ ) {
			for(int k=0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		System.out.print(data[i][k]);
			}
		}
		return data;
	}



}
