package Programs;

public class CircularQueueTest {

    public static void main(String[] args) {
        CircularArrayQueue q = new CircularArrayQueue(5);
        q.push(5);
        q.display();
        q.push(6);
        q.push(7);
        q.push(8);
        q.push(9);
        q.display();
        q.push(10);
        q.display();
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.push(11);
        q.display();
        q.pop();
        q.pop();
        q.display();
    }
}
