package com.grace.test.ifp;

import java.util.Scanner;

public class Q2753 {

	public static void main(String[] args) {
		// 윤년
		Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        in.close();

        String result = ( (A%4==0 && A%100!=0)|| A%400==0 ) ? "1" : "0" ;

        System.out.println(result);

	}

}
