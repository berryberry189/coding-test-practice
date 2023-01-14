package com.grace.test.codility.lesson6;

import java.util.Arrays;

public class Lesson6_MaxProductOfThree {

  public static void main(String[] args) {

    System.out.println("MaxProductOfThree : " + solution(new int[]{-3, 1, 2, -2, 5, 6}));

  }

  private static int solution(int[] A) {
    Arrays.sort(A);
    int max = Integer.MIN_VALUE;
    int len = A.length;

    // 양 * 양 * 양
    max = Math.max(max, A[len-1] * A[len-2] * A[len-3]);
    // if 음 * 음 * 양
    max = Math.max(max, A[0] * A[1] * A[len-1]);
    return max;
  }

}
