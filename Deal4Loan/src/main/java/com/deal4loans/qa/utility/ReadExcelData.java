package com.deal4loans.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	static FileInputStream fin = null;
	static XSSFWorkbook workbook = null;
	public static Object[][] readExcel(final String PATH,String sheetName) 
	{
		
		try {
			fin = new FileInputStream(PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			workbook = new XSSFWorkbook(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 int rows = sheet.getPhysicalNumberOfRows();
		 int cols = sheet.getRow(0).getLastCellNum();
		 Object[][] data = new Object[rows][cols];
		 DataFormatter df = new DataFormatter();
		 for(int i=0;i<rows;i++)
		 {
			 for(int j=0;j<cols;j++)
			 {
				 data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j)).trim();
			 }
		 }
		return data;
	}	
	
	public static String getCell(String path,String sheetName,int romNum, int colNum)
	{
		try {
			fin = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			workbook = new XSSFWorkbook(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 DataFormatter df = new DataFormatter();
		 String cell = df.formatCellValue(sheet.getRow(romNum).getCell(colNum));
		 return cell;
	}
	
	public static int rowCount(String PATH,String sheetName)
	{
		try {
			fin = new FileInputStream(PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			workbook = new XSSFWorkbook(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 int rows = sheet.getPhysicalNumberOfRows();
		 return rows;
	}
	
	public static int columnCount(String PATH,String sheetName)
	{
		try {
			fin = new FileInputStream(PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			workbook = new XSSFWorkbook(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 int cols = sheet.getRow(0).getLastCellNum();
		 return cols;
	}
	

}
