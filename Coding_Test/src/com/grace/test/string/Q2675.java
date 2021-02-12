package com.grace.test.string;

import java.io.*;
public class Q2675 {
	public static void main(String[] args) throws Exception{
		// 문자열 반복 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0) {
			String[] arr = br.readLine().split(" ");
			int cnt = Integer.parseInt(arr[0]);
			String s = arr[1];
			for(int i=0; i<s.length(); i++) {
				for(int j=0; j<cnt; j++) {
					sb.append(s.charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
