package com.grace.test.codility.lesson6;

import java.util.Arrays;

public class Lesson6_NumberOfDiscIntersections {

  public static void main(String[] args) {

    System.out.println("NumberOfDiscIntersections : " + solution(new int[]{1, 5, 2, 1, 4, 0}));

  }

  private static int solution(int[] A) {
    int n =  A.length;
    int[] lowerArr = new int[n];
    int[] upperArr = new int[n];

    for(int i=0; i<n; i++) {
      lowerArr[i] = i - A[i];
      upperArr[i] = i + A[i];
    }

    Arrays.sort(lowerArr);
    Arrays.sort(upperArr);

    int cnt = 0;
    
    for(int i=0; i<n; i++) {
      for(int j = i+1; j<n; j++) {
        if(upperArr[i] >= lowerArr[j]) {
          cnt ++;
        }
      }
    }

    return cnt > 10000000 ? -1 : cnt;
  }

}
