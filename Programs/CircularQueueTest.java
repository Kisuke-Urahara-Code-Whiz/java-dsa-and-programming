package Programs;

public class CircularQueueTest {

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        q.push(5);
        q.push(3);
        q.push(2);
        q.push(1);
        q.display();
        q.pop();
        q.pop();
        q.display();
        q.pop();
        q.display();
        q.push(10);
        q.display();
        q.pop();
        q.pop();
        q.display();
        q.push(5);
        q.push(3);
        q.push(2);
        q.push(1);
        q.display();
    }
}
