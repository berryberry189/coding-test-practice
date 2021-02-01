package com.grace.test.structure;

import java.io.*;
public class Q2609 {
	public static int gcd(int A, int B) {
		if(B == 0) {
			return A;
		}else {
			
			return gcd(B, A%B);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 최대공약수와 최소공배수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = br.readLine().split(" ");
		int A = Integer.parseInt(arr[0]);
		int B = Integer.parseInt(arr[1]);
		int gcd = gcd(A,B);
		int lcm = A * B / gcd;
		bw.write(gcd + "\n" + lcm);
		bw.flush();
	}
}
