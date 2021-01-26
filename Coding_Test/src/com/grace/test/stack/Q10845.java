package com.grace.test.stack;

import java.io.*;
import java.util.*;
public class Q10845 {

	public static void main(String[] args) throws IOException {
		// 큐
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		// 마지막에 입력되는값 저장
		int last = 0;
		
		while(N --> 0) {
			String input = br.readLine();
			if(input.contains("push")) {
				int val =  Integer.parseInt(input.split(" ")[1]);
				// offer queue애 객채 저장
				q.offer(val);
				sb.append(val);
				last = val;
			}else if(input.equals("pop")) {
				if(!q.isEmpty()) {
					sb.append(q.poll());
				}else {
					sb.append(-1);
				}
				sb.append(-1);
			}else if(input.equals("size")) {
				sb.append(q.size());
			}else if(input.equals("empty")) {
				if(q.isEmpty()) {
					sb.append(1);
				}else {
					sb.append(0);
				}
			}else if(input.equals("front")) {
				if(q.isEmpty()) {
					sb.append(-1);
				}else {
					sb.append(q.peek());
				}
			}else { // back
				if(q.isEmpty()) {
					sb.append(-1);
				}else {
					sb.append(last);
				}
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
