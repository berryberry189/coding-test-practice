package com.grace.test.inflearn.sorting_searching;

import java.util.Arrays;

public class SortingSearching {

  public static void main(String[] args) {

    // Q1. 선택 정렬
    System.out.println("Q1. 선택 정렬 : " + Arrays.toString(solution1(6, new int[]{13, 5, 11, 7, 23, 15})));

    // Q2. 버블 정렬
    System.out.println("Q2. 버블 정렬 : " + Arrays.toString(solution2(6, new int[]{13, 5, 11, 7, 23, 15})));

    // Q3. 삽입 정렬
    System.out.println("Q3. 삽입 정렬 : " + Arrays.toString(solution3(6, new int[]{13, 5, 11, 7, 23, 15})));

    // Q4. Least Recently Used
    System.out.println("Q4. Least Recently Used : " + Arrays.toString(solution4(5, 9, new int[]{1, 2, 3, 2, 6, 2, 3, 5, 7})));

    // Q5. 중복 확인
    System.out.println("Q5. 중복 확인 : " + solution5(8, new int[]{20, 25, 52, 30, 39, 33, 43, 33}));

    // Q6. 장난꾸러기
    System.out.println("Q6. 장난꾸러기 : " + solution6(9, new int[]{120, 125, 152, 130, 135, 135, 143, 127, 160}));


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

  // 4. Least Recently Used
  // 가장 최근데 사용되지 않은 것을 제거
  private static int[] solution3(int N, int[] arr) {
    for(int i=1; i<N; i++) {
      int tmp = arr[i];
      int j;
      for(j=i-1; j>=0; j--) {

        if(arr[j] > tmp) {
          arr[j+1] = arr[j];
        } else  {
          break;
        }
      }
      arr[j+1] = tmp;
    }
    return arr;
  }

  // 3. 삽입 정렬
  private static int[] solution4(int S, int N, int[] arr) {
    // 현재 작업이 항상 캐시의 0번에 삽입됨
    int[] cache = new int[S];
    for(int num : arr) {
      int idx = -1;
      for(int i=0; i<S; i++) {
        if(num == cache[i]) idx = i;
      }
      if(idx == -1) { // miss 상황
        for(int i= S-1; i>=1; i--) {
          cache[i] = cache[i-1];
        }
      } else { // hit 상황
        for(int i= idx; i>=1; i--) {
          cache[i] = cache[i-1];
        }
      }
      cache[0] = num;
    }
    return cache;
  }

  private static String solution5(int N, int[] arr) {
    String answer = "U";
    Arrays.sort(arr);
    for(int i=0; i<N-1; i++) {
      if(arr[i] == arr[i+1]) return "D";
    }
    return answer;
  }

  private static String solution6(int N, int[] arr) {
    StringBuilder sb = new StringBuilder();
    int[] tempArr = arr.clone();
    Arrays.sort(tempArr);
    for(int i=0; i<N; i++) {
      if(arr[i] != tempArr[i]) sb.append(i+1).append(" ");
    }
    return sb.toString();
  }


}
