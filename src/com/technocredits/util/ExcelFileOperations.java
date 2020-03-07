package com.technocredits.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileOperations {
	static public String[][] readExcelData(String Filepath,String Sheetname) throws IOException
	{
		File file=new File(Filepath);
		FileInputStream input=new FileInputStream(file);
		Workbook myworkbook=new XSSFWorkbook(input);
		Sheet sheet=myworkbook.getSheet(Sheetname);
		int totalrows=sheet.getLastRowNum()+1;
		System.out.println(totalrows);
		int totalcol=sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
		System.out.println(totalcol);
		String[][] data=new String[totalrows][totalcol];
		for(int i=0;i<totalrows;i++)
		{
			for(int j=0;j<totalcol;j++)
			{
				if(sheet.getRow(i).getCell(j).getCellType()==CellType.STRING)
				{
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
				else if(sheet.getRow(i).getCell(j).getCellType()==CellType.NUMERIC)
				{
					data[i][j]=String.valueOf(sheet.getRow(i).getCell(j).getStringCellValue());
				}
					
			}
		}
		return data;
	}

}
