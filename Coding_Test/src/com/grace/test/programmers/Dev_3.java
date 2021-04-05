package com.grace.test.programmers;

import java.util.*;

public class Dev_3 {
	static int n = 4;
	static int cnt, last;
	static int[] cntArr = new int[n+1];
	static int[][] graph;
	static boolean[] visited;
	static LinkedList<Integer> pg = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		int[][] train = {{1,2},{1,3},{2,4}}; 
		int[] passenger = {2,1,2,2};
		for(int i=0; i<passenger.length; i++) {
			pg.add(passenger[i]);
		}
		
		visited = new boolean[n+1];
		
		graph = new int[n+1][n+1];
		int a,b;
		
		for(int i=0; i<train.length; i++) {
			a = train[i][0];	
			b = train[i][1];
			graph[a][b] = graph[b][a] = 1;
		}
		
		dfs(1);
		
		System.out.println(cnt);

	}
	static void dfs(int v) {
		visited[v] = true;
		for (int i=1; i<=n; i++) {
			if (graph[v][i] == 1 && visited[i] == false) { 
			// 간선이 있고 방문한 적이 없으면
				System.out.println("--------" + v + "--------");
				cnt += pg.get(i);
				dfs(i);
			}
		}
		
	}

}
