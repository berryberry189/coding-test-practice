package com.grace.test.codility;

import java.util.HashSet;
import java.util.Set;

public class Lesson4_MissingInteger {

  public static void main(String[] args) {

    System.out.println("MissingInteger1 : " + solution(new int[]{1, 3, 6, 4, 1, 2}));
    System.out.println("MissingInteger2 : " + solution(new int[]{1, 2, 3}));
    System.out.println("MissingInteger3 : " + solution(new int[]{-1, -3}));

  }

  private static int solution(int[] A) {
    Set<Integer> set = new HashSet<Integer>();
    int answer = 0;
    for(int i=0; i<A.length; i++) {
      if(A[i] > 0) {
        set.add(A[i]);
      }
    }

    for (int i = 1; i <= set.size() + 1; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }

    return 1;

  }

}
