package com.grace.syncronization.boundedbuffer;

public class BoundedBuffer {
    public static void main(String[] args) {
        CashBox cashBox = new CashBox(5);
        Thread[] producers = new Thread[5];
        Thread[] consumers = new Thread[5]; // Create threads of producers
        for (int i = 0; i < producers.length; i++) {
            producers[i] = new Thread(new ProdRunner(cashBox));
            producers[i].start();
        }
        // Create threads of consumers
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Thread(new ConsRunner(cashBox));
            consumers[i].start();
        } }
}
