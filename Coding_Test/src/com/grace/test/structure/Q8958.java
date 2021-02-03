package com.grace.test.structure;

import java.io.*;
public class Q8958 {
	public static void main(String[] args) throws Exception{
		// OX퀴즈
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			String input = br.readLine();
			int cnt = 0, sum = 0;
			for(int i=0; i<input.length(); i++) {
				char c = input.charAt(i);
				if( c == 'O') {
					cnt += 1;	
				}else {
					cnt = 0;
				}
				sum += cnt;
			}
			bw.write(sum + "\n");
		}
		bw.flush();
	}
}
