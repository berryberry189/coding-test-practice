package com.grace.test.codility.lesson1;

public class Lesson1_BinaryGap {

  // https://app.codility.com/c/run/trainingZZBKGA-UZR/

  public static void main(String[] args) {

    System.out.println("test 9=> 2 : " + solution(9) );
    System.out.println("test 529=> 4 : " + solution(529) );
    System.out.println("test 20=> 2 : " + solution(20) );
    System.out.println("test 15=> 0 : " + solution(15) );
    System.out.println("test 32=> 0 : " + solution(32) );

  }

  static int solution(int N) {
    String binaryToString = Integer.toBinaryString(N);
    String[] arr = binaryToString.split("");

    int gapCount = 0;
    int result = 0;
    for(int i=0; i<arr.length; i++) {
      if(arr[i].equals("0")) {
        gapCount++;
      } else {
        result = Math.max(result, gapCount);
        gapCount = 0;
      }
    }
    return result;

  }

}
