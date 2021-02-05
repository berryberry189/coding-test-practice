package com.grace.test.math;

import java.io.*;
public class Q17087 {
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	public static void main(String[] args) throws Exception {
		// 숨바꼭질 6
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int S = Integer.parseInt(arr[1]);
		String[] locArr = br.readLine().split(" ");
		int gcd = 0;
		if(N == 1) {
			gcd = Math.abs(S-Integer.parseInt(locArr[0]));
		}else {
			int a = Math.abs(S-Integer.parseInt(locArr[0]));
			int b = Math.abs(S-Integer.parseInt(locArr[1]));
			gcd = a > b ? gcd(a, b) : gcd(b, a);
			for(int i=2; i<N; i++) {
				int loc = Math.abs(S-Integer.parseInt(locArr[i]));
				gcd = gcd > loc ? gcd(gcd, loc) : gcd(loc, gcd);
			}
		}
		bw.write(gcd+"");
		bw.flush();
	}
}
