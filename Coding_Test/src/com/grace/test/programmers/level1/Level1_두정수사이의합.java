package com.grace.test.programmers.level1;

public class Level1_두정수사이의합 {
    // https://programmers.co.kr/learn/courses/30/lessons/12912
    public static void main(String[] args) {
        int a = 3; int b = 3;
        System.out.println(solution(a, b));
    }
    public static long solution(int a, int b) {
        long answer = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        for(int i=min; i<=max; i++){
            answer += i;
        }
        return answer;
    }
}
