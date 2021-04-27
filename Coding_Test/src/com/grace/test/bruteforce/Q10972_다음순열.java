package com.grace.test.bruteforce;

import java.io.*;
import java.util.*;

public class Q10972_다음순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(next_permutation(arr)) {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
		}else {
			System.out.println("-1");
		}
	}
	
	// 다음 순열 찾는 메서드
	private static boolean next_permutation(int[] arr) {
		// 배열의 뒤에서 부터 탐색하며, a-1보다 a가 더 큰 경우를 탐색
		int a = arr.length - 1;
		while(a>0 && arr[a-1] >= arr[a]) {
			a--;
		}
		// 마지막 순열인 경우
		if(a<=0) return false;
		
		// System.out.println("a--->" + a);
		
		int b = arr.length - 1;
		while(arr[b] <= arr[a-1]) {
			b--;
		}
		// System.out.println("b--->" + b);
		swap(arr, a-1, b);
		
		b = arr.length - 1;
		// System.out.println("a--->" + a + "/ b--->" + b);
		// a-1을 기준으로 오른쪽의 순열을 첫순열로 바꿔주기
		while(a < b) {
			swap(arr, a, b);
			a++;
			b--;
		}
		return true;
	}
	
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
