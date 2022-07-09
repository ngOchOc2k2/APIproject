package com.example.demo3.Data;

import com.example.demo3.Controller.Controller;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Random;

public class GetNewsData {
	public static int n;
	@DataProvider
	public static  Object[][] GetNewsProvider() throws IOException{
		String excelPath = "/home/luungoc/Downloads/TestAPI/TestAPI.xlsx";
		String sheet = "GetNews";
		ExcelUtils excel = new ExcelUtils(excelPath,sheet);
		n = 20;
		String[][] data = new String[n-5][4];
		for(int i=5;i<n;i++) {
			for(int j=1;j<=4;j++) {
				data[i-5][j-1]=excel.getCellData(i, j);
			}
		}
		return data;
	}
	@DataProvider
	public static Object[][] dataRandom() throws IOException {
		String[][] data = (String[][]) GetNewsProvider();
		String[][] newData = new String[1][3];
		Random ramdomdata = new Random();
		int k = ramdomdata.nextInt(n-4) + 0;
		newData[0]=data[Controller.UnitTest];
		return newData;
	}
	public static void main(String[] args) throws IOException {
		Object[][] x = GetNewsProvider();
	}
}
