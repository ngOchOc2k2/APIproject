package com.example.demo3.Data;

import com.example.demo3.Controller.Controller;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.Random;


public class EditAuctionData {
	@DataProvider
	public static Object[][] EditAuctionDataProvider() throws IOException{
		String excelPath = "/home/luungoc/Downloads/TestAPI/edit_account.xlsx";
		String sheet = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelPath,sheet);
		n = excel.getRowCount();
		String[][] data = new String[n-4][8];
		for(int i=4;i<n;i++) {
			for(int j=1;j<=8;j++) {
				data[i-4][j-1]=excel.getCellData(i, j);
				//System.out.println(data[i-4][j-1]);
			}
		}
		return data;
	}
	public static int n;
	@DataProvider
	public static Object[][] dataRandom() throws IOException {
		String[][] data = (String[][]) EditAuctionDataProvider();
		String[][] newData = new String[1][3];
		Random ramdomdata = new Random();
		int k = ramdomdata.nextInt(n-4) + 0;
		newData[0]=data[Controller.UnitTest];
		return newData;
	}

	public static void main(String[] args) throws IOException {
		Object[][] x = EditAuctionDataProvider();
	}
}
