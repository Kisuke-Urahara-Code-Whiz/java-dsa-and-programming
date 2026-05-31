package Revision;

import Programs.ListNode;

public class Reversal_Recursive {

    public ListNode reversal(ListNode dummy, ListNode curr){
        if(curr.next==null) dummy.next = curr;
        else{
            ListNode prev = reversal(dummy, curr.next);
            prev.next = curr;
            curr.next = null;
        }
        return curr;
    }

    public static void main(String[] args) {
        ListNode obj = new ListNode();
        ListNode head = obj.createLinkedList(new int[]{5,4,3,2,1});
        ListNode dummy = new ListNode(0, head);
        new Reversal_Recursive().reversal(dummy, head);
        obj.displayLinkedList(dummy.next);
    }

}
