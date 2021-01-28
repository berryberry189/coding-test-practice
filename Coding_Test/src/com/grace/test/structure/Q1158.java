package com.grace.test.stack;

import java.io.*;
import java.util.*;
public class Q1158 {

	public static void main(String[] args) throws IOException {
		// 요세푸스 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		sb.append("<");
		while(!q.isEmpty()) {
			for(int i=1; i<=K; i++) {
				if(i == K) {
					sb.append(q.poll() +", ");
				}else {
					q.offer(q.poll());
				}
			}			
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
