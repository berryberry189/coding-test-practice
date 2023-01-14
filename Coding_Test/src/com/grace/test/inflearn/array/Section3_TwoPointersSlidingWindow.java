package com.grace.test.inflearn.array;

import java.util.ArrayList;
import java.util.List;

public class Section3_TwoPointersSlidingWindow {

  public static void main(String[] args) {

    // Q1. 두 배열 합치기
    System.out.println("Q1. 두 배열 합치기 : " + solution1(3, new int[]{1, 3, 5}, 5, new int[]{2, 3, 6, 7, 9}));


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



}
