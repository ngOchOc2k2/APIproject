package com.example.demo3.Data;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Random;


public class SliderData {
	@DataProvider
	public static Object[][] SliderDataProvider() throws IOException{
		String excelPath = "/home/luungoc/Downloads/TestAPI/TestAPI.xlsx";
		String sheet = "slider";
		ExcelUtils excel = new ExcelUtils(excelPath,sheet);
		n = excel.getRowCount();
		String[][] data = new String[n-4][2];
		for(int i=4;i<n;i++) {
			for(int j=1;j<=2;j++) {
				data[i-4][j-1]=excel.getCellData(i, j);
			}
		}
		return data;
	}
	public static int n;
	@DataProvider
	public static Object[][] dataRandom() throws IOException {
		String[][] data = (String[][]) SliderDataProvider();
		String[][] newData = new String[1][3];
		Random ramdomdata = new Random();
		int k = ramdomdata.nextInt(n-4) + 0;
		newData[0]=data[k];
		return newData;
	}
	public static void main(String[] args) throws IOException {
		Object[][] x = SliderDataProvider();
	}
}
