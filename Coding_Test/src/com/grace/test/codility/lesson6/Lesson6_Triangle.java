package com.grace.test.codility.lesson6;

import java.util.Arrays;

public class Lesson6_Triangle {

  public static void main(String[] args) {

    System.out.println("Triangle : " + solution(new int[]{10, 2, 5, 1, 8, 20}));

  }

  private static int solution(int[] A) {
    // 1, 2, 5, 8, 10, 20
    Arrays.sort(A);
    if(A.length < 3) return 0;
    for(int i=2; i< A.length; i++) {
      if(A[i] < A[i-2] + A[i-1]) return 1;
    }
    return 0;
  }

}
