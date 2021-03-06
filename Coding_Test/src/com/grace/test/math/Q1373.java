package com.grace.test.math;

import java.io.*;
public class Q1373 {
	public static void main(String[] args) throws Exception{
		// 2진수 8진수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		int cnt = 0, sum = 0;
		int len = input.length();
		if(len%3 == 1) {
			input = "00"+input;
		}else if(len%3 == 2) {
			input = "0"+input;
		}
		char[] charArr = input.toCharArray();
		for(int i=0; i<charArr.length; i++) {
			if(cnt == 3) {
				sb.append(sum); cnt = 0; sum = 0;
			}
			sum += (charArr[i]-'0') * Math.pow(2, 2-cnt);
			cnt++;
			if( i == input.length()-1) sb.append(sum);
		}
		System.out.println(sb);
	}
}
/** +)
 * public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        if (n%3 == 1) {
            System.out.print(s.charAt(0));
        } else if (n%3 == 2) {
            System.out.print((s.charAt(0)-'0')*2 + (s.charAt(1)-'0'));
        }
        for (int i=n%3; i<n; i+=3) {
            System.out.print((s.charAt(i)-'0')*4 + (s.charAt(i+1)-'0')*2 + (s.charAt(i+2)-'0'));
        }
        System.out.println();
    }
 */
