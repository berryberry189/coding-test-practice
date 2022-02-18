package com.grace.test.programmers.level1;

public class Level1_부족한금액계산하기 {
    // https://programmers.co.kr/learn/courses/30/lessons/82612
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution(price, money, count));
    }
    public static long solution(int price, int money, int count) {
        long total = 0;
        for(int i=1; i<= count; i++){
            total += price * i;
        }
        return money > total ? 0 : total - money;
    }
}
