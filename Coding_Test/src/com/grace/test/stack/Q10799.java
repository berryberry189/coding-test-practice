package com.grace.test.stack;

import java.io.*;
import java.util.*;
public class Q10799 {
	public static void main(String[] args) throws Exception {
		// 쇠막대기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<Integer>();
		int cnt = 0;
		String input = br.readLine();
		for(int i=1; i<=input.length(); i++) {
			if(input.charAt(i-1) == '(') {
				stack.push(i);
			}else {
				if(stack.pop() == i-1) {
					cnt += stack.size();
				}else {
					cnt += 1;
				}
			}
		}
		bw.write(cnt+"");
		bw.flush();
	}
}
