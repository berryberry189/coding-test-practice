package com.grace.test.codility.lesson3;

import java.util.Arrays;

public class Lesson3_TapeEquilibrium {

  // https://app.codility.com/c/run/training6PTEGT-49Z/

  public static void main(String[] args) {
    System.out.println("test = " + solution(new int[]{3,1,2,4,3}));
  }

  static  int solution(int[] A) {
    int len = A.length;
    int sum = Arrays.stream(A).sum();
    int left = 0;
    int min = Integer.MAX_VALUE;
    for(int i=0; i<len; i++) {
      left += A[i];
      min = Math.min(min, Math.abs(left - (sum - left)));
    }
    return min;
  }

}
