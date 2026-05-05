package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null) return head;
        ListNode temp = new ListNode(0, head);
        ListNode prev = temp;
        ListNode curr = head;
        int index = 1;
        boolean flag = false;
        while(!flag){
            if(index==left){
                flag = true;
                ListNode backupCurr = curr;
                ListNode backupPrev = prev;
                ListNode next;
                while(index<=right){
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    index+=1;
                }
                backupCurr.next = curr;
                backupPrev.next = prev;
            } else {
                prev = curr;
                curr = curr.next;
                index+=1;
            }
        }
        return temp.next;
    }

}
