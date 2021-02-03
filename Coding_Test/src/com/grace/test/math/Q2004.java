package com.grace.test.math;

import java.io.*;
public class Q2004 {
	public static Long countTwo(Long num) {
		Long cnt=0L;
		for(Long i=2L; i<=num; i*=2) {
			cnt += num/i;
		}
		return cnt;
	}
	public static Long countFive(Long num) {
		Long cnt=0L;
		for(Long i=5L; i<=num; i*=5) {
			cnt += num/i;
		}
		return cnt;
	}
	public static void main(String[] args) throws Exception {
		// 조합 0의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		// m<=n
		Long n = Long.parseLong(arr[0]);
		Long m = Long.parseLong(arr[1]);
		// n! / (m! * (n-m)!) 각자 갯수: n-m-d 
		Long d = n-m;
		Long twoCnt =0L, fiveCnt = 0L;
		twoCnt  = countTwo(n) - countTwo(m) - countTwo(d);
		fiveCnt = countFive(n) - countFive(m) - countFive(d);
		
		System.out.println(twoCnt > fiveCnt ? fiveCnt : twoCnt);
	}
}
