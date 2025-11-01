package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode82 extends ListNode {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode res = new ListNode(-101);
        delete(head, head.next, res, -101);
        return res.next;
    }

    public void delete(ListNode prev, ListNode curr, ListNode ll, int preval){
        if(curr!=null){
            if(prev.val!=curr.val && prev.val!=preval){
                ll.next = prev;
                ll = ll.next;
            }
            preval = prev.val;
            delete(curr,curr.next,ll,preval);
        } else {
            if(prev.val!=preval){
                ll.next = prev;
                ll = ll.next;
            } else {
                ll.next = null;
            }
        }

    }

}
