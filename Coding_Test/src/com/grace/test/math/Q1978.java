package com.grace.test.math;

import java.io.*;
import java.util.*;
public class Q1978 {
	public static void main(String[] args) throws Exception {
		// 소수 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(check(num))  cnt ++;
		}
		bw.write(cnt + "");
		bw.flush();
	}
	
	public static boolean check(int num) {
		if(num < 2 ) return false;
		for(int i=2; i*2<=num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
