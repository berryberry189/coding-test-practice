package com.grace.test.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18108 {

  // https://www.acmicpc.net/problem/18108

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String yearStr = br.readLine();
    int year = Integer.parseInt(yearStr);
    System.out.println(year - 543);
  }

}
