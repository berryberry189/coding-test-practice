package com.grace.test.string;

import java.io.*;

public class Q10926 {
  // https://www.acmicpc.net/problem/10926
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String id = br.readLine();

    System.out.println(getDuplicationId(id));

  }

  static String getDuplicationId(String id) {
    return id + "??!";
  }

}
