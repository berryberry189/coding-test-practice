package com.grace.test.codility;

public class Lesson5_MinAvgTwoSlice {

  public static void main(String[] args) {

    System.out.println("MinAvgTwoSlice : " +
       solution(new int[]{4,2,2,5,1,5,8}));

  }

  // 평균은 두 수 중 작은수 이상의 값이 된다.(같은경우 제외)
  // 원소가 4개인 그룹의 평균은 앞뒤 2개씩 나눴을때 각각의 평균의 작은값보다 작아질 수 없으므로
  // 원소개 4개 이상인 그룹은 고려할 필요가 없다.
  // 결론 : 원소가 2개나 3개인 그룹만 확인하면 된다.
  // (3개는 2 / 1 로 나눌 수 있는데 조건상 그룹은 2개 이상이므로)
  private static int solution(int[] A) {
    float min = (A[0] + A[1]) / 2f;
    int minIndex = 0;
    for(int i=2; i<A.length; i++) {
      float avg = (A[i-2] + A[i-1] + A[i]) / 3f;
      if(min > avg) {
        min = avg;
        minIndex = i-2;
      }
      avg = (A[i-1] + A[i]) / 2f;
      if(min > avg) {
        min = avg;
        minIndex = i-1;
      }
    }
    return minIndex;
  }

}
