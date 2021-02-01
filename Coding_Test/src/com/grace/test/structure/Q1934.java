package com.grace.test.structure;

import java.io.*;
import java.util.*;
public class Q1934 {
	public static int gcd(int A, int B) {
		if(B == 0) {
			return A;
		}else {
			return gcd(B, A%B);
		}
	}
	public static void main(String[] args) throws Exception {
		// 최소공배수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int gcd = A>=B ? gcd(A,B) : gcd(B,A);
			bw.write(A*B/gcd + "\n");
		}
		bw.flush();
	}
}
