package com.grace.thread;

public class ThreadTest01 {

   public static final void main(String[] args) throws Exception {
       Thread thread = new Thread(new Runner());
       System.out.print("B ");
       thread.start(); // 스레드 생성 -> run child 스레드 돌기
       System.out.print("C ");
       thread.join(); // 부모스레드 대기
       System.out.print("D ");
   }
}


