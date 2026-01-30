package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Wallet2 {

    private final Lock lock;
    private int balance;

    public Wallet2() {
        this.lock = new ReentrantLock();
        this.balance = 10000;
    }

    public int getBalance(){
        return this.balance;
    }

    public void withdraw(){
        lock.lock();
        this.balance-=500;
        lock.unlock();
    }
}

