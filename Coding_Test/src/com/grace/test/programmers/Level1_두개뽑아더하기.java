package com.grace.test.programmers;

import java.util.ArrayList;

public class Level1_두개뽑아더하기 {

    // https://programmers.co.kr/learn/courses/30/lessons/68644

    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        int[] result = solution(numbers);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> sumArr = new ArrayList<>();

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                sumArr.add(numbers[i]+numbers[j]);
            }
        }

        answer = sumArr.stream()
                .distinct()
                .sorted()
                .mapToInt(i->i).toArray();

        return answer;
    }

}
