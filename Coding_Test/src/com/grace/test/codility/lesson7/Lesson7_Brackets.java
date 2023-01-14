package com.grace.test.codility.lesson7;

import java.util.Stack;

public class Lesson7_Brackets {

  public static void main(String[] args) {

    System.out.println("Brackets1 : " + solution("{[()()]}"));
    System.out.println("Brackets2 : " + solution("([)()]"));
    System.out.println("Brackets2 : " + solution("{{{{"));

  }
  private static int solution(String S) {
    Stack<Character> stack = new Stack<>();
    for(char c: S.toCharArray()) {
      if(c == ')' ) {
        if(!checkPopStack(stack, '(')) return 0;
      } else if(c == ']') {
        if(!checkPopStack(stack, '[')) return 0;
      } else if(c == '}') {
        if(!checkPopStack(stack, '{')) return 0;
      } else {
        stack.push(c);
      }
    }
    if(!stack.isEmpty()) return 0;
    return 1;
  }

  private static boolean checkPopStack(Stack<Character> stack, char c) {
    if(stack.isEmpty()) return false;
    if(!stack.isEmpty()) {
      char popC = stack.pop();
      if(popC != c) return false;
    }
    return true;
  }

}
