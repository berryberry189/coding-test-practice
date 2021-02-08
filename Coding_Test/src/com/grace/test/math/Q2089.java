package com.grace.test.math;

import java.io.*;
import java.util.*;
public class Q2089 {
	public static void main(String[] args) throws Exception{
		// -2진수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		if(n == 0) System.out.println(n);
		
		while(n != 0) {
			list.add(Math.abs(n%-2));
			n = (int)Math.ceil((double)n/-2);
		}
		
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i));
		}
	}
}
/**
public class Main {
    public static void go(int n) {
        if (n == 0) {
            return;
        }
        if (n%2 == 0) {
            go(-(n/2));
            System.out.print(0);
        } else {
            if (n > 0) {
                go(-(n/2));
            } else {
                go((-n+1)/2);
            }
            System.out.print(1);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else {
            go(n);
            System.out.println();
        }
    }
}
 **/
