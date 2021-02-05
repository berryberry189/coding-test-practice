package com.grace.test.math;

import java.io.*;
public class Q9613 {
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	public static void main(String[] args) throws Exception {
		// GCD 합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			String[] arr = br.readLine().split(" ");
			int n = Integer.parseInt(arr[0]);
			long sum = 0L;
			for(int i=1; i<n; i++) {
				for( int j=i+1; j<=n; j++) {
					int a = Integer.parseInt(arr[i]);
					int b = Integer.parseInt(arr[j]);
					sum += ( a > b ? gcd(a, b) : gcd(b, a) );
				}
			}
			bw.write(sum + "\n");
		}
		bw.flush();
	}
}
