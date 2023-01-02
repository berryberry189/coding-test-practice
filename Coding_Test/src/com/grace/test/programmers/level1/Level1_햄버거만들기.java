package com.grace.test.programmers.level1;

import java.util.Stack;

public class Level1_햄버거만들기 {
  // https://school.programmers.co.kr/learn/courses/30/lessons/133502

  public static void main(String[] args) {

    int[] ingredient1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
    int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
    int[] ingredient3 = {2, 1, 1};
    int[] ingredient4 = {2, 1};
    int[] ingredient5 = {1, 2, 3, 1};

    System.out.println("result1 : " + solution(ingredient1));
    System.out.println("result2 : " + solution(ingredient2));
    System.out.println("result3 : " + solution(ingredient3));
    System.out.println("result4 : " + solution(ingredient4));
    System.out.println("result5 : " + solution(ingredient5));

  }

  static int solution(int[] ingredient) {
    int answer = 0;

    Stack<Integer> stack = new Stack<>();

    // 1-2-3-1 되면 pop
    for (int num : ingredient) {
      if(num == 1
          && stack.size() > 2
          && (stack.peek() == 3
          && stack.get(stack.size()-2) == 2
          && stack.get(stack.size()-3) == 1)) {

        stack.pop();
        stack.pop();
        stack.pop();

        answer ++;

      } else {
        stack.push(num);
      }
    }

    return answer;
  }

}
