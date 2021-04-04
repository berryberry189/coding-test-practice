package com.grace.test.dfsbfs;

import java.io.*;
import java.util.*;

public class Q2606_바이러스 {
	
	static LinkedList<Integer>[] adjList;
	static boolean[] visited;
	static int n,m,cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 정점개수
		m = Integer.parseInt(br.readLine()); // 간선 개수
		
		visited = new boolean[n+1];
		
		adjList = new LinkedList[n+1];
		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		int a,b;
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		// 방문 순서를 위한 정렬
		for(int i=1; i<=n; i++) {
			Collections.sort(adjList[i]);
		}
		
		dfs(1);
		System.out.println(cnt);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		
		Iterator<Integer> iter = adjList[v].listIterator();
		while(iter.hasNext()) {
			int w = iter.next();
			if(!visited[w]) {
				cnt ++;
				dfs(w);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true;
		queue.add(v);
		
		while(queue.size() != 0) {
			v = queue.poll();
			
			Iterator<Integer> iter = adjList[v].listIterator();
			while(iter.hasNext()) {
				int w = iter.next();
				if(!visited[w]) {
					visited[w] = true;
					cnt ++;
					queue.add(w);
				}
			}
		}
		
	}
}
