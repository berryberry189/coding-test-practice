package com.grace.test.programmers.level1;

public class Level1_크기가작은부분문자열 {

  // https://school.programmers.co.kr/learn/courses/30/lessons/147355

  public static void main(String[] args) {
    System.out.println("result1 : " + solution("3141592", "271"));
    System.out.println("result2 : " + solution("500220839878", "7"));
    System.out.println("result3 : " + solution("10203"	, "15"));
  }

  static int solution(String t, String p) {
    int answer = 0;

    int tLen = t.length();
    int pLen = p.length();
    int n = tLen - pLen + 1;

    long pNum = Long.parseLong(p);

    for(int i=0; i<n; i++) {
      long num = Long.parseLong(t.substring(i, (i+pLen)));
      if(num <= pNum) answer ++;
    }

    return answer;
  }

}
