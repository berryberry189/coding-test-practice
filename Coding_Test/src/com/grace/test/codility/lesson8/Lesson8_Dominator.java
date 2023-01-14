package com.grace.test.codility.lesson8;

import java.util.HashMap;

public class Lesson8_Dominator {

  public static void main(String[] args) {

    System.out.println("Dominator : " + solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));

  }

  private static int solution(int[] A) {
    int answer = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<A.length; i++) {
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    }

    int maxKey = 0;
    int max = Integer.MIN_VALUE;

    for(int key : map.keySet()) {
      if(max < map.get(key)) {
        max = map.get(key);
        maxKey = key;
      }
    }

    if(max <= A.length / 2) {
      return -1;
    }

    for(int i=0; i<A.length; i++) {
      if(A[i] == maxKey) {
        answer = i;
        break;
      }
    }

    return answer;
  }

}
