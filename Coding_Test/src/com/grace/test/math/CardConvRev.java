package com.grace.test.math;

public class CardConvRev {

	public static void main(String[] args) {
		// 진수 변환
		char[] d = new char[10];
		int num = cardConvR(5,2, d);
		System.out.println(num);
	}
	// 입력받은 10진수를 2~36진수로 기수 변환하여 나타냄
	static int cardConvR(int x, int r, char[] d) {
		// 정숫값 x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어두고 자릿수를 반환한다.
		int digits = 0;  // 변환 후의 자릿수
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[digits++] = dchar.charAt(x % r); // r로 나눈 나머지를 저장
			x /= r;
		}while(x != 0);
		return digits; // 역순으로 배치되어 저장됨
		
	}

}
