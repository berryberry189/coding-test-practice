package com.grace.test.dfsbfs;

import java.io.*;
import java.util.*;
public class Q1260_DFS와BFS {
	
	static LinkedList<Integer>[] adjList;
	static boolean[] visited;
	static int n,m,start;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 정점개수
		m = Integer.parseInt(st.nextToken()); // 간선개수
		start = Integer.parseInt(st.nextToken()); // 시작 정점번호
		
		adjList =  new LinkedList[n+1];
		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		visited = new boolean[n+1]; // 방문 여부 검사
		
		int a,b;
		while(m-- >0) { // 양방향 간선 표기
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
		
		dfs(start);
		visited = new boolean[n+1]; // 초기화
		System.out.println();
		bfs(start);
		
	}
	// 깊이탐색 - 재귀/스택
	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		
		Iterator<Integer> iterator = adjList[v].listIterator();
		while(iterator.hasNext()) {
			int w = iterator.next();
			if(!visited[w]) dfs(w);
		}
		
	}
	// 너비탐색  - 큐
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true;
		queue.add(v);
		
		while(queue.size() != 0) {
			//큐에 담긴 정점을 꺼내어 해당 점에 인접하고 아직 방문하지 않는 정점을 찾는다
			v = queue.poll(); 
			System.out.print(v+" ");
			
			Iterator<Integer> iterator = adjList[v].listIterator();
			while(iterator.hasNext()) {
				int w = iterator.next();
				if(!visited[w]) {
					// 정점 방문 여부 표시 후 큐에 해당 정점 넣기
					visited[w] = true;
					queue.add(w);
				}
			}
		}
	}
}
