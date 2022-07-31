package com.grace.syncronization;

public class SynchExample5 {

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
        Counter counter = new Counter();
        for (int i = 0; i < threads.length; i++) {
                // 5개 모두 같은 카운터 참조
            threads[i] = new Thread(new MyRunnable(counter));
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++)
            threads[i].join();
        System.out.println("counter = " + Counter.count);
    }
}
