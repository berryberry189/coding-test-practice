package com.grace.test.bruteforce;

import java.io.*;
import java.util.*;

public class Q14889_스타트와링크 {
	static int n, min=Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		// 큰 경우의 수: 각 사람이 1. 1번팀에 들어가는 경우  / 2. 2번 팀에 들어가는 경우
		// 참고 https://st-lab.tistory.com/122
		// 이해 안가는중 ㅎㅎ,,, (4/28)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
	private static void solve(int idx, int cnt) {
		// 팀 조합 끝난 경우
		if(cnt == n/2){
			min = Math.min(min, calutate());
			return;
		}
		// 팀 조합 미완성인 경우
		for(int i=idx; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				solve(idx+1, cnt+1);
				visited[i] = false;
			}
		}
		
		
	}
	private static int calutate() {
		int start = 0;
		int link = 0;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				
			}
			
		}
		return Math.abs(start - link);
	}
}
