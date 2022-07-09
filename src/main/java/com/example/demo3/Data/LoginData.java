package com.example.demo3.Data;

import com.example.demo3.Constant.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Random;

public class LoginData {
	public static int sizeData=0;
	@DataProvider
	public static Object[][] loginDataProviderMethod() throws IOException{
		String excelPath = "/home/luungoc/Downloads/TestAPI/TestAPI.xlsx";
		String sheet = "login";
		ExcelUtils excel = new ExcelUtils(excelPath,sheet);
		sizeData = excel.getRowCount();
		String[][] data = new String[sizeData-4][4];
		for(int i=4;i<sizeData;i++) {
			for(int j=1;j<=4;j++) {
				data[i-4][j-1]=excel.getCellData(i, j);
				//System.out.println(data[i-4][j-1]);
			}
		}
		return data;
	}
	@DataProvider
	public static Object[][] dataAtIndex() throws IOException {
		String[][] data = (String[][]) loginDataProviderMethod();
		String[][] newData = new String[1][4];
		newData[0] =data[0];
		return newData;
	}
	@DataProvider
	public static Object[][] dataRandom() throws IOException {
		String[][] data = (String[][]) loginDataProviderMethod();
		String[][] newData = new String[1][4];
		Random ramdomdata = new Random();
		int n = ramdomdata.nextInt(sizeData-4) + 0;
		newData[0]=data[n];
		return newData;
	}
	public static void main(String[] args) throws IOException {
		Object[][] x = loginDataProviderMethod();
	}
}
