package com.grace.test.dfsbfs;

import java.io.*;
import java.util.*;

public class Q7576_토마토 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception{
		// BFS 탐색을 하면서, 거리를 재는 방식으로 진행
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		int[][] map = new int[n][m];
		Queue<Pair> q = new LinkedList<Pair>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = -1;
				if(arr[i][j] == 1) {
					q.add(new Pair(i, j));
					map[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4; i++) {
				int a = x + dx[i];
				int b = y + dy[i];
				if(0<=a && a<n && 0<=b && b<m) {
					if(arr[a][b] == 0 && map[a][b] == -1) {
						q.add(new Pair(a, b));
						map[a][b] = map[x][y] + 1;
					}
				}
			}
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(answer < map[i][j]) answer = map[i][j];
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0 && map[i][j] == -1)  answer = -1;
			}
		}
		System.out.println(answer);
		
		// 확인용 출력
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j]+ " | ");
			}
			System.out.println();
		}

	}
}
