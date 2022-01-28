package com.grace.test.programmers;


import java.util.ArrayList;
import java.util.List;

public class Level1_실패율 {

    // https://programmers.co.kr/learn/courses/30/lessons/42889

    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = solution(n, stages);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double userCnt = stages.length;
        List<double[]> failRateList = new ArrayList<>();
        int cnt = 0;
        for(int i=1; i<=N; i++){
            for (int j=0; j<stages.length; j++){
                if(i == stages[j]) cnt++;
            }
            if(cnt == 0){
                failRateList.add(new double[]{i, 0});
                continue;
            }
            failRateList.add(new double[]{i, cnt/userCnt});
            userCnt -= cnt;
            cnt = 0;
        }

        failRateList.sort((a,b)->Double.compare(b[1],a[1]));

        for(int i=0;i<failRateList.size();i++){
            answer[i]=(int)failRateList.get(i)[0];
        }

        return answer;
    }
}
