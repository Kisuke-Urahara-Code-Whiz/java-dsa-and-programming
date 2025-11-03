package Programs;

public class CircularQueue {

    private class Node{
        int data;
        Node next;

        Node(int val){
            data = val;
        }

        Node(int val, Node next){
            data = val;
            this.next = next;
        }
    }

    private Node front;
    private Node rear;

    public void push(int value){
        Node newNode = new Node(value);
        if(front==null){
            front = newNode;
            front.next = rear;
        } else if(rear==null){
            rear = newNode;
            rear.next = front;
            rear.next.next = rear;
        } else {
            rear.next = newNode;
            rear = rear.next;
            rear.next = front;
        }
    }

    public int pop(){
        if(front == null){
            System.out.println("Queue is empty");
            return -1;
        } else if(front==rear){
            int a = front.data;
            front = null;
            rear = null;
            return a;
        } else {
            int a = front.data;
            front = front.next;
            rear.next = front;
            return a;
        }
    }

    public void getFront(){
        if(front == null){
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front Node -> "+front.data);
        }
    }

    public void getRear(){
        if(front == null){
            System.out.println("Queue is empty");
        } else if(rear == null){
            System.out.println("Rear Node -> "+front.data);
        }  else {
            System.out.println("Rear Node -> "+rear.data);
        }
    }

    public void isEmpty(){
        if(front == null){
            System.out.println("Queue is empty");
        }
    }

    public void display(){
        if(front == null){
            System.out.println("Queue is empty");
        } else if(rear == null || front == rear){
            System.out.println("Queue\n"+front.data+"(Front)(Back)");
        } else {
            System.out.print("Queue\n"+front.data+"(Front) -> ");
            Node temp = front.next;
            while(temp!=front){
                if(temp==rear){
                    System.out.print(rear.data+"(Rear) -> ");
                } else {
                    System.out.print(temp.data + " -> ");
                }
                temp=temp.next;
            }
            System.out.println("Null");
        }
    }
}
