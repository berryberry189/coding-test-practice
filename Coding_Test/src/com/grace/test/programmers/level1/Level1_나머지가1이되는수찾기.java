package com.grace.test.programmers.level1;

public class Level1_나머지가1이되는수찾기 {
    // https://programmers.co.kr/learn/courses/30/lessons/87389
    public static void main(String[] args) {
        int n = 2;
        System.out.println(solution(n));
    }
    public static int solution(int n) {
        int min = 0;
        for(int i=1; i<n; i++){
            if(n%i == 1){
                min = i;
                break;
            }
        }
        return min;
    }
}
