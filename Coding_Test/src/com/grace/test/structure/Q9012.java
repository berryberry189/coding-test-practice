package com.grace.test.stack;

import java.io.*;
import java.util.*;
public class Q9012 {
	public static void main(String[] args) throws IOException {
		// 괄호 ->140ms
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			Stack<Character> stack = new Stack<Character>();
			String input = br.readLine();
			boolean bool = true;
			char temp;
			for(int j=0; j<input.length(); j++) {
				temp = input.charAt(j);
				if(temp == '(') {
					stack.push(temp);
				}else {
					if(stack.isEmpty()){
						bool = false; 
						break;
					}else {
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty()) bool = false;
			sb.append( bool ? "YES" : "NO" ).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
