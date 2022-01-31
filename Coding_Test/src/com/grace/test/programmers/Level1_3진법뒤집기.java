package com.grace.test.programmers;

public class Level1_3진법뒤집기 {

    // https://programmers.co.kr/learn/courses/30/lessons/68935

    public static void main(String[] args) {
        int n = 125;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        String str = "";
        while(n != 0){
            str += n%3;
            n /= 3;
        }
        String[] arr = str.split("");
        int pow = arr.length - 1;
        for (String s : arr) {
            if(Integer.parseInt(s)!= 0){
                answer += Integer.parseInt(s) * Math.pow(3, pow);
            }
            pow -= 1;
        }
        return answer;
    }

}
