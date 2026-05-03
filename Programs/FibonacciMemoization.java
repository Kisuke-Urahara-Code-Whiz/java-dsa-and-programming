package Programs;

import java.util.Scanner;

public class FibonacciMemoization {

    int arr[];
    int steps = 0;

    FibonacciMemoization(int n) {
        this.arr = new int[n];
        this.arr[0] = 0;
        this.arr[1] = 1;
        for(int i=2;i<n;i++){
            this.arr[i] = -1;
        }
        this.steps = 0;
    }

    public int fibo(int n) {
        if (n == 2) {
            steps += 1;
            arr[n] = arr[n - 1] + arr[n - 2];
            return arr[n];
        } else {
            steps += 1;
            arr[n-1] = arr[n - 1] == -1 ? fibo(n - 1) : arr[n - 1];
            arr[n-2] = arr[n - 2] == -1 ? fibo(n - 2) : arr[n - 2];
            return arr[n-1] + arr[n-2];
        }
    }

    public int fiboRec(int n) {
        if(n==0){
            steps+=1;
            return 0;
        } else if(n==1){
            steps+=1;
            return 1;
        } else {
            steps += 1;
            return fiboRec(n - 1) + fiboRec(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number -> ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("Fibonacci -> 0\n0 steps taken");
        } else if (n == 1) {
            System.out.println("Fibonacci -> 1\n0 steps taken");
        } else {
            FibonacciMemoization obj1 = new FibonacciMemoization(n);
            FibonacciMemoization obj2 = new FibonacciMemoization(n);
            System.out.println("Fibonacci -> " + obj1.fibo(n) + "\n" + obj1.steps + " steps taken");
            System.out.println("Fibonacci -> " + obj2.fiboRec(n) + "\n" + obj2.steps + " steps taken");
        }
    }
}


