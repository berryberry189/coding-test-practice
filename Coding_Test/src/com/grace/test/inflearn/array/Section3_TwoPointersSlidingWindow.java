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

    // Q4. 연속 부분수열
    System.out.println("Q4. 연속 부분수열 : " +
        solution4(8, 6,  new int[]{1, 2, 1, 3, 1, 1, 1, 2}));

    // Q5. 연속된 자연수의 합
    System.out.println("Q5. 연속된 자연수의 합 : " + solution5(15));

    // Q6. 최대 길이 연속부분수열
    System.out.println("Q6. 최대 길이 연속부분수열 : " +
        solution6(14, 2, new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1}));

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

  private static int solution4(int n, int m, int[] arr) {
    int answer = 0;
    int sum = 0;
    int lt = 0;
    for(int rt=0; rt<n; rt++) {
      sum += arr[rt];
      if(sum == m) answer++;
      while (sum >= m) {
        sum -= arr[lt++];
        if(sum == m) answer++;
      }
    }
    return answer;
  }

  private static int solution5(int N) {
    int answer = 0;
    int cnt = 1; // 연속된 자연수의 개수
    // N = 15인 경우
    N--;  // 14
    while(N > 0){
      cnt++; // 2 (연속된 2개의 자연수)
      N = N - cnt; // 12
      if(N % cnt == 0) answer++; // 12 % 2 == 0
    }

    return answer;
  }

  private static int solution6(int N, int K, int[] arr) {
    int answer = 0;
    int cnt = 0; // 0을 1로 바꾼 회수
    int lt = 0;

    for(int rt=0; rt<N; rt++) {
      if(arr[rt] == 0) cnt++;
      while (cnt > K) {
        if(arr[lt] == 0) cnt--;
        lt++;
      }
      answer = Math.max(answer, rt-lt+1);
    }

    return answer;
  }


}
