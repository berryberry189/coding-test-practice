package com.grace.test.programmers.level1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Level1_2016 {
    // https://programmers.co.kr/learn/courses/30/lessons/12901

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b){
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.toString().substring(0, 3);
    }
}
