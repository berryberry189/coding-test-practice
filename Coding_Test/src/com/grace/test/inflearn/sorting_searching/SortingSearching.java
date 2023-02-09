package com.grace.test.inflearn.sorting_searching;

import java.util.Arrays;

public class SortingSearching {

  public static void main(String[] args) {

    // Q1. 선택 정렬
    System.out.println("Q1. 선택 정렬 : " + Arrays.toString(solution1(6, new int[]{13, 5, 11, 7, 23, 15})));

    // Q2. 버블 정렬
    System.out.println("Q2. 버블 정렬 : " + Arrays.toString(solution2(6, new int[]{13, 5, 11, 7, 23, 15})));

  }

  // 1. 선택 정렬
  // 선택 정렬은 첫 번째 자료를 두 번째 자료부터 마지막 자료까지 차례대로
  // 비교하여 가장 작은 값을 찾아 첫 번째에 놓고,
  // 두 번째 자료를 세 번째 자료부터 마지막 자료까지와 차례대로 비교하여
  // 그 중 가장 작은 값을 찾아 두 번째 위치에 놓는 과정을 반복하며 정렬을 수행
  private static int[] solution1(int N, int[] arr) {
    // 반복문 돌면서 i번째~N번째에서 가장 작은 숫자를 i번째에 두기
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

  // 2. 버블 정렬
  // 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘
  // 인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면 서로 교환
  // 한번의 턴을 통해서 가장 큰숫자를 가장 뒤로 밀어냄
  private static int[] solution2(int N, int[] arr) {
    for(int i=0; i<N-1; i++) {
      for(int j=0; j<N-1-i; j++) {
        if(arr[j] > arr[j+1]) {
          int tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }
      }
    }
    return arr;
  }

}
