package com.grace.test.inflearn.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Section8_Q2바둑이승차DFS {

  static int answer = Integer.MIN_VALUE, limit, n;

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] arrStr = bufferedReader.readLine().split(" ");
    // 트럭의 제한 무게
    limit = Integer.parseInt(arrStr[0]);

    // 바둑이 마리수
    n = Integer.parseInt(arrStr[1]);

    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(bufferedReader.readLine());
    }

    section8_2Solution(0, 0, arr);

    bufferedWriter.write("answer :" + answer);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();

  }

  public static void section8_2Solution(int index, int sum, int[] arr) {
    if(sum > limit) return;
    if(index == n) {
      answer = Math.max(answer, sum);
    }
    else {
      section8_2Solution(index + 1, sum + arr[index], arr);
      section8_2Solution(index + 1, sum, arr);
    }

  }


}
