package com.grace.test.programmers.level2;

public class Level2_피보나치수 {

  public static void main(String[] args) {
    System.out.println("result1 : " + solution(3));
    System.out.println("result2 : " + solution(5));
  }

  static int solution(int n) {
    int[] fibonacciArr = new int[n + 1];
    for(int i=0; i<=n; i++){
      if(i == 0) fibonacciArr[0] = 0;
      if(i == 1) fibonacciArr[1] = 1;
      if(i > 1){
        int sum = fibonacciArr[i-1] + fibonacciArr[i-2];
        fibonacciArr[i] = sum % 1234567;
      }
    }
    return fibonacciArr[n];
  }

}
