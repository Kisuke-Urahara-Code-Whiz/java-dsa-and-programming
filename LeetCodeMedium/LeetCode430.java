package LeetCodeMedium;

public class LeetCode430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if(head==null) return null;
        Node result = new Node();
        flatten(result, head);
        result.next.prev = null;
        result = result.next;
        return result;
    }

    public Node flatten(Node prev, Node curr) {
        if(curr!=null) {
            prev.next = curr;
            curr.prev = prev;
            Node temp = curr.next;
            Node returnValue = null;
            if (curr.child != null) returnValue = flatten(flatten(curr, curr.child), temp);
            else returnValue = flatten(curr, curr.next);
            curr.child = null;
            return returnValue;
        } else return prev;
    }
}
