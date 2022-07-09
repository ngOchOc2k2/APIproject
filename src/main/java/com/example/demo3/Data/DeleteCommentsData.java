package com.example.demo3.Data;

import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.Random;

public class DeleteCommentsData {
	public static int n;
	@DataProvider
	public static  Object[][] DeleteCommentsProvider() throws IOException{
		String excelPath = "/home/luungoc/Downloads/TestAPI/TestAPI.xlsx";
		String sheet = "DeleteComments";
		ExcelUtils excel = new ExcelUtils(excelPath,sheet);
		n = 13;
		String[][] data = new String[n-4][3];
		for(int i=4;i<n;i++) {
			for(int j=1;j<=3;j++) {
				data[i-4][j-1]=excel.getCellData(i, j);
				System.out.println(data[i-4][j-1]);
			}
		}
		return data;
	}
	@DataProvider
	public static Object[][] dataRandom() throws IOException {
		String[][] data = (String[][]) DeleteCommentsProvider();
		String[][] newData = new String[1][3];
		Random ramdomdata = new Random();
		int k = ramdomdata.nextInt(n) + 1;
		newData[0]=data[k];
		return newData;
	}

	public static void main(String[] args) throws IOException {
		Object[][] x = DeleteCommentsProvider();
	}
}
