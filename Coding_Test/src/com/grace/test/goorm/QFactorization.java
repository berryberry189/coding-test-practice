package com.grace.test.goorm;

import java.io.*;

public class QFactorization {
	public static void main(String[] args) throws Exception{
		// 소인수분해
		// https://level.goorm.io/exam/43105/%EC%86%8C%EC%9D%B8%EC%88%98-%EB%B6%84%ED%95%B4/quiz/1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int i = 2;
		while(i <= n) {
			if(n%i == 0) {
				sb.append(i + " ");
				n/=i;
			}else {
				i++;
			}
		}
		System.out.println(sb.toString().trim());
	}
}
