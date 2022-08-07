package com.grace.syncronization.boundedbuffer;

public class SharedDB {

    private int readerCount  = 0;
    private boolean isWriting = false;
    public void read() {
        // read from the database here.
        acquireReadLock();
        read();
        releaseReadLock();
    }
    public void write() {
        // write into the database here.
        acquireWriteLock();
        write();
        releaseWriteLock();
    }

    synchronized public void acquireReadLock() {
        while (isWriting == true) {
            try { wait();
            } catch (InterruptedException e) {}
        }
        readerCount++; }
    synchronized public void releaseReadLock() {
        readerCount--;
        if (readerCount == 0)
            notify();
    }

    synchronized public void acquireWriteLock() {
        while (readerCount > 0 || isWriting == true) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        isWriting = true;
    }
    synchronized public void releaseWriteLock() {
        isWriting = true;
        // 모든 기다리고 있는 스레드에게 다 시그널을 줘서 깨움
        notifyAll();
    }

}
