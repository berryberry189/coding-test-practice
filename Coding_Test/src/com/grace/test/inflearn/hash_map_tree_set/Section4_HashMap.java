package com.grace.test.inflearn.hash_map_tree_set;

import java.util.HashMap;

public class Section4_HashMap {

  public static void main(String[] args) {
    // Q1. 학급 회장(해쉬)
    System.out.println("Q1. 학급 회장(해쉬) : " + solution1(15,  "BACBACCACCBDEDE"));

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

}
