package com.grace.test.programmers.level1;

public class Level1_최소직사각형 {
    // https://programmers.co.kr/learn/courses/30/lessons/86491

    public static void main(String[] args) {

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int maxLen = 0;
        int minMaxLen = 0;
        for (int[] size : sizes) {
            if(size[0] >= size[1] ){
                if(maxLen < size[0])  maxLen = size[0];
                if(minMaxLen < size[1])  minMaxLen = size[1];
            }else{
                if(maxLen < size[1])  maxLen = size[1];
                if(minMaxLen < size[0])  minMaxLen = size[0];
            }
        }
        return maxLen * minMaxLen;
    }
}
