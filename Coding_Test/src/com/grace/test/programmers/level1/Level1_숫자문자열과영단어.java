package com.grace.test.programmers.level1;

public class Level1_숫자문자열과영단어 {

    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }

    public static int solution(String s) {

        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<arr.length; i++){
            if(s.contains(arr[i])){
                s = s.replace(arr[i], String.valueOf(i));
            }
        }

        int answer = Integer.parseInt(s);

        return answer;
    }
}
