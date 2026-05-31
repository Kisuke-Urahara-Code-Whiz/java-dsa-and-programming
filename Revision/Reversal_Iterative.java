package Revision;

import Programs.ListNode;

public class Reversal_Iterative {

    public ListNode reversal(ListNode prev, ListNode curr){
        ListNode next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode obj = new ListNode();
        ListNode head = obj.createLinkedList(new int[]{5,4,3,2,1});
        obj.displayLinkedList(new Reversal_Iterative().reversal(null, head));
    }
}
