package com.grace.test.stack;

import java.io.*;
import java.util.*;
public class Q17298 {
	public static void main(String[] args) throws Exception {
		// 오큰수
		// 그 숫자가 어떤 수의 오큰수의 해당하는가로 접근 , 스택에 index를 저장하는 방식으로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		// 입력받은 숫자 배열
		int[] arr = new int[N];
		// 정답 배열
		int[] answer = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		for(int i=0; i<N; i++) {
			if(stack.isEmpty()) stack.push(i);
			/*
			 * 스택이 비어있지 않으면서 
			 * i가 스택의 맨 위 원소가 가리키는 원소보다 큰 경우
			 * 해당 조건을 만족할 때 까지 stack의 원소를 pop하면서
			 * answer[]의 해당 인덱스의 값을 현재 원소(arr[i])로 바꿔준다. 
			 */
			while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
				answer[stack.peek()] = arr[i];
				stack.pop();
			}
			stack.push(i);
		}
		
		// 남아있는 스택의 원소를 index로 가지는 answer의 value를 -1로 바꿔줌
		while(!stack.isEmpty()) {
			answer[stack.peek()] = -1;
			stack.pop();
		}
		
		for(int i=0; i<answer.length; i++) {
			bw.write(answer[i]+" ");
		}
		bw.flush();
	}
}
