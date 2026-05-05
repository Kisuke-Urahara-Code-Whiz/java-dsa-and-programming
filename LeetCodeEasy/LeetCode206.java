package LeetCodeEasy;

import Programs.ListNode;

public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0, head);
        reversal(dummy, head);
        return dummy.next;
    }

    public ListNode reversal(ListNode dummy, ListNode curr){
        if(curr.next==null) dummy.next = curr;
        else{
            ListNode prev = reversal(dummy, curr.next);
            prev.next = curr;
            curr.next = null;
        }
        return curr;
    }

}
