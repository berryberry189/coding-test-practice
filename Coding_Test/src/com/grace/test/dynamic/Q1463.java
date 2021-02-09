package com.grace.test.dynamic;

import java.io.*;
public class Q1463 {
	public static int[] d;
	public static int makeOne(int n) {
		if(n == 1) return 0;
		if(d[n] > 0) {
			return d[n]; //메모가 되어있는 경우 메모값 리턴
		}
		d[n] = makeOne(n-1) + 1; // n-1울 1로 만들 수 있는 최소 연산 횟수 + 1(n을 n-1로 만드는 횟수)
		if(n%2 == 0) {
			int temp = makeOne(n/2) + 1;
			// d[n]값과 temp값을 비교하여 temp가 더 작은경우 d[n]값 변경
			if(d[n] > temp) d[n] = temp;
		}
		if(n%3 == 0) {
			int temp = makeOne(n/3) + 1;
			if(d[n] > temp) d[n] = temp;
		}
		return d[n];
	}
	public static void main(String[] args) throws Exception {
		// 1로 만들기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		d = new int[n+1];
		System.out.println(makeOne(n));

	}
}
/**
 public class Main {
    public static int[] d;
    public static int go(int n) {
        if (n == 1) {
            return 0;
        }
        if (d[n] > 0) {
            return d[n];
        }
        d[n] = go(n-1) + 1;
        if (n%2 == 0) {
            int temp = go(n/2)+1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }
        if (n%3 == 0) {
            int temp = go(n/3)+1;
            if (d[n] > temp) {
                d[n] = temp;
            }
        }
        return d[n];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        System.out.println(go(n));
    }
}
---------------------------------------------------
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(recur(N, 0));
	}
	static int recur(int N, int count) {
		if (N < 2) {
			return count;
		}
		return Math.min(recur(N / 2, count + 1 + (N % 2)), recur(N / 3, count + 1 + (N % 3)));
	}
}

 **/
