package com.grace.test.inflearn.hash_map_tree_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Section4_HashMap {

  public static void main(String[] args) {
    // Q1. 학급 회장(해쉬)
    System.out.println("Q1. 학급 회장(해쉬) : " + solution1(15,  "BACBACCACCBDEDE"));

    // Q2. 아나그램(해쉬)
    System.out.println("Q2. 아나그램(해쉬) 1 : " + solution2("AbaAeCe",  "baeeACA"));
    System.out.println("Q2. 아나그램(해쉬) 2 : " + solution2("abaCC",  "Caaab"));

    // Q3. 매출액의 종류
    System.out.println("Q3. 매출액의 종류 : " +
        solution3(7, 4, new int[]{20, 12, 20, 10, 23, 17, 10}));

    // Q4. 모든 아나그램 찾기
    System.out.println("Q4. 모든 아나그램 찾기 : " + solution4("bacaAacba",  "abc"));

  }

  private static Character solution1(int N, String str) {
    HashMap<Character, Integer> map = new HashMap<>();
    char answer = 0;

    for(char c: str.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0)+1);
    }

    int max = Integer.MIN_VALUE;
    for(char key : map.keySet()) {
      if(max < map.get(key)) {
        max = map.get(key);
        answer = key;
      }
    }

    return answer;
  }

  private static String solution2(String str1, String str2) {
    String answer = "YES";
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();

    if(str1.length() != str2.length()) return "NO";

    for(int i=0; i<str1.length(); i++) {
      map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0)+1);
      map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0)+1);
    }

    for(char key : map1.keySet()) {
      if(map1.get(key) != map2.get(key)) return "NO";

    }

    return answer;
  }

  private static List<Integer> solution3(int N, int K, int[] arr) {
    List<Integer> answerList = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<K-1; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
    }
    int lt = 0;
    for(int rt=K-1; rt<N; rt++) {
      map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
      answerList.add(map.size());
      map.put(arr[lt],  map.getOrDefault(arr[lt], 0)-1);
      if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
      lt++;
    }

    return answerList;
  }

  private static int solution4(String str1, String str2) {
    int answer = 0;
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    for(char c : str2.toCharArray()) {
      map2.put(c, map2.getOrDefault(c, 0)+1);
    }

    int len = str2.length();
    for(int i=0; i<len-1; i++) {
      map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0)+1);
    }
    int lt = 0;
    for(int rt=len-1; rt<str1.length(); rt++) {
      map1.put(str1.charAt(rt), map1.getOrDefault(str1.charAt(rt), 0)+1);
      if(map1.equals(map2)) answer++;
      map1.put(str1.charAt(lt), map1.getOrDefault(str1.charAt(lt), 0)-1);
      if(map1.get(str1.charAt(lt)) == 0) map1.remove(str1.charAt(lt));
      lt++;
    }

    return answer;
  }


}
