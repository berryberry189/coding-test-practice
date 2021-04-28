package com.grace.test.bruteforce;

import java.io.*;
import java.util.*;

public class Q6603_로또 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			
			int[] arr = new int[k];
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);
			
			
		}
	}
	
}
