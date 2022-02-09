package com.grace.test.programmers.etc;

import java.util.*;

public class Commerce_3 {
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
		
		for(int i=0; i<cntArr.length; i++) {
			System.out.println(cntArr[i]);
		}

	}
	static void dfs(int v) {
		/**
		 int[][] train = {{1,2},{1,3},{2,4}}; 
		 int[] passenger = {2,1,2,2};
		 */
		visited[v] = true;
		cnt += pg.get(v-1);
		for (int i=1; i<=n; i++) {
			if (graph[v][i] == 1 && visited[i] == false) { 
				// 간선이 있고 방문한 적이 없으면
				cnt += pg.get(i-1);
				dfs(i);
			}
		}
		cntArr[v-1] = cnt;
		cnt = 0;
		
	}

}
