package com.grace.test.string;

import java.io.*;
public class Q1157 {
	public static void main(String[] args)  throws Exception{
		// 단어 공부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[26];
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(Character.isUpperCase(c) == true){
				arr[c-65] ++;
			}else {
				arr[c-97] ++;
			}
		}
		int max = -1;
		char result = '?';
		for(int i=0; i<26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				result = (char)(i+65);
			}else if(arr[i] == max) {
				result = '?';
			}
		}
		System.out.println(result);
	}
}
