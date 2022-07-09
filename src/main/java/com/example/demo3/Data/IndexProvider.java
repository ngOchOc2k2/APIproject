package com.example.demo3.Data;

import java.util.Scanner;

public class IndexProvider {
	public static int indexProvider() {
		System.out.println("Hay chon 1 test case de kiem thu:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		return a;
	}
}
