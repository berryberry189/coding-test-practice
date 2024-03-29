package com.grace.syncronization;

public class SynchExample6 {

    static class Counter {
        public static int count = 0;
        public static void increment() {
            //synchronized (this) { Counter.count++; }
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++)
                Counter.increment();
        }
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new SynchExample6.MyRunnable());
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++)
            threads[i].join();
        System.out.println("counter = " + SynchExample6.Counter.count);
    }
}
