package com.grace.test.programmers;

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
		StringBuilder sb = new StringBuilder();
		int answer = str.length();
		for(int i=1; i<=str.length()/2; i++) {
			int left = 0;
			int right = left+i;
			int cnt = 1;
			String s1 = str.substring(left, left+i);
			sb.append(s1);
			while(right + i <= str.length()) {
				String s2 = str.substring(right, right+i);
				if(!s1.equals(s2)) {
					left = right;
					s1 = s2;
					if(cnt > 1) sb.insert(sb.length()-i, cnt);
					sb.append(s1);
					cnt = 1;
				}else {
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
