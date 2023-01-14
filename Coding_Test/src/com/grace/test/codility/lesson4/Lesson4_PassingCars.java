package com.grace.test.codility.lesson4;

public class Lesson4_PassingCars {
  // https://app.codility.com/c/run/trainingYG62WZ-S6A/

  public static void main(String[] args) {

    System.out.println("test = " + solution(new int[]{0, 1, 0, 1, 1}));

  }

  static int solution(int[] A) {
    int zeroCount = 0;
    long count = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) zeroCount++;
      else {
        count += zeroCount;
      }
    }

    return count > 1000000000 ? -1 : (int) count;

  }

}
