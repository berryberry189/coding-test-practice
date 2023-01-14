package com.grace.test.codility;

public class Lesson5_CountDiv {

  public static void main(String[] args) {

    System.out.println("CountDiv : " + solution(6, 11, 2));
    // 6(3), 11(5) -> 3
    // 7(3), 11(5) -> 2
    // 7(3), 10(5) -> 2
    // 6(3), 10(5) -> 3

  }

  private static int solution(int A, int B, int K) {
    if(A == B) return A%K == 0 ? 1 : 0;
    int aCnt = A/K;
    int bCnt = B/K;
    if(A%K == 0) return bCnt - aCnt + 1;
    return bCnt - aCnt;
  }

}
