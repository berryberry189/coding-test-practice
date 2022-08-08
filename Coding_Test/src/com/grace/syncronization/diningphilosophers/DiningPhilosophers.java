package com.grace.syncronization.diningphilosophers;

public class DiningPhilosophers {

    public static void main(String[] args) throws Exception {
        int numOfPhils = 5; // 철학자 인원
        Philosopher[] philosophers = new Philosopher[numOfPhils];
        // 모니터 생성
        DiningPhilosopherMonitor monitor = new DiningPhilosopherMonitor(numOfPhils);
        for (int i = 0; i < philosophers.length; i++)
            new Thread(new Philosopher(i, monitor)).start();
    }
}
