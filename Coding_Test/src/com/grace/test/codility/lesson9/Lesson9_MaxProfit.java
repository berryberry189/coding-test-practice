package com.grace.test.codility.lesson9;

public class Lesson9_MaxProfit {

  public static void main(String[] args) {

    System.out.println("MaxProfit : " +
        solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));

  }

  private static int solution(int[] A) {
    if(A.length < 2) return 0;
    int min = A[0];
    int max = A[1];
    int result = max - min;

    for(int n : A) {
      if(n < min) {
        min = n;
      } else {
        result = Math.max(result, n - min);
      }
    }
    return result;
  }

}
