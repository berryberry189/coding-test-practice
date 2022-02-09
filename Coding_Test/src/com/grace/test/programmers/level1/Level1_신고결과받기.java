package com.grace.test.programmers.level1;

import java.util.*;

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

        Map<String, Integer> index = new HashMap<>();
        Map<String, List<Integer>> reportMap = new HashMap<>();

        for(int i=0; i<id_list.length; i++){
            index.put(id_list[i], i);
        }

        for (String r : report) {
            String[] reportArr = r.split(" ");
            String reporter = reportArr[0];
            String target = reportArr[1];

            if(!reportMap.containsKey(target)) reportMap.put(target, new ArrayList<>());
            List<Integer> tmp = reportMap.get(target);
            if(!tmp.contains(index.get(reporter))) tmp.add(index.get(reporter));
        }

        for(int i=0 ; i<id_list.length ; i++) {
            String id = id_list[i];
            if(reportMap.containsKey(id) && reportMap.get(id).size()>=k) {
                for(int idx : reportMap.get(id)) {
                    answer[idx]++;
                }
            }
        }

        return answer;
    }

}
