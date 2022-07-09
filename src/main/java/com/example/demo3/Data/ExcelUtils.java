package com.example.demo3.Data;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	public ExcelUtils(String excelPath, String sheetName) throws IOException {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);		
	}
	public String getCellData(int numRow,int numCol) {
		DataFormatter formatter = new DataFormatter();
		String result = formatter.formatCellValue(sheet.getRow(numRow).getCell(numCol));
		return result;
	}
	public int getRowCount() throws IOException{
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
	public int getCodeCol() {
		int j=0;
		while(this.getCellData(3, j)!="code") {
			j++;
		}
		return j;
	}
}
