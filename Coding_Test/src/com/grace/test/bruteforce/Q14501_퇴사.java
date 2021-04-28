package com.grace.test.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Q14501_퇴사 {
	static int n, max=0;
	static int[] t,p;
	public static void main(String[] args) throws Exception{
		// 각 날짜별 경위수가 2개 있다고 생각하면 됨 ( 1. 상담을 하는경우 2. 상담을 안하는 경우)
		// 대전제 
		// 1) 정담을 찾은 경우 day == n+1
		// 2) 불가능한 경우 : 상담 후 날짜가 퇴사일을 넘어가는 경우 day > n+1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 퇴사까지 남은 날짜
		t = new int[n+1]; p = new int[n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken()); // 상담을 완료하는데 걸리는 시간
			p[i] = Integer.parseInt(st.nextToken()); // 상담 페이
		}
		go(1, 0);
		System.out.println(max);
	}
	
	private static void go(int day, int sum) {
		if(day > n+1) return;
		if(day == n+1) {
			if(max < sum) max = sum;
			return;
		}
		// 경우의 수 2개
		// 1.상담 안하는 경우
		go(day+1, sum);
		// 2.상담 하는 경우
		go(day + t[day], sum + p[day]);
			
	}
}
