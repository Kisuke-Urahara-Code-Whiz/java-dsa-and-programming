package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Wallet {

    private final Lock lock;
    private int balance;

    public Wallet() {
        this.lock = new ReentrantLock(true);
        this.balance = 10000;
    }

    public int getBalance(){
        return this.balance;
    }

    public boolean withdraw(){
        boolean lockAcquired = false;
        if(lock.tryLock()){
            lockAcquired = true;
            this.balance-=500;
            lock.unlock();
        }
        return lockAcquired;
    }
}
