package com.grace.test.dynamic;

import java.io.*;
public class Q2193 {
	public static void main(String[] args) throws Exception{
		// 이친수
		// 2진수라 가능한 풀이 
		// 1. 0으로 끝나는 경우 끝자리 앞에 0,1 둘 다 올 수 있음
		// 2. 1로 끝나는 경우에 끝자리 바로앞자리엔 0밖에 올 수 없으며, 그 앞자리에 0,1 둘 다 올 수 있음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] d = new long[n+1];
		 d[1] = 1; 
		 for(int i=2; i<=n; i++) {
			 d[i] = d[i-1] + d[i-2];
		 }
		System.out.println(d[n]);
	}
}
