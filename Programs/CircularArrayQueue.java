package Programs;

public class CircularArrayQueue {

    private int[] data;
    private int front;
    private int rear;
    private int size;

    CircularArrayQueue(int size){
        this.size=size;
        data=new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return front==-1;
    }

    public boolean isFull(){
        return front == (rear + 1) % size;
    }

    public void push(int val){
        if (isFull()) {
            System.out.println("Queue is FULL (Overflow)");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % size;
        data[rear] = val;
    }

    public int pop(){
        if (isEmpty()) {
            System.out.println("Queue is EMPTY (Underflow)");
            return -1;
        }

        int value = data[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }

        System.out.println("Dequeued: " + value);
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is EMPTY (Cannot peek)");
            return -1;
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is EMPTY");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(data[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }
}
