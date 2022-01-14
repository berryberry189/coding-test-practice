package com.grace.test.programmers;

public class Level1_내적 {

    // https://programmers.co.kr/learn/courses/30/lessons/70128

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        System.out.println(solution(a, b));
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i<a.length; i++){
            answer += a[i] * b[i];
        }

        return answer;
    }

}
