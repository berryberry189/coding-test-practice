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
