package com.grace.syncronization.diningphilosophers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock; // 재진입 가능

public class DiningPhilosopherMonitor {

    private int numOfPhils;
    private State[] state;
    private Condition[] self; // condition variable
    private Lock lock;

    public DiningPhilosopherMonitor(int num) {
        numOfPhils = num;
        state = new State[num];
        self = new Condition[num];
        lock = new ReentrantLock();
        for (int i = 0; i < num; i++) {
            state[i] = State.THINKING; // 초기화
            self[i] = lock.newCondition(); // condition variable 하나씩 생성하여 저장
        }
    }

    // 자신의 왼쪽 철학자
    private int leftOf(int i) {
        return (i + numOfPhils - 1) % numOfPhils;
    }

    // 자신의 오른쪽 철학자
    private int rightOf(int i) {
        return (i + 1) % numOfPhils;
    }


    private void test(int i) {
        // 내가 배고프고, 왼쪽과 오른쪽이 식사중이 아닌 경우 ->  내가 식사를 하고 signal 을 호출
        if (state[i] == State.HUNGRY &&
                state[leftOf(i)] != State.EATING &&
                state[rightOf(i)] != State.EATING)
        {
            state[i] = State.EATING;
            self[i].signal();
        }
    }

    public void pickup(int id) {
        lock.lock(); // lock 획득
        try {
            state[id] = State.HUNGRY;
            test(id);

            // id가 식사중이 아니면 대기
            if (state[id] != State.EATING)
                self[id].await();

        } catch (InterruptedException e) {

        } finally { // 반드시 실행
            lock.unlock(); // unlock
        }
    }

    public void putdown(int id) {
        lock.lock();
        try {
            state[id] = State.THINKING;
            test(leftOf(id)); // left neighbor
            test(rightOf(id)); // right neighbor
        } finally {
            lock.unlock();
        }
    }

}
