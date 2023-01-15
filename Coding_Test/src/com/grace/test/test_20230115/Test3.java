package com.grace.test.test_20230115;

public class Test3 {

  public static void main(String[] args) {

    System.out.println("test 1: " + solution("cdeo", new int[]{3, 2, 0, 1}));
    System.out.println("test 2: " + solution("cdeenetpi", new int[]{5, 2, 0, 1, 6, 4, 8, 3, 7}));
    System.out.println("test 3: " + solution("bytdag", new int[]{4, 3, 0, 1, 2, 5}));


  }

  private static String solution(String S, int[] A) {
    StringBuilder sb = new StringBuilder();
    sb.append(S.charAt(0));

    int nextIdx = A[0];
    while (nextIdx != 0) {
      sb.append(S.charAt(nextIdx));
      nextIdx = A[nextIdx];
    }

    return sb.toString();
  }

}
