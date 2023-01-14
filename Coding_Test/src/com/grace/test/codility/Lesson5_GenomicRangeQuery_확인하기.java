package com.grace.test.codility;

import java.util.Arrays;

public class Lesson5_GenomicRangeQuery_확인하기 {

  // https://stroot.tistory.com/96
  public static void main(String[] args) {

    System.out.println("GenomicRangeQuery : " +
        Arrays.toString(solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));

  }

  // A C G T 로 구성
  // 각각 1,2,3,4 충격계수를 갖음
  // P[K] ~ Q[K] 사이의 가장 작은 충격계수 반환
  private static int[] solution(String S, int[] P, int[] Q) {

    int[] answer = new int[P.length];

    int[] A = new int[S.length()];
    int[] C = new int[S.length()];
    int[] G = new int[S.length()];

    // index == 0
    char c = S.charAt(0);
    if (c == 'A') {
      A[0]++;
    }
    else if (c == 'C') {
      C[0]++;
    }
    else if (c == 'G') {
      G[0]++;
    }

    // index > 0
    for (int i = 1; i < S.length(); i++) {
      c = S.charAt(i);
      if (c == 'A') {
        A[i] = A[i - 1] + 1;
        C[i] = C[i - 1];
        G[i] = G[i - 1];
      }
      else if (c == 'C') {
        A[i] = A[i - 1];
        C[i] = C[i - 1] + 1;
        G[i] = G[i - 1];
      }
      else if (c == 'G') {
        A[i] = A[i - 1];
        C[i] = C[i - 1];
        G[i] = G[i - 1] + 1;
      }
      else {
        A[i] = A[i - 1];
        C[i] = C[i - 1];
        G[i] = G[i - 1];
      }
    }

    for (int i = 0; i < P.length; i++) {
      if (P[i] > 0) {
        if (A[Q[i]] > A[P[i] - 1]) {
          answer[i] = 1;
        }
        else if (C[Q[i]] > C[P[i] - 1]) {
          answer[i] = 2;
        }
        else if (G[Q[i]] > G[P[i] - 1]) {
          answer[i] = 3;
        }
        else {
          answer[i] = 4;
        }
      }
      else {
        if (A[Q[i]] > 0) {
          answer[i] = 1;
        }
        else if (C[Q[i]] > 0) {
          answer[i] = 2;
        }
        else if (G[Q[i]] > 0) {
          answer[i] = 3;
        }
        else {
          answer[i] = 4;
        }
      }
    }

    return answer;
  }


}
