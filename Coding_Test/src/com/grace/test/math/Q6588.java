package com.grace.test.math;

import java.io.*;
public class Q6588 {
	public static void main(String[] args) throws Exception {
		// 골드바흐의 추측 -- 다시 봐야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//에라토스테네스의 채
		int max = 1000000;
		boolean[] isPrime = new boolean[max + 1]; // 지워졌으면 true
		isPrime[0] = isPrime[1] = true;
		for(int i=2; i<=max; i++) {
			if(!isPrime[i]) {
				for(int j=i*2; j<max; j+=i) {
					isPrime[j] = true; 
				}
			}
		}
		while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
            	System.out.println(sb);
            	break;
            }
 
            // 모든 소수를 중에서 a+b = num을 만족하는 조합을 찾는다.
            /**
             *골드바흐의 추측
		     *- 2보다 큰 모든 짝수는 두 소수의 합의로 표현 가능하다
			 *- 5보다 큰 모든 홀수는 세 소수의 합으로 표현 가능하다.
             */
            if( num>2 && num%2 == 0) {
            	 for (int i = 3; i <= num; i++) {
                     if (!isPrime[i] && !isPrime[num - i]) {
                         int b = num - i;
                         sb.append(num + " = " + i + " + " + b + "\n");
                         break;
                     }
                 }
            	
            }else {
            	sb.append("Goldbach's conjecture is wrong.\n");
            }
        }
	}
}
