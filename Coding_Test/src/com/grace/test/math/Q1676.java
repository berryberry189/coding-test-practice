package com.grace.test.math;

import java.io.*;
public class Q1676 {
	public static void main(String[] args) throws Exception {
		// 팩토리얼 0의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=5; i<=N; i*=5) {
			// 25 50 75 100 처럼 5가 2개씩 들어가는 경우가 있음
	        // i가 n보다 작거나 같을 동안에는 i를 5의 배수만큼 증가시켜가면서 n을 i로 나눈 값을 정답 변수에 담아줌
			cnt += N/i;
		}
		
		System.out.println(cnt);
	}
}
