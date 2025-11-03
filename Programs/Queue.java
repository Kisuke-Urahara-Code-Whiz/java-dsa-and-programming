package Programs;

public class Queue {

    private class Node{
        int value;
        Node next;

        Node(int val){
            this.value = val;
        }
    }

    int size;
    Node front = null;

    public void push(int value){
        if(value<0)
            System.out.println("Invalid Input. Value needs to be a positive integer");
        Node newNode = new Node(value);
        if(front == null){
            front = newNode;
        } else {
            Node temp = front;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int pop(){
        if(front==null){
            System.out.println("Queue is Empty (UnderFlow)");
            return -1;
        } else {
            Node temp = front;
            front = front.next;
            System.out.println(temp.value+" is being popped");
            return temp.value;
        }
    }

    public void peek(){
        if(front==null){
            System.out.println("Queue is Empty (UnderFlow)");
        } else {
            System.out.println("Peek Value -> "+front.value);
        }
    }

    public boolean isEmpty(){
        if(front == null){
            return true;
        }
        return false;
    }

    public void display(){
        if(front !=  null){
            Node temp = front;
            System.out.println("Queue : ");
            System.out.print(temp.value +"(Front) -> ");
            temp = temp.next;
            while (temp != null) {
                System.out.print(temp.value +" -> ");
                temp = temp.next;
            }
        }
        System.out.print("null");
        System.out.println();
    }
}
