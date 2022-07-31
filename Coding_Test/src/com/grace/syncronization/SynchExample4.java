package com.grace.syncronization;

public class SynchExample4 {

    static class Counter {
        public static int count = 0;
        // static 제외
        public void increment() {
            synchronized (this) {
                Counter.count++;
            }
        }
    }

    static class MyRunnable implements Runnable {
        Counter counter;
        public MyRunnable(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++)
                counter.increment();
        }
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            // 카운터 인스턴스를 따로 만들어줌
            threads[i] = new Thread(new MyRunnable(new Counter()));
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++)
            threads[i].join();
        System.out.println("counter = " + Counter.count); }
}
