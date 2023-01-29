package com.grace.test.inflearn.stack_queue;

import java.util.Stack;

public class Section5_StackQueue {

  public static void main(String[] args) {

    // Q1. 올바른 괄호
    System.out.println("Q1. 올바른 괄호: " + solution1("(()(()))(()"));
    System.out.println("Q1. 올바른 괄호: " + solution1("(())()"));

    // Q2. 괄호문자제거
    System.out.println("Q2. 괄호문자제거: " + solution2("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));

    // Q3. 크레인 인형뽑기(카카오)
    System.out.println("Q3. 크레인 인형뽑기(카카오): " +
        solution3(5, new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
            9, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));

    // Q4. 후위식 연산(postfix)
    System.out.println("Q4. 후위식 연산(postfix): " + solution4("352+*9-"));

    // Q5. 쇠막대기
    System.out.println("Q5. 쇠막대기: " + solution5("()(((()())(())()))(())"));
    System.out.println("Q5. 쇠막대기: " + solution5("(((()(()()))(())()))(()())"));

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

  private static int solution3(int N, int[][] arr, int M, int[] moves) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();

    for(int position : moves) {
      for(int i=0; i<N; i++) {
        if(arr[i][position-1] != 0) {
          int item = arr[i][position - 1];
          arr[i][position - 1] = 0;
          if(!stack.empty() && stack.peek() == item) {
            stack.pop();
            answer+=2;
          } else {
            stack.push(item);
          }
          break;
        }
      }
    }

    return answer;
  }

  private static int solution4(String str) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    for(char c : str.toCharArray()) {
      if(Character.isDigit(c)) { // 슷자인지 체크
        stack.push(c-48);
      }
      else {
        int rt = stack.pop();
        int lt = stack.pop();
        if(c == '+') {
          stack.push(lt + rt);
        }
        else if(c == '-') {
          stack.push(lt - rt);
        }
        else if(c == '*') {
          stack.push(lt * rt);
        }
        else if(c == '/') {
          stack.push(lt / rt);
        }
      }
    }
    answer = stack.get(0);
    return answer;
  }

  private static int solution5(String str) {
    int answer = 0;
    Stack<Character> stack = new Stack<>();
    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i) =='(') {
        stack.push(str.charAt(i));
      } else {
        stack.pop();
        if(str.charAt(i-1) == '(') {
          answer += stack.size();
        } else {
          answer ++;
        }
      }
    }

    return answer;
  }

}
