package com.grace.test.repeat;

import java.io.*;

public class Q2439 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 별찍기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            for(int j=0; j < N-i; j++){
                System.out.print(' ');
            }
            for(int k=0; k < i; k++){
                System.out.print('*');
            }
            System.out.println();
        }

	}

}
