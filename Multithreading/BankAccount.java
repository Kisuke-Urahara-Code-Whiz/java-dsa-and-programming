package Multithreading;

public class BankAccount {

    private int balance;

    BankAccount(){
        this.balance = 1000000;
    }

    public synchronized void decrement(){
        this.balance-=1;
    }

    public int getBalance(){
        return this.balance;
    }

}
