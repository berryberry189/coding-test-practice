package com.grace.test.inflearn.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
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

    // Q6. 공주 구하기
    System.out.println("Q6. 공주 구하기: " + solution6(8, 3));

    // Q7. 교육과정 설계
    System.out.println("Q7. 교육과정 설계: " + solution7("CBA", "CBDAGE"));


    // Q8. 응급실
    System.out.println("Q8. 응급실: " + solution8(5, 2, new int[]{60, 50, 70, 80, 90}));
    System.out.println("Q8. 응급실: " + solution8(6, 3, new int[]{70, 60, 90, 60, 60, 60}));

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
        if(str .charAt(i-1) == '(') {
          answer += stack.size();
        } else {
          answer ++;
        }
      }
    }

    return answer;
  }

  private static int solution6(int N, int K) {
    int answer = 0;
    Queue<Integer> queue = new LinkedList<>();
    for(int i=1; i<=N; i++) {
      queue.add(i);
    }
    while (!queue.isEmpty()) {
      for(int i=1; i<K; i++) {
        queue.offer(queue.poll());
      }
      queue.poll();
      if(queue.size() == 1) answer = queue.poll();
    }
    return answer;
  }

  private static String solution7(String need, String plan) {
    String answer = "YES";
    Queue<Character> queue = new LinkedList<>();
    for(char c : need.toCharArray()) {
      queue.offer(c);
    }
    for(char c : plan.toCharArray()) {
      if(queue.contains(c) && c != queue.poll()) {
        return "NO";
      }
    }
    if(!queue.isEmpty()) answer = "NO";
    return answer;
  }

  private static int solution8(int N, int M, int[] arr) {
    int answer = 1;
    Queue<Person> queue = new LinkedList<>();
    for(int i=0; i<N; i++) {
      queue.offer(new Person(i, arr[i]));
    }
    while (!queue.isEmpty()) {
      Person tmp = queue.poll();
      for(Person p : queue) {
        if(p.priority > tmp.priority) {
          queue.add(tmp);
          tmp = null;
          break;
        }
      }
      if(tmp!=null) {
        if(tmp.index == M) return answer;
        else answer++;
      }
    }

    return answer;
  }

}

class Person {
  int index;
  int priority;

  public Person(int index, int priority) {
    this.index = index;
    this.priority = priority;
  }
}
