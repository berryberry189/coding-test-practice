package com.grace.test.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Level1_신고결과받기 {

    // https://programmers.co.kr/learn/courses/30/lessons/92334

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] answer = solution(id_list, report ,k);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        // 신고한 회원 배열
        ArrayList<ArrayList<String>> reports = new ArrayList<>();
        // 신고한 회원 중 정지된 회원 배열 => 알림 받는 횟수
        ArrayList<String> stopUsers = new ArrayList<>();

        for (String id : id_list) {
            int count = 0;
            ArrayList<String> myReports = new ArrayList<>();
            for (String r : reportSet) {
                String[] arr = r.split(" ");
                if(id.equals(arr[0])){
                    myReports.add(arr[1]);
                }
                if(id.equals(arr[1])){
                    count ++;
                }
            }
            reports.add(myReports);
            if(count >= k){
                stopUsers.add(id);
            }
        }

        for(int i=0; i<reports.size(); i++){
            int count = 0;
            for (String user : stopUsers) {
                for (String s : reports.get(i)) {
                    if(s.equals(user)){
                        count++;
                    }
                }
            }
            answer[i] = count;
        }
        return answer;
    }

}
