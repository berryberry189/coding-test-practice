package com.grace.test.programmers;

public class Level1_모의고사 {

    // https://programmers.co.kr/learn/courses/30/lessons/12977
    // 3개의 수를 더했을 때 소수가 되는 경우의 개수

    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        int[] result = solution(answers);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{2,1,2,3,2,4,2,5};
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5};

        int[] score = new int[3];

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a[i%5])
                score[0]++;
            if(answers[i] == b[i%8])
                score[1]++;
            if(answers[i] == c[i%10])
                score[2]++;
        }
        // 가장 높은 점수
        int max = 0;
        for(int i=0; i<3; i++){
            if(score[i] > max){ max = score[i]; }
        }

        // 가장 높은 점수를 받은 사람 수
        int maxCount = 0;
        for(int i=0; i<3; i++){
            if(score[i] == max){ maxCount++; }
        }

        answer = new int[maxCount];
        int idx = 0;
        for(int i=0; i<3; i++){
            if(score[i] == max) answer[idx++] = i+1;
        }
        return answer;
    }

}
