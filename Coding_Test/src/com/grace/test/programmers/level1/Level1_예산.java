package com.grace.test.programmers.level1;

import java.util.Arrays;

public class Level1_예산 {

    // https://programmers.co.kr/learn/courses/30/lessons/12982

    public static void main(String[] args) {
        int[] d = {2,2,3,3};
        int budget = 10;
        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;
        for (int i : d) {
            sum += i;
            if(sum <= budget){
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }

}
