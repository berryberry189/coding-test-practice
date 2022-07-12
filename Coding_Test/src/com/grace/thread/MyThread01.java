package com.grace.thread;

public class MyThread01 extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Hello, Thread!");
                Thread.sleep(500); }
        }
        catch (InterruptedException ie) {
            System.out.println("I'm interrupted");
        }
    }
}
