package com.grace.test.programmers;

public class Q신규아이디추천 {
	// https://programmers.co.kr/learn/courses/30/lessons/72410
	// 아이디 길이 : 3~15 
	// 알파벳, 숫자, - , _ , . 문자만 사용가능
	// . 는 처음과 끝에 사용 불가, 연속으로 사용 불가
	
	// 정규식 참고 : https://codechacha.com/ko/java-regex/
	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase(); // 소문자
        answer = answer.replaceAll("[^a-z0-9-_.]", ""); // 영소문자-_.만
        answer = answer.replaceAll("[.]{2,}", ".");  // .2개 이상 1개로
        answer = answer.replaceAll("^[.]|[.]$", ""); // 처음과 끝의 . 삭제
        
        if(answer.length() == 0) {
        	answer = "a";
        }
        if(answer.length() >= 16) {
        	answer = answer.substring(0,15);
        	answer = answer.replaceAll("^[.]|[.]$", "");
        }
        if(answer.length() <= 2) {
        	int len = answer.length();
        	for(int i=0; i<3-len; i++) {
        		answer += answer.charAt(len-1);
        	}
        }
        
        return answer;
    }

}
