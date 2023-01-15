package com.grace.test.codility.lesson10;

import java.util.ArrayList;
import java.util.List;

public class Lesson10_MinPerimeterRectangle {

  public static void main(String[] args) {

    System.out.println("MinPerimeterRectangle : " + solution(30));

  }

  private static int solution(int N) {
    int min = Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();
    for(int i=1; i * i<=N; i++) {
      if(N % i == 0) {
        list.add(i);
      }
    }

    for (Integer num : list) {
      min = Math.min(min, ( 2 * (num + (N/num))));
    }

    return min;
  }

}
