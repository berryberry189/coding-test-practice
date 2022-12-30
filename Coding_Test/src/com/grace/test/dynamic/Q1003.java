package com.grace.test.dynamic;

import java.io.*;
public class Q1003 {
	static Integer[][]dp = new Integer[41][2];
	public static Integer[] fibonacci(int n) {
		if(dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = fibonacci(n-1)[0] +  fibonacci(n-2)[0];
			dp[n][1] = fibonacci(n-1)[1] +  fibonacci(n-2)[1];
		}
		return dp[n];
	}
	public static void main(String[] args) throws Exception {
		// 피보나치 함수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		dp[0][0] = 1; // n이 0일때 0호출 횟수 
		dp[0][1] = 0; // n이 0일때 1호출 횟수 
		dp[1][0] = 0; // n이 1일때 0호출 횟수 
		dp[1][1] = 1; // n이 1일때 1호출 횟수 
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			fibonacci(n);
			sb.append(dp[n][0] + " " + dp[n][1] + "\n");
		}
		System.out.println(sb);
	}
}
