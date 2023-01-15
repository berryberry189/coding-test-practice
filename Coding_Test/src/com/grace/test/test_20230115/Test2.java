package com.grace.test.test_20230115;

import java.util.Arrays;

public class Test2 {

  public static void main(String[] args) {

    // 효율성 0....

    //System.out.println("test1 : " + Arrays.toString(solution(new String[]{"abc", "bca", "dbe"})));
    //System.out.println("test2 : " + Arrays.toString(solution(new String[]{"zzzz", "ferz", "zdsr", "fgtd"})));
    //System.out.println("test3 : " + Arrays.toString(solution(new String[]{"gr", "sd", "rg"})));
    //System.out.println("test3 : " + Arrays.toString(solution(new String[]{"bdafg", "ceagi"})));
    System.out.println("test4 : " + Arrays.toString(
        solution(new String[]{
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"})));

  }

  private static int[] solution(String[] S) {
    int[] answerArr = new int[3];
    if(S.length < 1) return new int[]{};

    int M = S[0].length();

    for(int i=0; i<S.length-1; i++) {
      String iStr = S[i];
      for(int j=i+1; j<S.length; j++) {
        String jStr = S[j];
        for(int k=0; k<M; k++) {
          if(iStr.charAt(k) == jStr.charAt(k)) {
            answerArr[0] = i;
            answerArr[1] = j;
            answerArr[2] = k;
            break;
          }
        }
      }
    }

    boolean allZero = true;
    for(int n :answerArr) {
      if(n != 0) allZero = false;
    }
    if(allZero) return new int[]{};

    return answerArr;
  }

}
