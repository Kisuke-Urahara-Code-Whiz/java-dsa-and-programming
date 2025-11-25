package LeetCodeMedium;

public class LeetCode430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if(head==null)
            return null;
        traversal(head);
        return head;
    }

    private Node traversal(Node curr){
        Node temp = curr;
        while(curr!=null){
            if(curr.child!=null){
                temp = curr.next;
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
                curr = traversal(curr.next);
                curr.next = temp;
                if(temp!=null) temp.prev = curr;
            }
            temp = curr;
            curr = curr.next;
        }
        return temp;
    }
}
