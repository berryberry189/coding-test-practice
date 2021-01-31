package com.grace.test.structure;

import java.io.*;
import java.util.*;
public class Q10866 {
	public static void main(String[] args) throws Exception {
		// 덱
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<String> dq = new LinkedList<String>();
		
		int N = Integer.parseInt(br.readLine());
		
		while(N --> 0) {
			String[] arr = br.readLine().split(" ");
			String comm = arr[0];
			if(comm.equals("push_front")) {
				dq.addFirst(arr[1]);
			}else if(comm.equals("push_back")) {
				dq.addLast(arr[1]);
			}else if(comm.equals("pop_front")) {
				if(dq.isEmpty()) {
					sb.append("-1");
				}else {
					sb.append(dq.pollFirst());
				}
				sb.append("\n");
			}else if(comm.equals("pop_back")) {
				if(dq.isEmpty()) {
					sb.append("-1");
				}else {
					sb.append(dq.pollLast());
				}
				sb.append("\n");
			}else if(comm.equals("size")) {
				sb.append(dq.size()+"\n");
			}else if(comm.equals("empty")) {
				if(dq.isEmpty()) {
					sb.append("1");
				}else {
					sb.append("0");
				}
				sb.append("\n");
			}else if(comm.equals("front")) {
				if(dq.isEmpty()) {
					sb.append("-1");
				}else {
					sb.append(dq.peekFirst());
				}
				sb.append("\n");
			}else { // back
				if(dq.isEmpty()) {
					sb.append("-1");
				}else {
					sb.append(dq.peekLast());
				}
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
