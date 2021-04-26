package com.grace.test.dfsbfs;

import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q2178_미로탐색 {
	
	static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		// https://www.acmicpc.net/problem/2178
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		int[][] map = new int[n][m];
		boolean[][] check = new boolean[n][m];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0));
		map[0][0] = 1;
		check[0][0] = true;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4; i++) {
				int a = x + dx[i];
				int b = y + dy[i];
				if(0<=a && a<n && 0<=b && b<m) {
					if(arr[a][b] == 1 && check[a][b] == false) {
						q.add(new Pair(a, b));
						map[a][b] = map[x][y] + 1;
						check[a][b] = true;
					}
				}
			}
		}
		
		System.out.println(map[n-1][m-1]);
		
		// 확인용 출력
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j]+ " | ");
			}
			System.out.println();
		}
	}
}


