package com.grace.test.codility.lesson10;

public class Lesson10_CountFactors {

  public static void main(String[] args) {

    //System.out.println("CountFactors : " + solution(24));
    //System.out.println("CountFactors : " + solution(1));
    //System.out.println("CountFactors : " + solution(2));
    System.out.println("CountFactors : " + solution(3));
    System.out.println("CountFactors : " + solution(4));
    System.out.println("CountFactors : " + solution(10));

  }

  private static int solution(int N) {
    int cnt = 0;
    for(long i=1; i * i<=N; i++) {
      if(N % i == 0) {
        cnt ++;
        if(i*i < N) cnt ++;
      }
    }
    return cnt;
  }

}
