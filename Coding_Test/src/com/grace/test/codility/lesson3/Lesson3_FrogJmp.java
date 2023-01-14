package com.grace.test.codility.lesson3;

public class Lesson3_FrogJmp {
  // https://app.codility.com/c/run/training8WZFHC-C7D/

  public static void main(String[] args) {

    System.out.println("test = " + solution(10, 85, 30));

  }

  static int solution(int X, int Y, int D) {
    // D * result >= Y - X
    // result > = (Y - X)/D
    int result = (Y-X)/D;
    if((Y-X) == D * result) return result;
    return result + 1;

  }

}
