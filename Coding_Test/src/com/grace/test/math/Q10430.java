package com.grace.test.math;

import java.io.*;
public class Q10430 {
	public static void main(String[] args) throws Exception {
		// 나머지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = br.readLine().split(" ");
		int A = Integer.parseInt(arr[0]);
		int B = Integer.parseInt(arr[1]);
		int C = Integer.parseInt(arr[2]);
		
		bw.write((A+B)%C +"\n");
		bw.write(((A%C) + (B%C))%C +"\n");
		bw.write((A*B)%C +"\n");
		bw.write(((A%C) * (B%C))%C +"\n");
		bw.flush();
	}
}
