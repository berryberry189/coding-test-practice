package com.grace.test.programmers.level1;

public class Level1_약수의개수와덧셈 {

    // https://programmers.co.kr/learn/courses/30/lessons/77884

    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        System.out.println(solution(left, right));
    }

    public static int solution(int left, int right) {
        int answer = 0;
        int cnt = 1;
        for(int i=left; i<=right; i++){
            for(int j=1; j<=i/2; j++){
                if(i%j == 0) cnt++;
            }
            answer += (cnt%2 == 0 ? i : i * -1);
            cnt = 1;
        }
        return answer;
    }

}
