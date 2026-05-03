package Revision;

import java.util.Scanner;

public class SinglyLL {

    private class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }

        Node(Node node){
            this.val = node.val;
            this.next = node.next;
        }
    }

    private Node root;

    public Node getRoot(){
        return root;
    }

    public void setRoot(int val){
        root = new Node(val);
    }

    SinglyLL(){
        root = null;
    }

    public void insert(int val){
        if(root==null)  setRoot(val);
        else{
            Node node = root;
            boolean flag = true;
            while(flag){
                if(node.next==null){
                    node.next = new Node(val);
                    flag = false;
                } else node = node.next;
            }
        }
    }

    public void insertRec(int val, Node node){
        if(node.next==null) node.next = new Node(val);
        else insertRec(val, node.next);
    }

    public Node delete(){
        if(root==null){
            System.out.println("Empty Linked List");
            return null;
        }
        if(root.next==null){
            Node delete = root;
            root = null;
            return delete;
        }
        Node delete = null;
        Node node = root;
        while(node.next.next!=null){
            node = node.next;
        }
        delete = node.next;
        node.next = null;
        return delete;
    }

    public int getSize(){
        if(root==null) return 0;
        Node node = root;
        int size = 0;
        boolean flag = true;
        while(flag){
            size+=1;
            if(node.next==null) flag = false;
            else node = node.next;
        }
        return size;
    }

    public void insertAtAnyPos(int val, int pos){
        if(root==null) System.out.println("Invalid Position");
        else if(pos==0) root = new Node(val, root);
        else{
            int index = 0;
            Node node = root;
            while(true){
                if(node == null) break;
                else if(index+1==pos){
                    if(node.next!=null){
                        node.next = new Node(val, node.next);
                        index+=1;
                    } else System.out.println("Invalid Index");
                    break;
                } else {
                    node = node.next;
                    index+=1;
                }
            }
            if(index!=pos) System.out.println("Invalid Index");
        }
    }

    public Node deleteAtAnyPos(int pos){
        Node delete = null;
        if(root==null) System.out.println("Empty Linked List");
        else if(pos==0){
            delete = root;
            root = root.next;
        } else {
            int index = 0;
            Node node = root;
            while(true){
                if(node==null) break;
                if(index+1==pos){
                    if(node.next!=null){
                        delete = node.next;
                        node.next = node.next.next;
                        index+=1;
                    } break;
                } else {
                    node = node.next;
                    index+=1;
                }
            }
            if(index!=pos) System.out.println("Invalid Index");
        }
        return delete;
    }

    public void reversal(){
        if(root==null) System.out.println("No reversal");
        else {
            Node prev = null;
            Node curr = root;
            Node next = root.next;
            while(next!=null){
                curr.next= prev;
                prev = curr;
                curr = next;
                next = curr.next;
            }
            root = curr;
            root.next = prev;
        }
    }

    public void reversalRec(){
        if(root==null) System.out.println("No reversal");
        else reverse(null, root);
    }

    private Node reverse(Node prev, Node curr){
        if(curr==null){
            root = prev;
            return prev;
        } else {
            Node next = reverse(curr, curr.next);
            next.next = curr;
            curr.next = null;
            return curr;
        }
    }

    public void display(){
        if(root==null) System.out.println("Empty Linked List");
        else{
            Node node = root;
            while(true){
                if(node==null) break;
                System.out.print(node.val+" -> ");
                node = node.next;
            }
            System.out.print("null");
        }
    }

    public static void main(String[] args) {
        SinglyLL ll = new SinglyLL();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("a) Get Root ");
            System.out.println("b) Get Size ");
            System.out.println("c) Insert Element");
            System.out.println("d) Insert Element via Recursion");
            System.out.println("e) Insert Element at Any Position");
            System.out.println("f) Delete Element");
            System.out.println("g) Delete Element at Any Position");
            System.out.println("h) Display Linked List");
            System.out.println("i) Reversal");
            System.out.println("j) Recursive Reversal");
            System.out.println("x) Exit");
            System.out.println("Enter choice -> ");
            char c = ' ';
            c = sc.nextLine().charAt(0);
            int ele;
            Node delete;
            switch(c){
                case 'a' :
                    System.out.println("Root -> "+ll.getRoot());
                    break;

                case 'b' :
                    System.out.println("Size of the Linked List -> "+ll.getSize());
                    break;

                case 'c' :
                    System.out.println("Enter element -> ");
                    ele = sc.nextInt();
                    sc.nextLine();
                    ll.insert(ele);
                    break;

                case 'd' :
                    System.out.println("Enter element -> ");
                    ele = sc.nextInt();
                    sc.nextLine();
                    if(ll.getRoot()==null) ll.setRoot(ele);
                    else ll.insertRec(ele, ll.getRoot());
                    break;

                case 'e' :
                    System.out.println("Enter element -> ");
                    ele = sc.nextInt();
                    System.out.println("Enter position -> ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    ll.insertAtAnyPos(ele, pos);
                    break;

                case 'f' :
                    delete = ll.delete();
                    if(delete!=null) System.out.println("Deleted Node -> "+delete.val);
                    break;

                case 'g':
                    System.out.println("Enter position -> ");
                    int p = sc.nextInt();
                    sc.nextLine();
                    delete = ll.deleteAtAnyPos(p);
                    if(delete!=null) System.out.println("Deleted Node -> "+delete.val);
                    break;

                case 'h':
                    ll.display();
                    System.out.println();
                    break;

                case 'i':
                    ll.reversal();
                    break;

                case 'j':
                    ll.reversalRec();
                    break;

                case 'x':
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
