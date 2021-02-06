package com.grace.test.math;

import java.io.*;
public class Q1212 {
	public static void main(String[] args) throws Exception{
		// 8진수 2진수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr = br.readLine().split("");
		for(int i=0; i<arr.length; i++) {
			int num = Integer.parseInt(arr[i]);
			if(i ==0 && num == 0) {
				sb.append(num); break;
			}
			sb.append(num/4==1? 1 : 0); num = num%4;
			sb.append(num/2==1? 1 : 0); num = num%2;
			sb.append(num==1? 1 : 0);
			if(i==0 && Integer.parseInt(arr[i])<=3) {
				sb.deleteCharAt(0);
				if(Integer.parseInt(arr[i]) == 1) sb.deleteCharAt(0);
			}
		}
		System.out.println(sb);
	}
}

/** +)
 * public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] eight = {"000","001","010","011","100","101","110","111"};
        String s = sc.nextLine();
        boolean start = true;
        if (s.length() == 1 && s.charAt(0) == '0') {
            System.out.print(0);
        }
        for (int i=0; i<s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (start == true && n < 4) {
                if (n == 0) {
                    continue;
                } else if (n == 1) {
                    System.out.print("1");
                } else if (n == 2) {
                    System.out.print("10");
                } else if (n == 3) {
                    System.out.print("11");
                }
                start = false;
            } else {
                System.out.print(eight[n]);
                start = false;
            }
        }
        System.out.println();
    }
 */
