package com.grace.test.repeat;

import java.io.*;
import java.util.*;
public class Q11021 {

	public static void main(String[] args) throws IOException {
		// 빠른 A+B-7
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         int T = Integer.parseInt(br.readLine());
         StringTokenizer st;
       
         for(int i = 1; i <= T; i++){
             st = new StringTokenizer(br.readLine(), " ");
             int result = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
             bw.write("Case #"+i+ ": "+result+"\n");
         }
         br.close();
	     bw.flush();
         bw.close();

	}

}
