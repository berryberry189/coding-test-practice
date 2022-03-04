package com.grace.test.programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class Level1_문자열내림차순으로배치하기 {
    // https://programmers.co.kr/learn/courses/30/lessons/12917

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String str) {
        StringBuilder answer = new StringBuilder();
        String[] arr = str.split("");
        Arrays.sort(arr,Collections.reverseOrder());
        for (String s : arr) {
            answer.append(s);
        }
        return answer.toString();
    }
}
