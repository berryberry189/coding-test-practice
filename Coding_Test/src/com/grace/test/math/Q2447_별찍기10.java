package com.grace.test.math;

import java.io.*;
import java.util.*;
public class Q2447_별찍기10 {
	static char[][] arr;
	
	static void starAction(int n, int x, int y) {
		
		// 더 이상 나눌 수 없는 수 
		if(n == 1) {
			arr[x][y] = '*';
			return;
		}
		
		int size = n/3; //블록 사이즈
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i == 1 && j == 1) {
					continue; // 한 가운데이므로 공백상태 그대로 유지
				}else {
					starAction(size, x+size*i, y+size*j);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// 별 찍기 - 10 미완 210405
		// 참고 https://st-lab.tistory.com/95
		// 재귀 사용해야 함 - 가운데만 공백 
		// ex) n = 3 일때, arr[1][1]만 공백
		// 전체에서 세부로 쪼개면서 재귀호출
		// n=27인 경우 한 블록의 사이즈는 9/ n=9일 경우 한 블록의 사이즈는 3
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		arr = new char[n][n];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		starAction(n, 0, 0);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
