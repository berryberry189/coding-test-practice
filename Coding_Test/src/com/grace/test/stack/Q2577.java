package com.grace.test.stack;

import java.io.*;
public class Q2577 {
	public static void main(String[] args) throws Exception {
		// 숫자의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] answer = new int[10];
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int all = A*B*C;
		while(all != 0) {
			answer[all%10] += 1;
			all/= 10;
		}
		for(int i=0; i<10; i++) {
			System.out.println(answer[i]);
		}
	}
}
