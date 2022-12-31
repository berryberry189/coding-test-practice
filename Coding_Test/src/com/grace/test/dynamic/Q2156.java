package com.grace.test.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {
  // https://www.acmicpc.net/problem/2156
  // ex) 10, 25, 30, 1 => 2,3번쨰 (55)

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n+1];

    // ex 인덱스 2 기준
    // 1. OOX : dp[i-1]
    // 2. OXO : dp[i-2] + arr[i]
    // 3. XOO : dp[i-3] + arr[i-1] + arr[i]
    // => 3가지 중 가장 max 값 저장
    int[] dp = new int[n+1];

    for(int i=1; i<=n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp[1] = arr[1];

    if(n > 1) {
      dp[2] = arr[1] + arr[2];
      for(int i = 3; i<=n; i++) {
        dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
      }
    }

    System.out.println(dp[n]);
  }
}
