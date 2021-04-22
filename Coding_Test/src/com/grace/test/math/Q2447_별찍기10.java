package com.grace.test.math;

import java.io.*;

public class Q2447_별찍기10 {
	static char[][] arr;
	static void starAction(int n) {
		
	}
	public static void main(String[] args) throws Exception{
		// 별 찍기 - 10 미완 210405
		// 참고 https://iseunghan.tistory.com/202
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i == 1 && j == 1) sb.append(" ");
				else sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
