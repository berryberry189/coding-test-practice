package com.grace.test.structure;

import java.io.*;
import java.util.*;
public class Q3052 {
	public static void main(String[] args) throws Exception{
		// 나머지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Set<Integer> treeSet = new TreeSet<Integer>();
		int num = 10;
		while(num-- > 0) {
			int n = Integer.parseInt(br.readLine());
			treeSet.add(n%42);
		}
		bw.write(treeSet.size() + "\n");
		bw.flush();
	}
}
