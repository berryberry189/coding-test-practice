package com.grace.test.codility.lesson2;

import java.util.HashSet;

public class Lesson2_OddOccurrencesInArray {

  public static void main(String[] args) {

    System.out.println("test = " + solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
    System.out.println("test = " + solution(new int[]{5, 5, 7, 7, 8}));

  }

  static int solution(int[] A) {
    HashSet<Integer> set = new HashSet<>();
    for(int i=0; i<A.length; i++) {
      if(set.contains(A[i])){
        set.remove(A[i]);
      } else {
        set.add(A[i]);
      }
    }
    return set.stream().iterator().next();
  }

}
