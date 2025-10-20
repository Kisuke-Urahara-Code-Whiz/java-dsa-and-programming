package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode86 extends ListNode {

    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0,head);
        ListNode l = res;
        ListNode prev = res;
        ListNode curr = res.next;
        while(curr!=null){
            if(curr.val<x){
                if(l==prev){
                    l = curr;
                    prev = l;
                    curr = l.next;
                } else {
                    prev.next = curr.next;
                    curr.next = l.next;
                    l.next = curr;
                    l = l.next;
                    curr = prev.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return res.next;
    }

}
