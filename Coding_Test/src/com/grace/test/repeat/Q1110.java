package com.grace.test.repeat;

import java.io.*;

public class Q1110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 더하기 사이클
		/**
		 26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
		 위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
		 N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int copy = N;
        int cnt = 0;
        
        while(true){
            N = ((N%10))*10 + (((N/10)+(N%10))%10);
            cnt++;
            if(copy == N) break;
        }
        System.out.print(cnt);

	}

}
