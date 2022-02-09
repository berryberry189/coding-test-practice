package com.grace.test.programmers.etc;

public class Pre_Dev_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int win_cnt = 0 , zero_cnt = 0;
		
		for(int i=0; i<6; i++) {
			if(lottos[i] == 0) zero_cnt++;
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(win_nums[i]  == lottos[j]) win_cnt++;
			}
		}
		int min = (win_cnt < 1) ? 7-zero_cnt : 7-(win_cnt+zero_cnt);
        int max = (win_cnt < 1) ? 6 : 7-win_cnt;
		
		System.out.println(min + " / " + max);
		
		

	}

}
