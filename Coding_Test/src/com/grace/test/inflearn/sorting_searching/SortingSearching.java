package com.grace.test.inflearn.sorting_searching;

import java.util.Arrays;

public class SortingSearching {

  public static void main(String[] args) {

    // Q1. 선택 정렬
    System.out.println("Q1. 선택 정렬 : " + Arrays.toString(solution1(6, new int[]{13, 5, 11, 7, 23, 15})));

  }

    private static int[] solution1(int N, int[] arr) {
    for(int i=0; i<N-1; i++) {
      int idx = i;
      for(int j=i+1; j<N; j++) {
        if(arr[j] < arr[idx]) idx = j;
      }
      int tmp = arr[i];
      arr[i] = arr[idx];
      arr[idx] = tmp;
    }

    return arr;
  }

}
