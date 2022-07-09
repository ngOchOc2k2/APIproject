package com.example.demo3.Data;

import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.Random;


public class AcceptMaxBidData {
	public static int n;
	@DataProvider
	public static Object[][] AcceptMaxBidDataProvider() throws IOException{
		String excelPath = "/home/luungoc/Downloads/TestAPI/TestAPI.xlsx";
		String sheet = "accept_max_bid";
		ExcelUtils excel = new ExcelUtils(excelPath,sheet);
		n = excel.getRowCount();
		String[][] data = new String[n-4][5];
		for(int i=4;i<n;i++) {
			for(int j=1;j<=5;j++) {
				data[i-4][j-1]=excel.getCellData(i, j);
				//System.out.println(data[i-4][j-1]);
			}
		}
		return data;
	}
	@DataProvider
	public static Object[][] dataRandom() throws IOException {
		String[][] data = (String[][]) AcceptMaxBidDataProvider();
		String[][] newData = new String[1][3];
		Random ramdomdata = new Random();
		int k = ramdomdata.nextInt(1) + 0;
		newData[0]=data[k];
		return newData;
	}

	public static void main(String[] args) throws IOException {
		Object[][] x = AcceptMaxBidDataProvider();
	}
}
