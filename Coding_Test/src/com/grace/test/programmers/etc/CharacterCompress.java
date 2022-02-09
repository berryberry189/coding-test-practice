package com.grace.test.programmers.etc;

import java.io.*;

public class CharacterCompress {
	public static void main(String[] args) throws Exception {
		// https://programmers.co.kr/learn/courses/30/lessons/60057
		// 문자열 압축
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int answer = solution(str);
		System.out.println(answer);
	}
	
	public static int solution(String str) {
		int answer = str.length();
		for(int i=1; i<=str.length()/2; i++) {
			StringBuilder sb = new StringBuilder(); // 압축된 문자열 저장
			int left = 0;       // 왼쪽구간
			int right = left+i; // 오른쪽구간
			int cnt = 1;        // 현재 중복 문자열 갯수
			String s1 = str.substring(left, left+i); // left부터 i까지의 문자열
			sb.append(s1);
			
			// 오른쪽 구간 검사 값이 전체 문자열의 길이보다 작거나 같아야함
			while(right + i <= str.length()) { 
				String s2 = str.substring(right, right+i);
				if(!s1.equals(s2)) { // 기준문자열과 검사 문자열이 같지 않을 때
					left = right;
					s1 = s2;
					if(cnt > 1) sb.insert(sb.length()-i, cnt);
					sb.append(s1);
					cnt = 1;
				}else { // 같을 때
					cnt ++;
				}
				right += i;
			}
			
			if(cnt > 1) sb.insert(sb.length()-i, cnt);
			sb.append(str.substring(right));
			answer = Math.min(sb.length(), answer);
		}
		return answer;
	}
	
	
}
