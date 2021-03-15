package com.grace.test.goorm;

import java.io.*;

public class Q369game {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int cnt = 0;
		int num,mod;
		int n = Integer.parseInt(input);
		for(int i=1; i<n; i++){
			if(i<10){
				if(i%3 == 0) cnt+=1;
			}else{
				num = i;
				while(num > 0){
					mod = num%10;
					if(mod != 0 && mod%3 == 0) cnt+=1;
					num/=10;
				}
			}
		}
		System.out.println(cnt);
	}
}
