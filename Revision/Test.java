package Revision;

public class Test {

    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();
        ll.display();
        for (int i = 0; i < 6; i++) {
            ll.insert(i);
        }
        ll.display();
        ll.reversal();
        ll.display();
        for (int i = 0; i < 3; i++) {
            ll.delete();
            ll.display();
        }
    }
}
