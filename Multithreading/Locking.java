package Multithreading;

public class Locking {

    public static void main(String[] args) throws InterruptedException {
        Wallet wallet = new Wallet();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while(i!=10) {
                    boolean flag = wallet.withdraw();
                    if (flag) {
                        System.out.println("Transaction " + i + " of " + Thread.currentThread().getName() + " took place ");
                        i += 1;
                    } else
                        System.out.println("Transaction " + i + " of " + Thread.currentThread().getName() + " failed ");
                }
                System.out.println(Thread.currentThread().getName() + " has finished all transactions");
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while(i!=10) {
                    boolean flag = wallet.withdraw();
                    if (flag) {
                        System.out.println("Transaction " + i + " of " + Thread.currentThread().getName() + " took place ");
                        i += 1;
                    } else
                        System.out.println("Transaction " + i + " of " + Thread.currentThread().getName() + " failed ");
                }
                System.out.println(Thread.currentThread().getName() + " has finished all transactions");
            }
        };

        Thread t1 = new Thread(r1, "Thread 1");
        Thread t2 = new Thread(r2, "Thread 2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Account Balance -> "+wallet.getBalance());
    }
}
