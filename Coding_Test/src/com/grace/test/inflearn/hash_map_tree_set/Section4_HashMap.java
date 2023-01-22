package com.grace.test.inflearn.hash_map_tree_set;

import java.util.HashMap;

public class Section4_HashMap {

  public static void main(String[] args) {
    // Q1. 학급 회장(해쉬)
    System.out.println("Q1. 학급 회장(해쉬) : " + solution1(15,  "BACBACCACCBDEDE"));

    // Q2. 아나그램(해쉬)
    System.out.println("Q2. 아나그램(해쉬) 1 : " + solution2("AbaAeCe",  "baeeACA"));
    System.out.println("Q2. 아나그램(해쉬) 2 : " + solution2("abaCC",  "Caaab"));

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


}
