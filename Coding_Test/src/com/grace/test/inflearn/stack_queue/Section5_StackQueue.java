package com.grace.test.inflearn.stack_queue;

import java.util.Stack;

public class Section5_StackQueue {

  public static void main(String[] args) {

    // Q1. 올바른 괄호
    System.out.println("Q1. 올바른 괄호: " + solution1("(()(()))(()"));
    System.out.println("Q1. 올바른 괄호: " + solution1("(())()"));

    // Q2. 괄호문자제거
    System.out.println("Q2. 괄호문자제거: " + solution2("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));

  }

  private static String solution1(String str) {
    String answer = "YES";
    Stack<Character> stack = new Stack<>();
    for(char c : str.toCharArray()) {
      if(c == '(') {
        stack.push(c);
      } else {
        if(!stack.isEmpty()) {
          stack.pop();
        } else {
          return "NO";
        }
      }
    }
    if(!stack.isEmpty()) answer = "NO";
    return answer;
  }

  private static String solution2(String str) {
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for(char c : str.toCharArray()) {
      if(c != ')') {
        stack.push(c);
      } else {
        if(!stack.isEmpty()) {
          while (stack.pop() != '(') {}
        }
      }
    }

    for(char c : stack) {
      sb.append(c);
    }
    return sb.toString();
  }

}
