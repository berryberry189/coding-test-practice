package com.grace.test.math;

import java.io.*;
public class Q10870_피보나치 {
	public static int fibonacci(int n) {
		if(n == 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	public static void main(String[] args) throws Exception{
		// 피보나치 수 5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibonacci(n));
		
	}
}
