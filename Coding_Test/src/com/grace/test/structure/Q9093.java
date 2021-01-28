package com.grace.test.structure;

import java.io.*;
import java.util.*;
public class Q9093 {
	public static void main(String[] args) throws IOException {
		// 단어 뒤집기 -> 716ms
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		String input;
		for(int i=0; i<N; i++) {
			input = br.readLine() + "\n";
			for(int j=0; j<input.length(); j++) {
				if(input.charAt(j) == ' ' || input.charAt(j) == '\n') {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
				}else {
					stack.push(input.charAt(j));
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
