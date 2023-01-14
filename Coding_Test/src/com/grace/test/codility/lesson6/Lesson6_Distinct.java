package com.grace.test.codility.lesson6;

import java.util.Arrays;

public class Lesson6_Distinct {

  public static void main(String[] args) {

    System.out.println("Distinct : " + solution(new int[]{2, 1, 1, 2, 3, 1}));
  }

  private static int solution(int[] A) {
    A = Arrays.stream(A)
        .distinct()
        .toArray();

    return A.length;

  }

}
