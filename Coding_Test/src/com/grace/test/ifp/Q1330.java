package com.grace.test.ifp;

import java.util.Scanner;

public class Q1330 {

	public static void main(String[] args) {
		// 두 수 비교하기
		Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        int B = in.nextInt();

        in.close();

        String result = A > B ? ">" : ( A < B ? "<" : "==");
        
        System.out.println(result);

	}

}
