package LeetCodeMedium;

// Front -> Rear , means its empty
// Rear -> Front, means its full
// Insertion -> base criteria not full
// Deletion -> base criteria not empty

public class LeetCode622 {

    int flag;
    int front;
    int rear;
    int[] arr;
    int length;

    public LeetCode622(int k) {

        this.flag = -1;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[k];
        this.length = k;

    }

    public boolean enQueue(int value) {
        if(!isFull()){
            arr[rear] = value;
            rear = (rear+1)%length;
            flag = rear==front? 1 : 0;
            return true;
        } return false;
    }

    public boolean deQueue() {
        if(!isEmpty()){
            front = (front+1)%length;
            flag = front==rear? -1 : 0;
            return true;
        } return false;
    }

    public int Front() {
        return isEmpty()? -1 : arr[front];
    }

    public int Rear() {
        return isEmpty()? -1: arr[((rear-1)+length)%length];
    }

    public boolean isEmpty() {
        return flag==-1;
    }

    public boolean isFull() {
        return flag==1;
    }

}
