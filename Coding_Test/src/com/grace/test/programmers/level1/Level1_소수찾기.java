package com.grace.test.programmers.level1;

public class Level1_소수찾기 {
  // https://school.programmers.co.kr/learn/courses/30/lessons/12921

  public static void main(String[] args) {

    System.out.println("result : " + solution(10));

  }

  public static int solution(int n) {

    int answer = 0;

    for(int i=2; i<=n; i++) {
      boolean isPrime = true;

      for(int j=2; j*j<=i; j++) {
        if(i % j == 0) {
          isPrime = false;
          break;
        }

      }

      if(isPrime) answer++;
    }

    return answer;
  }

}
