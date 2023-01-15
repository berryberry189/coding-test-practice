package com.grace.test.test_20230115;

import java.util.HashMap;

public class Test1 {

  public static void main(String[] args) {

    System.out.println("test1 : " + solution("ervervige"));
    System.out.println("test1 : " + solution("aaabab"));
    System.out.println("test1 : " + solution("mom"));
    System.out.println("test1 : " + solution("aaaaaaaaabcd"));

  }

  private static int solution(String S) {
    if(S.length() == 1) return 0;

    HashMap<Character, Integer> map = new HashMap<>();
    for(char c : S.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int answer = 0;
    for(char key : map.keySet()) {
      if(map.get(key) % 2 != 0) {
        answer++;
      }
    }

    if(answer > 0) answer--;
    return answer;
  }

}
