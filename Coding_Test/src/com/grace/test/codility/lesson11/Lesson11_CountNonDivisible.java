package com.grace.test.codility.lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson11_CountNonDivisible {

  public static void main(String[] args) {

  }

  private static int[] solution(int[] A) {

    int[] answerArr = new int[A.length];
    Map<Integer, List<Integer>> map = new HashMap<>();
    for(int i=0; i<A.length; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      for(int j=1; j*j<=A[i]; j++) {
        if(A[i] % j == 0) {
          list.add(j);
          if(j*j < A[i]){
            list.add(A[i]/j);
          }
        }
      }
      map.put(i, list);
    }
    return answerArr;

  }

}
