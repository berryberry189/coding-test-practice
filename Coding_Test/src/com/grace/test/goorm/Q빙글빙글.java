package com.grace.test.goorm;

import java.io.*;

public class Q빙글빙글 {
	public static void main(String[] args) throws Exception{
		// 빙글빙글 달팽이배열
		// https://level.goorm.io/exam/60331/%EB%B9%99%EA%B8%80%EB%B9%99%EA%B8%80-1/quiz/1
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int num = 0;
		int x=0, y=0, width = n, height = n-1;
		
		
		System.out.println();
		
	}
}
/**
# # # # # # # # # # # 
					# 
# # # # # # # # #   # 
#               #   # 
#   # # # # #   #   # 
#   #       #   #   # 
#   #   # # #   #   # 
#   #           #   # 
#   # # # # # # #   # 
#                   # 
# # # # # # # # # # # 
**/