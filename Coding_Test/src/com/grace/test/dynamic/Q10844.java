package com.grace.test.dynamic;

import java.io.*;
public class Q10844 {
	public static void main(String[] args) throws Exception {
		// 쉬운 계단 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // n<=100
		long div = 1000000000;
		long[][] d = new long[n+1][10];
		for(int i=1; i<10; i++) {
			d[1][i] = 1;
		}
		for(int i=2; i<=n; i++) {
			for(int j=0; j<10; j++) {
				if(j==0) {
					d[i][j] = d[i-1][j+1] % div;
				}else if(j==9){
					d[i][j] = d[i-1][j-1] % div;
				}else {
					d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % div ;
				}
			}
		}
		long result = 0;
		for(int i=0; i<10; i++) {
			result += d[n][i];
		}
		System.out.println(result % div);
	}
}
