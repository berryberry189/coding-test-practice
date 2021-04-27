package com.grace.test.bruteforce;

import java.io.*;

public class Q9095_123더하기_재귀 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(go(0, n)).append("\n");
		}
		
		System.out.println(sb);

	}
	private static int go(int sum, int n) {
		if(sum > n) return 0;
		if(sum == n) return 1;
		
		int now = 0;
		for(int i=1; i<=3; i++) {
			now += go(sum+i, n);
		}
		
		return now;
	}
}
