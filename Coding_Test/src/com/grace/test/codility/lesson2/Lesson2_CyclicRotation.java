package com.grace.test.codility.lesson2;

import java.util.Arrays;

public class Lesson2_CyclicRotation {

  // https://app.codility.com/c/run/trainingYE2FMB-RKA/

  public static void main(String[] args) {

    System.out.println("test  A = [3, 8, 9, 7, 6], K = 3 ->"
        + Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));

    System.out.println("test  A = [0, 0, 0], K = 1->"
        + Arrays.toString(solution(new int[]{0, 0, 0}, 1)));

    System.out.println("test  A = [1, 2, 3, 4], K = 4->"
        + Arrays.toString(solution(new int[]{1, 2, 3, 4}, 4)));

  }

  static int[] solution(int[] A, int K) {

    int len = A.length;
    int[] resultArr = new int[len];

    for(int i=0; i<len; i++) {
        resultArr[(i+K) % len] = A[i];
    }
    return resultArr;
  }

}
