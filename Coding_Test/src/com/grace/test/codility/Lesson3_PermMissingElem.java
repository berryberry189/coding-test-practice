package com.grace.test.codility;

import java.util.Arrays;

public class Lesson3_PermMissingElem {
  // https://app.codility.com/c/run/trainingFP4CY3-Y84/
  public static void main(String[] args) {
    System.out.println("test = " + solution(new int[] {2, 3, 1, 5}));

  }

  static int solution(int[] A) {
    int len = A.length;
    if(len == 0) return 1;
    Arrays.sort(A);
    for(int i=0; i<len; i++) {
      if(A[i] != i+1) {
        return i+1;
      }
    }
    return A[len-1] + 1;
  }

}
