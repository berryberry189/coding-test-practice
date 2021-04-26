package com.grace.test.dfsbfs;

import java.util.*;

public class Q7562_나이트의이동 {
	
	static final int[] dx = {-2,-1,1,2,2,1,-1,-2};
	static final int[] dy = {1,2,2,1,-1,-2,-2,-1};
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		
		while(n-- > 0) {
			int len = sc.nextInt();  //체스판 한변의 길이
			int nowX = sc.nextInt(); // 나이트가 현재 있는 칸 x
			int nowY = sc.nextInt(); // 나이트가 현재 있는 칸 y
			int goX = sc.nextInt();  // 나이트가 이동 하려는 칸 x
			int goY = sc.nextInt();  // 나이트가 이동 하려는 칸 y
			
			int[][] d = new int[len][len]; // 체스판
			for(int i=0; i<len; i++) {
				Arrays.fill(d[i], -1);  // 한줄씩 -1로 채우기
			}
			Queue<Pair> q = new LinkedList<Pair>();
			q.add(new Pair(nowX, nowY));
			d[nowX][nowY] = 0;
			while(!q.isEmpty()) {
				Pair p = q.remove();
				for(int i=0; i<8; i++) {
					int a = p.x + dx[i];
					int b = p.y + dy[i];
					if(0<=a && a<len && 0<=b && b<len) {
						if(d[a][b] == -1) {
							d[a][b] = d[p.x][p.y] + 1;
							q.add(new Pair(a,b));
						}
					}
				}
			}
			sb.append(d[goX][goY]+"\n");
		}
		System.out.println(sb);
	}
}
