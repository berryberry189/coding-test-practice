package com.grace.test.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2748 {

  // https://st-lab.tistory.com/123

  static long[] arr;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    arr = new long[n+1];

    for(int i = 0; i < n+1; i++) {
      arr[i] = -1;
    }

    System.out.println(fibonacci(n));

  }

  static long fibonacci(int n) {
    if(n == 0 || n == 1) arr[n] = n;
    if(arr[n] == -1) {
      arr[n] = fibonacci(n-1) + fibonacci(n-2);
    }
    return arr[n];
  }

}
