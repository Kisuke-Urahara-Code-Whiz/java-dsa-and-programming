package Revision;

import Programs.ListNode;

public class ReverseBetween_Iterative {

    public void reversal(ListNode prev, ListNode curr, int left, int right){
        ListNode backupCurr = curr;
        ListNode backupPrev = prev;
        ListNode next;
        while(left<=right){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            left+=1;
        }
        backupPrev.next = prev;
        backupCurr.next = curr;
    }
}
