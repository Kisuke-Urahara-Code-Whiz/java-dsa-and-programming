package Multithreading;

public class Threads_1 {

    public static void main(String[] args) throws InterruptedException {
        BankAccount account1 = new BankAccount();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 500000; i++) {
                    account1.decrement();
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 500000; i++) {
                    account1.decrement();
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(account1.getBalance());
    }

}
