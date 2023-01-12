package com.grace.test.inflearn.string;


import java.util.Arrays;

public class Section1_String {

  public static void main(String[] args) {

    // Q1. 문자찾기
    System.out.println("Q1. 문자찾기 : " + solution1("Computercooler", 'c'));

    // Q9. 숫자만추출
    System.out.println("Q9. 숫자만추출 : " + solution9("g0en2T0s8eSoft"));

    // Q10. 가장 짧은 문자거리
    System.out.println("Q10. 가장 짧은 문자거리 : " + Arrays.toString(solution10("teachermode", 'e')));

    // Q11. 문자열 압축
    System.out.println("Q11. 문자열 압축 : " + solution11("KKHSSSSSSSE"));

    // Q12. 암호
    System.out.println("Q12. 암호 : " + solution12(4, "#****###**#####**#####**##**"));


  }


  private static int solution1(String str, char c) {
    str = str.toUpperCase();
    c = Character.toUpperCase(c);
    int answer = 0;
    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i) == c) answer++;
    }
    return answer;
  }


  private static int solution9(String str) {
    int answer = 0;
    for(char c : str.toCharArray()) {
      // 아스키 코드 숫자
      if(c>= 48 && c <= 57) {
        answer = answer * 10 + (c - 48);
      }
    }
    return answer;
  }

  private static int[] solution10(String str, char c) {
    int[] answerArr = new int[str.length()];

    int p = 1000;
    // 왼쪽 loop
    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i) == c) {
        p = 0;
        answerArr[i] = p;
      } else {
        p++;
        answerArr[i] = p;
      }
    }

    p = 1000;
    // 오른쪽 loop
    for(int i=str.length()-1; i>=0; i--) {
      if(str.charAt(i) == c) {
        p = 0;
        answerArr[i] = Math.min(answerArr[i], p);
      } else {
        p++;
        answerArr[i] = Math.min(answerArr[i], p);
      }
    }

    return answerArr;
  }

  private static String solution11(String str) {
    StringBuilder sb = new StringBuilder();

    int cnt = 1;

    str += "";
    for(int i =0; i<str.length()-1; i++) {
      if(str.charAt(i) == str.charAt(i+1)) {
        cnt ++;
      }
      else {
        sb.append(str.charAt(i));
        if(cnt > 1) {
          sb.append(cnt);
        }
        cnt = 1;
      }
    }

    return sb.toString();
  }


  private static String solution12(int n, String str) {
    String answer = "";

    int oneLen = str.length() / n;

    str = str.replace('#', '1');
    str = str.replace('*', '0');

    for(int i=0; i<n; i++) {
      String substring = str.substring(0, oneLen);
      str = str.substring(oneLen);
      int num = Integer.parseInt(substring, 2);
      answer += (char) num;
    }

    return answer;
  }

}
