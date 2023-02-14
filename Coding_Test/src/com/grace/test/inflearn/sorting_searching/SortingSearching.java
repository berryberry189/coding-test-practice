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

    // Q8. 이분검색
    System.out.println("Q8. 이분검색 : " + solution8(8, 32, new int[]{23, 87, 65, 12, 57, 32, 99, 81}));


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

  // 이분검색
  // 배열의 중간에 있는 임의의 값을 선택(X)하여 찾고자 하는 값 X와 비교한다
  // X가 중간 값보다 작으면 중간 값을 기준으로 좌측의 데이터들을 대상으로,
  // X가 중간값보다 크면 배열의 우측을 대상으로 다시 탐색한다
  // 해당 값을 찾을 때까지 동일한 방법으로 다시 중간의 값을 임의로 선택하고 비교한다
  private static int solution8(int N, int M, int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    int lt = 0, rt = N - 1;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if(arr[mid] == M) {
        answer = mid + 1;
        break;
      }
      if(arr[mid] > M){
        rt = mid - 1;
      }
      else {
        lt = mid + 1;
      }
    }
    return answer;
  }


}
