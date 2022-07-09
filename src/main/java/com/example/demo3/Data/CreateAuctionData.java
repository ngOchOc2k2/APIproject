package com.example.demo3.Data;

import com.example.demo3.Controller.Controller;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Random;


public class CreateAuctionData {
	@DataProvider
	public static Object[][] CreateAuctionDataProvider() throws IOException{
		String excelPath = "/home/luungoc/Downloads/TestAPI/TestAPI.xlsx";
		String sheet = "create_auction";
		ExcelUtils excel = new ExcelUtils(excelPath,sheet);
		n = excel.getRowCount();
		String[][] data = new String[n-4][7];
		for(int i=4;i<n;i++) {
			for(int j=1;j<=7;j++) {
				data[i-4][j-1]=excel.getCellData(i, j);
			}
		}
		return data;
	}

	public static int n;
	@DataProvider
	public static Object[][] dataRandom() throws IOException {
		String[][] data = (String[][]) CreateAuctionDataProvider();
		String[][] newData = new String[1][3];
//		Random ramdomdata = new Random();
//		Controller.indexrandom = ramdomdata.nextInt(n - 4);
		newData[0]=data[Controller.indexrandom];
		return newData;
	}

	public static void main(String[] args) throws IOException {
	}
}
