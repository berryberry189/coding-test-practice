package com.grace.test.structure;

import java.io.*;
public class Q2562 {
	public static void main(String[] args) throws Exception {
		// 최댓값 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[9];
		int max = 0;
		int cnt = 0;
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i]) {
				max = arr[i];
				cnt = i+1;
			}
		}
		bw.write(max+"\n"+cnt);
		bw.flush();
	}
}
