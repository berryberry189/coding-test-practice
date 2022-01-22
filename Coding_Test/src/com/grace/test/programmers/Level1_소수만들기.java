package com.grace.test.programmers;

public class Level1_소수만들기 {

    // https://programmers.co.kr/learn/courses/30/lessons/12977
    // 3개의 수를 더했을 때 소수가 되는 경우의 개수

    public static void main(String[] args) {
        // int[] nums = {1,2,3,4};
        int[] nums = {1,2,7,6,4};

        // 1 2 3 4
        // 123 124 134 234

        // 1 2 3 4 5
        // 123 124 125 134 135 145 234 235 245 345
        System.out.println("result : " + solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;

        for(int i = 0; i < length; i++) {
            for(int j = i+1; j < length; j++) {
                for(int k = j+1; k < length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) answer++;
                }
            }
        }
        return answer;
    }

    private static boolean isPrime(int sum) {
        for(int i = 2; i < sum; i++)
            if(sum % i == 0) return false;
        return sum > 1;
    }
}
