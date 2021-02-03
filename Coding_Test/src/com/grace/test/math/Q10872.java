package com.grace.test.math;

import java.io.*;
public class Q10872 {
	public static void main(String[] args) throws Exception {
		// 팩토리얼 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int multi = 1;
		
		if(N>1) {
			for(int i=N; i>1; i--) {
				multi *= i;
			}
		}
		System.out.println(multi);

	}
}
