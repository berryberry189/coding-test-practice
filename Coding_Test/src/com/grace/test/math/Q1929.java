package com.grace.test.math;

import java.io.*;
public class Q1929 {
	public static void main(String[] args) throws Exception {
		// 소수 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = br.readLine().split(" ");
		int M = Integer.parseInt(arr[0]);
		int N = Integer.parseInt(arr[1]);
		
		boolean[] answer = new boolean[N+1];
		
		for(int i=2; i<=N; i++) {
			answer[i] = true;
		}
		for(int i=2; i<=N; i++) {
			if(answer[i]) {
				for(int j=i*2; j<=N; j+=i) {
					answer[j] = false;
				}
			}
		}
		for(int i=M; i<=N; i++) {
			if(answer[i]) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
	}
}
