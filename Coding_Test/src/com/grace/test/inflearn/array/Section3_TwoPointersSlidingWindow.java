package com.grace.test.inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Section3_TwoPointersSlidingWindow {

  public static void main(String[] args) {

    // Q1. 두 배열 합치기
    System.out.println("Q1. 두 배열 합치기 : " + solution1(3, new int[]{1, 3, 5}, 5, new int[]{2, 3, 6, 7, 9}));

    // Q2. 공통원소 구하기
    System.out.println("Q2. 공통원소 구하기 : " +
        solution2(5, new int[]{1, 3, 9, 5, 2}, 5,  new int[]{3, 2, 5, 7, 8}));

    // Q3. 최대 매출
    System.out.println("Q3. 최대 매출 : " +
        solution3(10, 3,  new int[]{12, 15, 11, 20, 25, 10, 20, 19, 13, 15}));

  }

  // 투 포인터 알고리즘,,
  private static List<Integer> solution1(int n, int[] arr1, int m, int[] arr2) {
    List<Integer> answerList = new ArrayList<>();
    int pointer1 = 0, pointer2 = 0;
    while (pointer1 < n && pointer2 < m) {
      if(arr1[pointer1] < arr2[pointer2]) {
        answerList.add(arr1[pointer1++]);
      } else {
        answerList.add(arr2[pointer2++]);
      }
    }
    while (pointer1 < n) answerList.add(arr1[pointer1++]);
    while (pointer2 < m) answerList.add(arr2[pointer2++]);

    return answerList;
  }

  private static List<Integer> solution2(int n, int[] arr1, int m, int[] arr2) {
    List<Integer> answerList = new ArrayList<>();
    int pointer1 = 0;
    int pointer2 = 0;

    // 1 2 3 5 9
    Arrays.sort(arr1);
    // 2 3 5 7 8
    Arrays.sort(arr2);

    while(pointer1 < n && pointer2 < m) {
      if(arr1[pointer1] == arr2[pointer2]) {
        answerList.add(pointer1++);
        pointer2++;
      }
      else if(arr1[pointer1] < arr2[pointer2]) {
        pointer1++;
      }
      else {
        pointer2++;
      }
    }

    return answerList;
  }

  private static int solution3(int n, int k, int[] arr) {
    int sum = 0;
    for(int i=0; i<k; i++) {
      sum += arr[i];
    }
    int max = sum;
    for(int i=k; i<n; i++) {
      sum += (arr[i] - arr[i-k]);
      max = Math.max(max, sum);
    }

    return max;
  }



}
