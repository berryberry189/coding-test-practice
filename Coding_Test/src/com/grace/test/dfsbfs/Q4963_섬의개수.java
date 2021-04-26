package com.grace.test.dfsbfs;

import java.io.*;
import java.util.*;

public class Q4963_섬의개수 {
	
	// 위 아래 오 왼 대각선 
	static final int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static final int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int w, h, cnt;
    static int[][] map;
    
	public static void main(String[] args) throws Exception{
		// 인접한 방향이 대각선이 추가된 경우
		// 참고 https://data-make.tistory.com/455
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		map[x][y] = 0; // 방문 처리
		
		for(int i=0; i<8; i++) {
			int a = x + dx[i];
			int b = y + dy[i];
			
			if(0<=a && a<h && 0<=b && b<w) {
				if(map[a][b] == 1) dfs(a, b);
			}
		}
	}
}
