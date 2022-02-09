package com.grace.test.programmers.etc;

public class Dev_2 {
	static int[][] map;
	static int min;
	public static void main(String[] args) {
		// https://programmers.co.kr/learn/courses/30/lessons/77485
		// 참고 https://wellbell.tistory.com/157
		int rows = 6;
		int columns = 6; 
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] answer = new int[queries.length];
		
		map = new int[rows+1][columns+1];
		int num = 1;
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=columns; j++) {
				map[i][j] = num;
				num++;
			}
		}
		for(int i=0; i<queries.length; i++) {
			answer[i] = solve(queries[i]);
			System.out.println(answer[i]);
		}
	}
	
	private static int solve(int[] arr) {
		// 사각형 가로, 세로
		int x = arr[2] - arr[0]; // 세로
		int y = arr[3] - arr[1]; // 가로
		
		// 현재 위치, 현재 값
		int nx = arr[0];
		int ny = arr[1];
		int now = map[nx][ny];
		
		min = now;
		
		// 오른쪽
		for(int i=0; i<y; i++) {
			ny += 1;
			now = moveMap(nx, ny, now);
		}
		
		// 아래
		for(int i=0; i<x; i++) {
			nx += 1;
			now = moveMap(nx, ny, now);
		}
		
		// 왼쪽
		for(int i=0; i<y; i++) {
			ny -= 1;
			now = moveMap(nx, ny, now);
		}
		
		// 위
		for(int i=0; i<x; i++) {
			nx -= 1;
			now = moveMap(nx, ny, now);
		}
		
		return min;
	}
	
	private static int moveMap(int x, int y, int n) {
		// 변경된 좌표값 저장
		int temp = map[x][y];
		// 최소값 초기화
		min = Math.min(min, temp);
		// 이전 지점값을 현재 지점에 넣어줌
		map[x][y] = n;
		// 변경해주기 전 현재지점 값 리턴
		return temp;
	}
}
