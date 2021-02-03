package com.grace.test.structure;

import java.io.*;
public class Q1546 {
	public static void main(String[] args) throws Exception{
		// 평균
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		int[] numArr = new int[N];
		double max = 0, sum = 0;
		for(int i=0; i<N; i++) {
			int score = Integer.parseInt(strArr[i]);
			numArr[i] = score;
			if(max < score) {
				max = score;
			}
		}
		for(int i=0; i<N; i++) {
			sum += numArr[i]/max*100;
		}
		bw.write(sum/N + "");
		bw.flush();
	}
}
