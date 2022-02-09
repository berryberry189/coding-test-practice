package com.grace.test.programmers.level1;

import java.util.HashSet;

public class Level1_폰켓몬 {

    // https://programmers.co.kr/learn/courses/30/lessons/1845

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int num = nums.length / 2;

        HashSet<Integer> numsSet = new HashSet<>();
        for (int n : nums) {
            numsSet.add(n);
        }

        if (numsSet.size() > num) {
            answer = num;
        } else {
            answer = numsSet.size();
        }

        return answer;
    }

}
