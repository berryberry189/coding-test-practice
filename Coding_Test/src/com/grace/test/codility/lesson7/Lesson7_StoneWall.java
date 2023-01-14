package com.grace.test.codility.lesson7;

import java.util.Stack;

public class Lesson7_StoneWall {

  public static void main(String[] args) {

    System.out.println("StoneWall : " + solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));

  }

  private static int solution(int[] H) {
    Stack<Integer> stack = new Stack<>();
    int cnt = 0;
    stack.push(H[0]);

    for(int i=1; i<H.length; i++) {
      while(!stack.isEmpty()) {
        if(stack.peek() > H[i]) {
          cnt ++;
          stack.pop();
        }
        else if(stack.peek() < H[i]){
          stack.push(H[i]);
          break;
        }
        else {
          break;
        }
      }
      if(stack.isEmpty()) stack.push(H[i]);
    }

    return cnt + stack.size();
  }

}
