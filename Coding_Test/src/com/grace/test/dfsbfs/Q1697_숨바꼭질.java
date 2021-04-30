package com.grace.test.dfsbfs;

import java.io.*;
import java.util.*;

public class Q1697_숨바꼭질 {
	static final int MAX = 100000;
	public static void main(String[] args) throws Exception{
		// BFS
		// 5 17 => 5-10-9-18-17 4초
		// 백준 강의 참고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
		int k = Integer.parseInt(st.nextToken()); // 동생 위치
		
		boolean[] check = new boolean[MAX];	
		int[] dist = new int[MAX];
		check[n] = true;
		dist[n] = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		
		while(!q.isEmpty()) {
			int now = q.remove();
			// -1 , +1 , *2
			if(now-1 >= 0) {
				if(check[now-1] == false) {
					q.add(now-1);
					check[now-1] = true;
					dist[now-1] = dist[now] + 1;
				}
			}
			if(now+1 < MAX) {
				if(check[now+1] == false) {
					q.add(now+1);
					check[now+1] = true;
					dist[now+1] = dist[now] + 1;
				}
			}
			if(now*2 < MAX) {
				if(check[now*2] == false) {
					q.add(now*2);
					check[now*2] = true;
					dist[now*2] = dist[now] + 1;
				}
			}
		}
		System.out.println(dist[k]);
	}
}
