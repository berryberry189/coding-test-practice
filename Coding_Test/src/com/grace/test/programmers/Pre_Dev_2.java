package com.grace.test.programmers;

public class Pre_Dev_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 6;
		int columns = 6; 
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int n = queries.length;
		int[] answer = new int[n];
		int min = 0;
		
		int[][] d = new int[rows][columns];		
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=columns; j++) {
				d[i][j] = rows*(i-1) + j;
			}
		}
		int num1, num2, num3, num4;
		for(int i=0; i<n; i++) {
			num1 = queries[i][0]; // x
			num2 = queries[i][1]; // y
			num3 = queries[i][2]; // x
			num4 = queries[i][3]; // y
			
			// 오른쪽 옆
			int temp = 0, temp2=0;
			
			for(int x=num2; x<=num4; x++) {
				temp = d[num1][x+1];
				if(x < num2) d[num1][x+1] = d[num1][x];
			}
			
			// 아래
			for(int x=num1; x<=num3; x++) {
				temp2 = d[x+1][num4];
				if(x < num3) {
					d[x+1][num4] = temp;
				}
			}
			
			// 왼쪽
			for(int x=num4; x>=num2; x--) {
				temp = d[num3][x-1];
				if(x > num2) d[num3][x-1] = temp;
			}
			
			// 위
			
			
			
			answer[i] = min;
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(answer[i]);
		}
		
	}


}
