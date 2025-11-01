package LeetCodeEasy;

import Programs.ListNode;

public class LeetCode206_NoRec extends ListNode {

    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        boolean flag = true;
        ListNode temp;
        ListNode prev = head;
        ListNode curr = head.next;
        while(flag){
            if(curr==null){
                head.next = curr;
                head = prev;
                flag = false;
            } else {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
        }
        return head;
    }

}
