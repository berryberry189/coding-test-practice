package com.grace.syncronization;

public class SynchExample3 {

    static class Counter {
        private static Object object = new Object();
        public static int count = 0;
        public static void increment() {
            // critical section
            synchronized (object) {
                count++;
            }
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
            threads[i] = new Thread(new SynchExample3.MyRunnable());
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++)
            threads[i].join();
        System.out.println("counter = " + SynchExample3.Counter.count);
    }
}
