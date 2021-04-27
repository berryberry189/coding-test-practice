package com.grace.test.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Q10973_이전순열 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(prev_permutation(arr)) {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
		}else {
			System.out.println("-1");
		}

	}
	
	private static boolean prev_permutation(int[] arr) {
		int a = arr.length - 1;
		while(a>0 && arr[a-1] <= arr[a]) {
			a--;
		}
		if (a <= 0)  return false;
		System.out.println("a--->" + a);
		
		int b = arr.length - 1;
		while(arr[b] >= arr[a-1]) {
			b--;
		}
		System.out.println("b--->" + b);
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
