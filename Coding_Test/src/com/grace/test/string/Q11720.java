package com.grace.test.string;

import java.io.*;
public class Q11720 {
	public static void main(String[] args) throws Exception{
		// 숫자의 합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split("");
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		System.out.println(sum);
	}
}
