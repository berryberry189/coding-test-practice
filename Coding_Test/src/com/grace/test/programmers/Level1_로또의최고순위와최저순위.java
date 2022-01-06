package com.grace.test.programmers;

import java.util.Arrays;

public class Level1_로또의최고순위와최저순위 {

    // https://programmers.co.kr/learn/courses/30/lessons/77484
    // 1등 6개 번호가 모두 일치
    // 2등 5개 번호가 일치
    // 3등 4개 번호가 일치
    // 4등 3개 번호가 일치
    // 5등 2개 번호가 일치
    // 6등(낙첨)	그 외

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(solution(lottos, win_nums));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {

        int collectCnt = 0;
        for (int lotto : lottos) {
            for (int win_num : win_nums) {
                if(lotto == win_num) collectCnt ++;
            }
        }
        long zeroCnt = Arrays.stream(lottos)
                .filter(x -> x == 0)
                .count();

        int max = collectCnt + Long.valueOf(zeroCnt).intValue();
        max = (max== 0) ? 6 : 7-max;
        int min = (collectCnt == 0) ? 6 : 7-collectCnt;

        int[] answer = {max, min};

        return answer;
    }

}
