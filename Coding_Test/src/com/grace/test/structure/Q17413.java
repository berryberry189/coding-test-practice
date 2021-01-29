package com.grace.test.structure;

import java.io.*;
import java.util.*;
public class Q17413 {
	public static void main(String[] args) throws Exception{
		//단어 뒤집기 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<Character>();
		String S = br.readLine()+"\n";
		boolean tag = false;
		for(int i=0; i<S.length(); i++) {
			char input = S.charAt(i);
			if(input == '<') tag = true;
				
			if(tag || input == ' ' || input == '\n') {
				while(!stack.isEmpty()) {
					bw.write(stack.pop());
				}
				if(input != '\n') bw.write(input);
			}else {
				stack.push(input);
			}
			if(input == '>') tag = false;
		}
		bw.flush();
	}
}
