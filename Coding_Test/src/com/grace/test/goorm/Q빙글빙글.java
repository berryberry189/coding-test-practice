package com.grace.test.goorm;

import java.io.*;

public class Q빙글빙글 {
	public static void main(String[] args) throws Exception{
		// 빙글빙글 달팽이배열
		// https://level.goorm.io/exam/60331/%EB%B9%99%EA%B8%80%EB%B9%99%EA%B8%80-1/quiz/1
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[][] arr = new String[n][n];
		int x = 0, cnt = 1, max = n-1;
		while(cnt <= n) {
			// 오른쪽
			for(int i=(x==0? 0 :x-1); i<=max; i++) {
				arr[x][i] = "#";
			}
			cnt++; if(cnt == n+1) break;
			
			// 아래쪽
			for(int i=x; i<=max; i++) {
				arr[i][max] = "#";
			}
			cnt++; if(cnt == n+1) break;
			
			// 왼쪽
			for(int i=max; i>=x; i--) {
				arr[max][i] = "#";
			}
			cnt++; if(cnt == n+1) break;
			
			// 윗쪽
			for(int i=max; i>=x+2; i--) {
				arr[i][x] = "#";
			}
			cnt++; if(cnt == n+1) break;
			x += 2;
			max -= 2;
		}
		
		for(int i = 0; i<arr.length;i++){        
            for(int j =0; j< arr[i].length;j++){
                System.out.print(arr[i][j] == null ? " ": arr[i][j]);                        
            }
            System.out.println();
        }      
		
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