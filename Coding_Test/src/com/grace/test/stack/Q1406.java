package com.grace.test.stack;

import java.io.*;
import java.util.*;
public class Q1406 {

	public static void main(String[] args) throws IOException {
		// 에디터
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 처음 커서는 맨 왼쪽에 위치
		// 커서 기준 왼쪽 스택
		Stack<Character> st1 = new Stack<Character>();
		// 커서 기준 오른쪽 스택
		Stack<Character> st2 = new Stack<Character>();
		String input = br.readLine();
		int N = input.length();
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st1.push(input.charAt(i));
		}
		
		while(M --> 0) {
			 String cmnd = br.readLine();
			 if(cmnd.equals("L")) {
				 // 왼쪽 스택이 empty상태가 아니면 왼쪽스택의 가장 위에있는 문자를 오른쪽 스택으로 옮김
				 if(!st1.empty()) st2.push(st1.pop());
			 }else if(cmnd.equals("D")) {
				 // 오른쪽 스택이 empty상태가 아니면 오른쪽스택의 가장 위에있는 문자를 왼쪽 스택으로 옮김
				 if(!st2.empty()) st1.push(st2.pop());
			 }else if(cmnd.equals("B")) {
				 // 왼쪽 스택의 가장 위에있는 문자를 삭제 
				 if(!st1.empty()) st1.pop();
			 }else {
				 // 왼쪽 스택에 문자를 삽입
				 char P = cmnd.charAt(2);
				 st1.push(P);
			 }
		}
		
		while(!st1.empty()) {
			// 왼쪽스택의 모든 문자를 오른쪽 스택으로 옮김
			st2.push(st1.pop());
		}
		
		while(!st2.empty()) {
			// 오른쪽 스택의 모든 문자를 순서대로 출력
			bw.write(st2.pop());
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
