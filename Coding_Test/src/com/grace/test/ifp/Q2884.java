package com.grace.test.ifp;

import java.io.*;

public class Q2884 {

	public static void main(String[] args) throws IOException {
		// 알람 시계
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int H = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        H = M<45 ? (H == 0 ? 23 : H-1) : H;
        M = M<45 ? M+15 : M-45;
       
        System.out.println(H + " " + M);
	}

}
