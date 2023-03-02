package com.grace.test.inflearn.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Section8_Q1합이같은부분집합DFS {

  static String answer = "NO";
  static boolean flag = false;
  static int n, total = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(bufferedReader.readLine());

    String[] arrStr = bufferedReader.readLine().split(" ");

    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(arrStr[i]);
      total += arr[i];
    }

    section8Solution(0, 0, arr);

    bufferedWriter.write("answer :" + answer);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();

  }

  public static void section8Solution(int index, int sum, int[] arr) {
    if(flag) return;
    if(sum > total/2) return;
    if(index == n) {
      if((total - sum) == sum) {
        flag = true;
        answer = "YES";
      }
    }
    else {
      section8Solution(index + 1, sum + arr[index], arr);
      section8Solution(index + 1, sum, arr);
    }

  }


}
