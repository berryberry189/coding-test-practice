package com.grace.test.structure;

import java.io.*;
import java.util.*;
public class Q1874 {

	public static void main(String[] args) throws IOException {
		// 스택수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		int start = 0;
		
		// N --> 0 = (N-- + N>0)
		while(N --> 0) {
			int input = Integer.parseInt(br.readLine());
			if(input > start) {
				//start +1부터 입력받은 input값 까지 push
				for(int i = start+1; i<=input; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				// input값을 start로 초기화
				start = input;
			// input이 start보다 작은데 top의 값이 input이 아닌경우 "NO"출력
			}else if(stack.peek()!= input) {
				System.out.println("NO");
				return;
			}
			//무조건 1번 POP
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb);
	}
}
