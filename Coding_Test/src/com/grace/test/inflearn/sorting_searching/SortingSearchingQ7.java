package com.grace.test.inflearn.sorting_searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SortingSearchingQ7 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Point> pointList = new ArrayList<>();
    for(int i=0; i<n; i++) {
      String[] arr = br.readLine().split(" ");
      pointList.add(new Point(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
    }

    // Comparable interface 통해서 정렬됨
    Collections.sort(pointList);

    for (Point point : pointList) {
      System.out.println(point.x + " " + point.y);
    }

  }

}

class Point implements Comparable<Point> {
  public int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Point o) {
    if(this.x == o.x) {
      return this.y - o.y;
    } else {
      return this.x - o.x;
    }
  }
}