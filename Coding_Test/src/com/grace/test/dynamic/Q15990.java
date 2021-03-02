package com.grace.test.dynamic;

import java.io.*;
public class Q15990 {
	public static void main(String[] args) throws Exception {
		// 1, 2, 3 더하기 5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		long d[][] =  new long[100001][4];
		int div = 1000000009;
		d[1][1] = 1;
		d[1][2] = 0;
		d[1][3] = 0;
		
		d[2][1] = 0;
		d[2][2] = 1;
		d[2][3] = 0;
		
		d[3][1] = 1;
		d[3][2] = 1;
		d[3][3] = 1;
		
		for(int i=4; i<=100000; i++) {
			d[i][1] = (d[i-1][2] + d[i-1][3]) % div;
			d[i][2] = (d[i-2][1] + d[i-2][3]) % div;
			d[i][3] = (d[i-3][1] + d[i-3][2]) % div;
		}
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append((d[n][1] + d[n][2] + d[n][3]) % div+"\n");
		}
		System.out.println(sb);
	}
}
