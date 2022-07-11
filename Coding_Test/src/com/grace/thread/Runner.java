package com.grace.thread;

public class Runner implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            System.out.print("A ");
        }
    }
}
