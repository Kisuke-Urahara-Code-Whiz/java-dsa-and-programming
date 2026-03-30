package Revision;

public class DoublyLL {

    int size;
    Node top;

    private class Node {

        int val;
        Node prev;
        Node next;

        Node(int val){
            this.val = val;
        }

        Node(int val, Node prev, Node next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

    }

    DoublyLL(){
        this.size = 0;
        this.top = null;
    }

    public void insert(int x){
        if(top==null){
            top = new Node(x);
        } else {
            Node temp = top;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new Node(x, temp, null);
        }
        size+=1;
    }

    public void delete(){
        if(top!=null){
            Node temp = top;
            while(temp.next!=null){
                temp = temp.next;
            }
            if(temp.prev!=null) temp.prev.next = null;
            else top = null;
            size-=1;
        }
    }

    public void display(){
        System.out.println("Doubly LL -> ");
        if(size==0) System.out.println("Empty Doubly Linked List");
        else{
            Node temp = top;
            System.out.print(temp.val);
            temp = temp.next;
            while(temp!=null){
                System.out.print(" -> "+temp.val);
                temp = temp.next;
            }
            System.out.print(" -> NULL");
            System.out.println();
        }
    }

    public void reversal(){
        if(top!=null){
            Node prev = null;
            Node next = top.next;
            Node temp = top;
            while(temp!=null){
                Node temp1 = temp.next;
                temp.next = temp.prev;
                temp.prev = temp1;
                if(temp1==null) top = temp;
                temp = temp1;
            }

        }
    }

}
