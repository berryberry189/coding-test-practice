package com.grace.test.dynamic;

import java.io.*;
import java.util.*;
public class Q11053 {
	public static void main(String[] args) throws Exception{
		// 가장 긴 증가하는 부분 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int[] arr = new int[a]; // 입력받은 수열 
		int[] d = new int[a];   // 해당 숫자의 크기에 따른 index
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<a; i++) {
			d[i] = 1;
			// i의 이전 원소들을 탐색
			for(int j=0; j<i; j++) {     
				if(arr[j]<arr[i] && d[i]<d[j]+1) d[i] = d[j] + 1;
			}
		}
		int max = 0;
		for(int i=0; i<a; i++) {
			if(max < d[i]) max = d[i];
 		}
		System.out.println(max);
	}
}
