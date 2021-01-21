package com.grace.test.repeat;

import java.io.*;
import java.util.*;
public class Q10951 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// A+B - 4
		// 종료시점을 명시해주지 않아, 더 이상 읽은 데이터가 없을 때 종료하는 경우
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String str ="";
        while( (str = br.readLine()) != null ){
            st = new StringTokenizer(str, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append( A + B ).append("\n");
        }
        System.out.println(sb.toString());

	}

}
