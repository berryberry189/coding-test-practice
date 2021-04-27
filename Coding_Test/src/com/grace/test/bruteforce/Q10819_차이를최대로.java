package com.grace.test.bruteforce;

import java.io.*;
import java.util.*;

public class Q10819_차이를최대로 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int max = 0;
		do {
			max = Math.max(max, cal(arr));
		}while(next_permutation(arr));
		System.out.println(max);
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
	
	private static int cal(int[] arr) {
		int sum = 0;
		for(int i=1; i<arr.length; i++) {
			sum += Math.abs(arr[i]-arr[i-1]);
		}
		return sum;
	}
}
