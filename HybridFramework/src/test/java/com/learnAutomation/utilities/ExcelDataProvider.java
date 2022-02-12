package com.learnAutomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src = new File("./TestData/Login.xlsx");
		
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to read Excel File"+ e.getMessage());
		}
	}
	
	public String getStringData(String SheetName, int Row, int Cell)
	{
		return wb.getSheet(SheetName).getRow(Row).getCell(Cell).getStringCellValue();
	}
	
	public String getStringData(int SheetNum, int Row, int Cell)
	{
		return wb.getSheetAt(SheetNum).getRow(Row).getCell(Cell).getStringCellValue();
	}

	public double getNumericData(String SheetName, int Row, int Cell)
	{
		return wb.getSheet(SheetName).getRow(Row).getCell(Cell).getNumericCellValue();	
	}
}
