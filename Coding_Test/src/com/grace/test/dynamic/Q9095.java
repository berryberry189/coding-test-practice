package com.grace.test.dynamic;

import java.io.*;
public class Q9095 {
	public static void main(String[] args) throws Exception {
		// 1, 2, 3 더하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[11];
		d[0] = 1; d[1] = 1; d[2] = 2; d[3] = 4;
		for(int i=4; i<11; i++) {
			d[i] = d[i-1] + d[i-2] + d[i-3];
		}
		while(n-- > 0) {
			int t = Integer.parseInt(br.readLine());
			bw.write(d[t] + "\n");
		}
		bw.flush();
	}
}
