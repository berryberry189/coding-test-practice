package com.grace.test.string;

import java.io.*;
public class Q10809 {
	public static void main(String[] args) throws Exception{
		// 알파벳 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] arr = new int[26];
		for(int i=0; i<arr.length; i++) {
			arr[i] = -1;
		}
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if(arr[c -'a'] == -1) { // a = 97
				arr[c -'a'] = i;
			}
		}
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}
}
