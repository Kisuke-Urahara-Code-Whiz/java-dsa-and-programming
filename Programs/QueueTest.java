package Programs;

public class QueueTest extends Queue {

    public static void main(String[] args) {
        QueueTest obj = new QueueTest();
        obj.push(6);
        obj.push(7);
        obj.push(8);
        obj.peek();
        obj.display();
        obj.pop();
        obj.display();
    }
}
