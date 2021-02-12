package com.grace.test.dynamic;

import java.io.*;
public class Q11726 {
	public static int[] d;
	public static int check(int n) {
		if(n == 0 || n == 1) return 1; // 0은 없는 사각형이지만 1개로 구
		if(d[n] > 0) {
			return d[n];
		}else {
			d[n] = (check(n-1) + check(n-2)) % 10007;
			return d[n];
		}
	}
	public static void main(String[] args) throws Exception{
		// 2×n 타일링
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		d = new int[n+1];
		System.out.println(check(n));
	}
}

