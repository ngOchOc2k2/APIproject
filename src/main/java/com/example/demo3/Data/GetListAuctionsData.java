package com.example.demo3.Data;

import com.example.demo3.Controller.Controller;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Random;


public class GetListAuctionsData {
	@DataProvider
	public static Object[][] GetListAuctionsDataProvider() throws IOException{
		String excelPath = "/home/luungoc/Downloads/TestAPI/TestAPI.xlsx";
		String sheet = "get_list_auctions";
		ExcelUtils excel = new ExcelUtils(excelPath,sheet);
		n = excel.getRowCount();
		String[][] data = new String[n-4][4];
		for(int i=4;i<n;i++) {
			for(int j=1;j<=4;j++) {
				data[i-4][j-1]=excel.getCellData(i, j);
			}
		}
		return data;
	}
	public static int n;
	@DataProvider
	public static Object[][] dataRandom() throws IOException {
		String[][] data = (String[][]) GetListAuctionsDataProvider();
		String[][] newData = new String[1][3];
		Random ramdomdata = new Random();
		int k = ramdomdata.nextInt(n) + 1;
		newData[0]=data[Controller.UnitTest];
		return newData;
	}

	public static void main(String[] args) throws IOException {
		Object[][] x = GetListAuctionsDataProvider();
	}
}
