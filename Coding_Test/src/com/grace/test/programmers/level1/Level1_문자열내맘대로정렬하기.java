package com.grace.test.programmers.level1;

import java.util.*;

public class Level1_문자열내맘대로정렬하기 {
    // https://programmers.co.kr/learn/courses/30/lessons/12915
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"}; int n = 1;
        String[] resultArr = solution(strings, n);
        for (String s : resultArr) {
            System.out.println(s);
        }
    }
    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> tempArr = new ArrayList<>();
        for (String str : strings) {
            tempArr.add(str.charAt(n) + str);
        }
        Collections.sort(tempArr);
        for (int i=0; i<tempArr.size(); i++) {
            answer[i] = tempArr.get(i).substring(1);
        }
        return answer;
    }
}
