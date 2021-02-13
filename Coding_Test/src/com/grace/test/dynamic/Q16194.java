package com.grace.test.dynamic;

import java.io.*;
import java.util.*;
public class Q16194 {
	public static void main(String[] args) throws Exception {
		// 카드 구매하기 2 (최솟값)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n+1];
		int[] d = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			d[i] = -1;
		}
		d[0] = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				if(d[i] == -1 || d[i]> d[i-j] + p[j]) d[i] = d[i-j] + p[j];
			}
		}
		bw.write(d[n] + "");
		bw.flush();
	}
}
