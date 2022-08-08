package com.grace.syncronization.diningphilosophers;

public class Philosopher implements Runnable {

    private int id; // 철학자의 id
    private DiningPhilosopherMonitor monitor;

    public Philosopher(int id, DiningPhilosopherMonitor monitor) { this.id = id;
        this.monitor = monitor;
    }
    @Override
    public void run() {
        while (true) {
            think(); // 생각
            monitor.pickup(id); // 젓가락 획득
            eat(); // 식사
            monitor.putdown(id); // 젓가락 내려놓음
        }
    }

    private void think() {
        try {
            System.out.println(id + ": Now I'm thinking.");
            Thread.sleep((long)(Math.random()*500));
        } catch (InterruptedException e) { }
    }

    private void eat() {
        try {
            System.out.println(id + ": Now I'm eating.");
            Thread.sleep((long) (Math.random() * 50));
        } catch (InterruptedException e) {}
    }
}
