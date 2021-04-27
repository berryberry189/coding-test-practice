package com.grace.test.bruteforce;

import java.io.*;
import java.util.*;

public class Q10971_외판원순회2 {
	// 참고 https://lotuslee.tistory.com/92?category=848933
	//     https://buddev.tistory.com/66
	// 완전한 이해 X
	static int n;
	static int map[][];
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0] = true;
		solve(0, 0, 0, 0);
		System.out.println(min);

	}
	static void solve(int start, int now, int sum, int cnt) {
		if(cnt == n-1) {
			if(map[now][start] != 0) min = Math.min(min, sum += map[now][start]);
			return;
		}
		for(int i=0; i<n; i++) {
			if(visited[i] || map[now][i] == 0) continue;
			if(sum > min) continue;
			visited[i] = true;
			solve(start, i, sum + map[now][i], cnt++);
			visited[i] = false;
		}
		
	}
}
