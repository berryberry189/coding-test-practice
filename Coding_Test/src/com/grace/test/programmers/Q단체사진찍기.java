package com.grace.test.programmers;

import java.util.HashMap;

public class Q단체사진찍기 {
	// https://programmers.co.kr/learn/courses/30/lessons/1835
	// 참고 : https://onejunu.tistory.com/92
	
	// 입력은 조건의 개수를 나타내는 정수 n과 n개의 원소로 구성된 문자열 배열 data(다섯 글자로 구성)
	// data 첫 번째 글자와 세 번째 글자는 다음 8개 중 하나이다. {A, C, F, J, M, N, R, T}
	//      두 번째 글자는 항상 ~ / 네 번째 글자는 다음 3개 중 하나이다. {=, <, >}
	//      다섯 번째 글자는 0 이상 6 이하의 정수의 문자형 ( 두 프렌즈 사이에 있는 다른 프렌즈의 수 )
	
	// ex) ["N~F=0", "R~T>2"] 네오는 프로도와의 간격이 0이기를 원하고 라이언은 튜브와의 간격이 2보다 크기를 원하는 상황

	static String d[];
	// 카카오 프렌즈 0~7까지 
	static HashMap<Character, Integer> map;
	// 인덱스 방문 여부 체크
	static boolean[] visited;
	// 카카오 프렌즈가 서는 위치
	static int[] position;
	static int answer;
	
	
	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};

		System.out.println(solution(n, data));
	}
	
	public static int solution(int n, String[] data) {
		d = data;
		map = new HashMap<Character, Integer>();
		visited = new boolean[8];
		position  = new int[8];		
		answer = 0;
		
		map.put('A',0);
		map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        dfs(0);
		
		return answer;	
	}
	
	static void dfs(int v) {
		if(v == 8) { // 8개 순서 전부 결정된 경우
			if(check()) answer++;
		}else {
			for(int i=0; i<8; i++) {

				if(!visited[i]) {
					visited[i] = true;
					position [v] = i;
					dfs(v+1);
					visited[i] = false;
				}
			}
		}		
	}
	
	public static boolean check(){
		int a,b,num;
		char op;
		
		for(String str : d) {
			// 첫번째 글자
			a = position [map.get(str.charAt(0))];
			// 세번째 글자
			b = position [map.get(str.charAt(2))];
			// 부등호 
			op = str.charAt(3);
			num = str.charAt(4) - '0' + 1;
			
			if(op == '=') {
				if(Math.abs(a-b) != num) return false;
			}else if(op == '>') {
				if(Math.abs(a-b) <= num) return false;
			}else {
				if(Math.abs(a-b) >= num) return false;
			}			
		}
		return true;
	}

}
