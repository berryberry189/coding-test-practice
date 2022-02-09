package com.grace.test.programmers.level1;

public class Level1_음양더하기 {

    // https://programmers.co.kr/learn/courses/30/lessons/76501

    public static void main(String[] args) {
        int[] absolute = {4,7,12};
        boolean[] signs = {true,false,true};
        System.out.println(solution(absolute, signs));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i< absolutes.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            }else{
                answer += absolutes[i]*-1;
            }
        }

        return answer;
    }
}
