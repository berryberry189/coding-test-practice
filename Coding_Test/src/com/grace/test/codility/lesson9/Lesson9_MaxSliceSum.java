package com.grace.test.codility.lesson9;


public class Lesson9_MaxSliceSum {

  public static void main(String[] args) {

    System.out.println("MaxSliceSum : " +
        solution(new int[]{3, 2, -6, 4, 0}));
    System.out.println("MaxSliceSum : " +
        solution(new int[]{3, 2, -1, 4, 0}));

  }

  private static int solution(int[] A) {
    int max = A[0];
    int[] maxArr = new int[A.length];
    maxArr[0] = A[0];
    for(int i=1; i<A.length; i++) {
      maxArr[i] = Math.max(A[i], maxArr[i-1] + A[i]);
      max = Math.max(max, maxArr[i]);
    }
    return max;
  }

}
