package com.example.demo3.Data;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import com.example.demo3.Constant.ExcelUtils;
public class LogoutData {
    public static int n;
    @DataProvider
    public static Object[][] logoutDataProviderMethod() throws IOException {
        String excelPath = "/home/luungoc/Downloads/TestAPI/TestAPI.xlsx";
        String sheet = "logout";
        ExcelUtils excel = new ExcelUtils(excelPath,sheet);
        n = excel.getRowCount();
        String[][] data = new String[n-4][3];
        for(int i=4;i<n;i++) {
            for(int j=1;j<=3;j++) {
                data[i-4][j-1]=excel.getCellData(i, j);
            }
        }
        return data;
    }
    @DataProvider
    public static Object[][] dataAtIndex() throws IOException {
        int index = 4;
        Object[][] data = logoutDataProviderMethod();
        Object[][] newData = new Object[1][3];
        newData[0]=data[index];
        return newData;
    }
    public static void main(String[] args) throws IOException {
        Object[][] x = logoutDataProviderMethod();
    }
}
