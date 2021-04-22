package com.grace.test.dfsbfs;

import java.io.*;
import java.util.*;

public class Q2667_단지번호붙이기 {
	// 미완성	
	// 참고 https://data-make.tistory.com/454 
	
	static int n, cnt, num;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,-1};
	static int[] dy = {-1,-1,0,0};
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];
		map = new int[n][n];
		num = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					num++;
					dfs(i,j);
					arr.add(cnt);
				}
			}
		}
		
		System.out.println(cnt);
		arr.sort(null);
		for(int i : arr) {
			System.out.println(i);
		}

	}
	
	static void dfs(int x, int y) {
		cnt ++;
		visited[x][y] = true;
		
		// (x,y) 기준 상하좌우 4번 확인
		for(int i = 0; i<4; i++) {
			int a = x + dx[i];
			int b = y + dy[i];
			
			if(a<0 || b<0 || a>=n || b>=n) continue;
			if(map[a][b] != 1) continue;
			dfs(a,b);
		}
	}
	

}
