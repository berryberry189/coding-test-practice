package com.grace.test.dfsbfs;

import java.io.*;
import java.util.*;

public class Q2667_단지번호붙이기 {
	// https://www.notion.so/2-7f41d52b432e4914af88de2372416c93
	
	static int n;
	static int[][] map;
	static int[][] group;
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};	

	public static void main(String[] args) throws Exception{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		// 입력받은 2차 배열 map에 담기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int cnt = 0; // 단지개수
		group = new int[n][n];
		
		// 2차 배열 dfs탐색 - map이 1이며 , group은 0(아직 탐색 안함)인 경우에만
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && group[i][j] == 0) {
					dfs(i,j, ++cnt);
				}
			}
		}
		
		int[] answer = new int[cnt];
		// 단지별 집 수 계싼
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(group[i][j] != 0) answer[group[i][j]-1] += 1;
			}
		}
		
		Arrays.sort(answer);
        System.out.println(cnt);
        for (int i=0; i<cnt; i++) {
            System.out.println(answer[i]);
        }

	}
	
	static void dfs(int x, int y, int cnt) {
		group[x][y] = cnt;
		
		// (x,y) 기준 상하좌우 4번 확인
		for(int i = 0; i<4; i++) {
			int a = x + dx[i];
			int b = y + dy[i];
			
			if(0<=a && a<n && 0<=b && b<n) {
				if(map[a][b] == 1 && group[a][b] == 0) dfs(a, b, cnt);
			}
		}
	}
}
