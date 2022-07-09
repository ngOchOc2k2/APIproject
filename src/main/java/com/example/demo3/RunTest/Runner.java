package com.example.demo3.RunTest;
import com.example.demo3.TestAPI.LoginTest.LoginTestAll;
import org.testng.TestNG;

public class Runner {
	public static void main(String[] args) {
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { LoginTestAll.class});
		testng.run();
	}
}
