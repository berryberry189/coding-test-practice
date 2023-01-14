package com.grace.test.codility.lesson7;

import java.util.Stack;

public class Lesson7_Fish {

  public static void main(String[] args) {
    System.out.println("Fish : " + solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
    System.out.println("Fish : " + solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 0, 0, 0, 0}));
    System.out.println("Fish : " + solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 0, 1, 1, 1}));
  }

  private static int solution(int[] A, int[] B) {
    int n = A.length;
    int cnt = 0;
    Stack<Integer> stack = new Stack<>();
    // 0 : -> / 1 : <-
    for(int i=0; i<n; i++) {
      if(B[i] == 0)  {
        while(!stack.isEmpty() && stack.peek() < A[i]) {
          stack.pop();
        }
        if(stack.isEmpty()) {
          cnt++;
        }

      } else {
        stack.push(A[i]);
      }
    }
    return stack.size() + cnt;
  }

}
