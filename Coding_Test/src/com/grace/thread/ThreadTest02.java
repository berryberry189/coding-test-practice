package com.grace.thread;

public class ThreadTest02 {

   public static final void main(String[] args) throws Exception {
       MyThread01 thread = new MyThread01();
       thread.start();
       System.out.println("Hello, My Child!");
   }
}


