package com.grace.test.io;

import java.io.*;
public class Q439 {
	public static void main(String[] args) throws Exception {
		// 별 찍기 - 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
        	sb.setLength(0);
            for(int j=0; j < N-i; j++){
            	sb.append(' ');
            }
            for(int k=0; k < i; k++){
            	sb.append('*');
            }
            bw.write(sb.toString()+"\n");
        }
        bw.flush();
	}
}
