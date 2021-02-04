package com.grace.test.structure;

import java.io.*;
public class Q4344 {
	public static void main(String[] args) throws Exception {
		// 평균은 넘겠지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		while( N--> 0) {
			String[] arr = br.readLine().split(" ");
			double cnt = Double.parseDouble(arr[0]);
			double sum=0, num=0, avg=0, per=0;
			for(int i=1; i<cnt+1; i++) {
				sum += Double.parseDouble(arr[i]);
			}
			avg = sum/cnt;
			for(int i=1; i<cnt+1; i++) {
				if(Double.parseDouble(arr[i]) > avg) num += 1; 
			}
			per = num/cnt * 100;
			bw.write(String.format("%.3f", per) + "%\n");
		}
		bw.flush();
	}
}
