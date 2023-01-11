package com.grace.test.codility;

import java.util.Arrays;

public class Lesson4_MaxCounters {

  // https://app.codility.com/c/run/training353V4N-889/

  public static void main(String[] args) {

    System.out.println("test = "
        + Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
  }

  static int[] solution(int N, int[] A) {
    int[] resultArr = new int[N];

    int max = 0;
    for(int i=0; i<A.length; i++) {
      if(A[i] == N + 1) {
        for(int j=0; j<N; j++) {
          if(resultArr[j] < max) {
            resultArr[j] = max;
          }
        }
      } else {
        resultArr[A[i]-1] += 1;
        max = Math.max(max, resultArr[A[i]-1]);
      }
    }
    return resultArr;
  }

}
