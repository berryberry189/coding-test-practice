package com.grace.test.programmers.level1;


import java.util.ArrayList;
import java.util.List;

public class Level1_같은숫자는싫어 {
    // https://programmers.co.kr/learn/courses/30/lessons/82612
    public static void main(String[] args) {
        int[] arr = {4,4,4,3,3};
        System.out.println(solution(arr));
    }
    public static List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int frontNum = -1;
        for (int i : arr) {
            if(frontNum != i){
                frontNum = i;
                answer.add(i);
            }
        }
        return answer;
    }
}
