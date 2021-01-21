package com.grace.test.repeat;

import java.io.*;
import java.util.*;
public class Q15552 {

	public static void main(String[] args) throws IOException {
		// 빠른 A+B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb =  new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            sb.append(result+"\n");
        }
        br.close();
        System.out.println(sb);

	}

}
