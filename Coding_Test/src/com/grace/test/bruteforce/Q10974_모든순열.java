package com.grace.test.bruteforce;

import java.io.*;

public class Q10974_모든순열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		do {
			for(int i=0; i<n; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}while(next_permutation(arr));
		System.out.println(sb);
	}
	
	private static boolean next_permutation(int[] arr) {
		int a = arr.length - 1;
		while(a>0 && arr[a-1] >= arr[a]) {
			a--;
		}
		
		if(a<=0) return false;
		
		int b = arr.length - 1;
		while(arr[b] <= arr[a-1]) {
			b--;
		}
		swap(arr, a-1, b);
		
		b = arr.length - 1;
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
