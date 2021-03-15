package com.grace.test.goorm;

import java.util.*;

public class QAmusementPark {
	// 수정각,, for문을 4번 중첩하다니,,,, 
	public static final Scanner scanner = new Scanner(System.in);

	public static void testCase(int caseIndex) {
		int N = scanner.nextInt();  // 지도의 크기 
		int K = scanner.nextInt();  // 놀이공원의 크기
		
		int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부 
		for (int r = 0; r < N; r += 1) {
			for (int c = 0; c < N; c += 1) {
				wastes[r][c] = scanner.nextInt();
			}
		}
		
		int answer = Integer.MAX_VALUE;
		int num=1;
		for(int x=0; x<=N-K; x++) {
			for(int y=0; y<=N-K; y++) {
				int cnt = 0;
				System.out.println(num + "회" );
				num++;
				for(int i=x; i<x+K; i++){
					for(int j=y; j<y+K; j++){
						System.out.println("wastes["+i+"]["+j+"] : " + wastes[i][j]);
						if( wastes[i][j] == 1 ) cnt++;
					}
				}
				
				if(answer > cnt) answer = cnt;
				System.out.println("cnt ---> " + cnt);
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws Exception {
		// https://level.goorm.io/exam/88520/%EB%86%80%EC%9D%B4%EA%B3%B5%EC%9B%90/quiz/1
		int caseSize = scanner.nextInt();
		
		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
		
	}
}
