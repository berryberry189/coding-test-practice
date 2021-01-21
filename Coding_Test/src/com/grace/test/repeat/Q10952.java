package com.grace.test.repeat;

import java.io.*;
import java.util.*;
public class Q10952 {

	public static void main(String[] args) throws IOException {
		// A+B - 5
		// 입력의 마지막에 0 0 이 들어오는 경우
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean bool = true;
        StringBuilder sb = new StringBuilder();
        while(bool){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0){
                bool = false;
            }else{
                sb.append( A + B ).append("\n");
            }
        }
        System.out.println(sb.toString());

	}

}
