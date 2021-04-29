package com.grace.test.string;

import java.io.*;

public class Q12813_이진수연산 {
	public static void main(String[] args) throws Exception{
		// https://www.acmicpc.net/problem/12813
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String strA = br.readLine();
		String strB = br.readLine();
		int n = strA.length();
		int[] arrA = new int[n];
		int[] arrB = new int[n];	
		
		for(int i=0; i<n; i++) {
			arrA[i] = strA.charAt(i) - '0';
			arrB[i] = strB.charAt(i) - '0';
		}
		// A&B
		for(int i=0; i<n; i++) {
			sb.append(arrA[i] & arrB[i]);
		}
		sb.append("\n");
		
		// A|B
		for(int i=0; i<n; i++) {
			sb.append(arrA[i] | arrB[i]);
		}
		sb.append("\n");
		
		// A^B
		for(int i=0; i<n; i++) {
			sb.append(arrA[i] ^ arrB[i]);
		}
		sb.append("\n");
		
		// ~A
		for(int i=0; i<n; i++) {
			sb.append(arrA[i]^1);
		}
		sb.append("\n");
		
		// ~B
		for(int i=0; i<n; i++) {
			sb.append(arrB[i]^1);
		}
		sb.append("\n");
		System.out.println(sb);
		

	}
}
