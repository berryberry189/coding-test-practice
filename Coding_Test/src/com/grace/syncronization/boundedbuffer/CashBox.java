package com.grace.syncronization.boundedbuffer;

public class CashBox {

    private int[] buffer;
    private int count, in, out;

    public CashBox(int bufferSize) {
        buffer = new int[bufferSize];
        count = in = out = 0;
    }

    // Producer 가 호출
    // Cashbox 의 인스턴스에 대해 monitor lock을 획득한다
    synchronized public void give(int money) throws InterruptedException {
        // critical section
        while (count == buffer.length) {
            try {
                wait(); // 스레드가 모니터 락을 획득하기 위해 기다림
            } catch (InterruptedException e) {}
        }
        buffer[in] = money;
        in = (in + 1) % buffer.length;
        count++;
        System.out.printf("여기있다, 용돈: %d원\n", money);

        // 모니터 락을 기다리고 있는 스레드에게 시그널을 줌
        notify();
    }

    // Customer 가 호출
    // Cashbox 의 인스턴스에 대해 monitor lock을 획득한다
    synchronized public int take() throws InterruptedException {
        // critical section
        while (count == 0) { // empty 가 된 경우
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        int money = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        System.out.printf("고마워유, 용돈: %d원\n", money);


        notify();
        return money;
    }
}


