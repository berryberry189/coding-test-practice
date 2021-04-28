package com.grace.test.bruteforce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1759_암호만들기 {
	// 완벽한 이해 X
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[c];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		
		for(int i=0; i<c; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		go(l, arr, "", 0);
	}
	
	private static boolean check(String pw) {
		// 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
		int ja = 0; int mo = 0;
		String[] strArr = pw.split("");
		
		for(int i=0; i<strArr.length; i++) {
			String s = strArr[i];
			if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("u") || s.equals("u") ) {
				mo++;
			}else {
				ja++;
			}
		}
		
		return ja >= 2 && mo >= 1;
	}
	
	private static void go(int l, String[] arr, String pw, int idx) {
		//System.out.println(idx+"번째 pw ----> " + pw);
		if(pw.length() == l) {
			if(check(pw)) {
				System.out.println(pw);
				System.out.println("------------------------------");
			}
			return;
		}
		
		if(idx >= arr.length) return;
		
		System.out.println("상 : go("+l+", arr,"+ pw + arr[idx]+","+ (idx+1) +");");
		go(l, arr, pw + arr[idx], idx+1);
		System.out.println("하: go("+l+", arr,"+ pw +","+ (idx+1) +");");
		go(l, arr, pw, idx+1);
		
	}

}
