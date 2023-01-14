package com.grace.test.inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Section2_Array {

  public static void main(String[] args) {

    // Q1. 큰 수 출력하기
    // N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
    System.out.println("Q1. 큰 수 출력하기 : " + solution1(new int[]{7, 3, 9, 5, 6, 12}));

    // Q2. 보이는 학생
    System.out.println("Q2. 보이는 학생 : " + solution2(new int[]{130, 135, 148, 140, 145, 150, 150, 153}));

    // Q5.소수(에라토스테네스 체)
    System.out.println("Q5.소수(에라토스테네스 체) :" + solution5(20));

    // Q6.뒤집은 소수
    System.out.println("Q6.뒤집은 소수 :" + solution6(new int[]{32, 55, 62, 20, 250, 370, 200, 30, 100}));

    // Q7. 점수계산
    System.out.println("Q7. 점수계산 :" + solution7(new int[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 0}));

    // Q8. 등수구하기
    System.out.println("Q8. 등수구하기 :" + Arrays.toString(solution8(new int[]{87, 89, 92, 100, 76})));

    // Q9. 격자판 최대합
    System.out.println("Q9. 격자판 최대합 :" + solution9(5,
        new int[][]{{10, 13, 10, 12, 15}, {12, 39, 30, 23, 11}, {11, 25, 50, 53, 15}, {19, 27, 29, 37, 27}, {19, 13, 30, 13, 19}}));

    // Q10. 봉우리
    System.out.println("Q10. 봉우리 :" + solution10(5,
        new int[][]{{5, 3, 7, 2, 3}, {3, 7, 1, 6, 1}, {7, 2, 5, 3, 4}, {4, 3, 6, 4, 1}, {8, 7, 3, 5, 2}}));


    // Q12. 멘토링
    System.out.println("Q12. 멘토링 :" + solution12(4, 3,
        new int[][]{{3, 4, 1, 2}, {4, 3, 2, 1}, {3, 1, 4, 2}}));



    // Q11. 임시반장 정하기
    System.out.println("Q11. 임시반장 정하기 :");
    // new int[][]{{2, 3, 1, 7, 3},{4, 1, 9, 6, 8},{5, 5, 2, 4, 4},{6, 5, 2, 6, 7},{8, 4, 2, 2, 2}};
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n+1][6];
    for(int i=1; i<=n; i++) {
      for (int j=1; j<=5; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    System.out.println(solution11(n, arr));


  }


  static String solution1(int[] arr) {
    String answer= arr[0] + " ";

    for(int i=1; i<arr.length; i++) {
      if(arr[i-1] < arr[i]) answer+= arr[i] + " ";
    }
    return answer;
  }

  static int solution2(int[] arr) {
    int answer= 0;

    int currentMax = Integer.MIN_VALUE;
    for(int i=0; i<arr.length; i++) {
      if(currentMax < arr[i]) {
        answer++;
        currentMax = arr[i];
      }
    }
    return answer;
  }

  private static int solution5(int n) {
    int num = 0;

    // false 를 소수로 두기
    boolean[] check = new boolean[n+1];
    check[0] = check[1] = true;

    List<Integer> answerList = new ArrayList<>();
    for(int i=2; i<=n; i++) {
      if(!check[i]) {
        answerList.add(i);
        for(int j=i*2; j<=n; j+=i) {
          check[j] = true;
        }
      }
    }
    System.out.println("answerArr : " + answerList);
    return num;
  }

  private static List<Integer> solution6(int[] arr) {
    List<Integer> answerList = new ArrayList<>();
    for(int n: arr) {
      int tmp = n;
      int result = 0;
      while(tmp > 0) {
        int t = tmp % 10;
        result = result * 10 + t;
        tmp = tmp / 10;
      }
      if(isPrime(result)) answerList.add(result);
    }
    return answerList;
  }

  private static boolean isPrime(int n) {
    if(n == 1) return false;
    for(int i=2; i*i<n; i++) {
      if(n % i == 0) return false;
    }
    return true;
  }

  private static int solution7(int[] arr) {
    int answer = 0;
    int currentMax = 0;
    for(int i=0; i<arr.length; i++) {
      if(arr[i] == 1) {
        currentMax ++;
        answer += currentMax;
      } else {
        currentMax = 0;
      }
    }
    return answer;
  }

  private static int[] solution8(int[] arr) {
    int[] answerArr = new int[arr.length];
    for(int i=0; i<arr.length; i++) {
      int cnt = 1;
      for(int j=0; j<arr.length; j++) {
        if(arr[j] < arr[i]) cnt ++;
      }
      answerArr[i] = cnt;
    }
    return answerArr;
  }

  private static int solution9(int n, int[][] arr){
    int answer = Integer.MIN_VALUE;

    // 가로, 세로
    int heightSum, widthSum;
    for(int i=0; i<n; i++) {
      heightSum = widthSum = 0;
      for(int j=0; j<n; j++) {
        widthSum += arr[i][j];
        heightSum += arr[j][i];
      }
      answer = Math.max(answer, widthSum);
      answer = Math.max(answer, heightSum);
    }

    // 대각선
    int diagonalSum1 = 0;
    int diagonalSum2 = 0;
    for(int i=0; i<n; i++) {
      diagonalSum1 += arr[i][i];
      diagonalSum2 += arr[i][n-i-1];
    }
    answer = Math.max(answer, diagonalSum1);
    answer = Math.max(answer, diagonalSum2);

    return answer;
  }

  private static int solution10(int n, int[][] arr){
    // 방향배열
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    int answer = 0;

    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        boolean flag = true;
        for(int k=0; k<4; k++) {
          int nx = i + dx[k];
          int ny = j + dy[k];
          if(nx >=0 && nx<n && ny >=0 && ny<n
              && arr[nx][ny] >= arr[i][j]) {
            flag = false;
            break;
          }
        }
        if(flag) answer ++;
      }
    }
    return answer;
  }


  private static int solution11(int n, int[][] arr){
    int answer = 0;
    int max = Integer.MIN_VALUE;

    for(int i=1; i<=n; i++) {
      int cnt = 0;
      for (int j=1; j<=n; j++) {
        // k = 반이기때문에 5로 고장
        for (int k=1; k<=5; k++) {
          if(arr[i][k] == arr[j][k]) {
            cnt ++;
            break;
          }
        }
        if(cnt > max) {
          max = cnt;
          answer = i;
        }
      }
    }
    return answer;
  }

  private static int solution12(int n, int m, int[][] arr) {
    int answer = 0;

    // i,j = 사람
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=n; j++) {
        int cnt = 0;

        // k = 테스트 개수
        for(int k=0; k<m; k++) {
          int pi = 0, pj = 0;
          // s = 등수
          for(int s=0; s<n; s++) {
            if(arr[k][s] == i) pi = s;
            if(arr[k][s] == j) pj = s;
          }

          // i가 j보다 등수가 높은경우 cnt++
          if(pi < pj) cnt ++;
        }

        // cnt 가 테스트 개수만큼 있어야 멘티 멘토 자격이 있음
        if(cnt == m) {
          answer++;
        }
      }
    }
    return  answer;
  }





}
