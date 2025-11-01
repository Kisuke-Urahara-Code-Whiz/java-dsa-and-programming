package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode143 extends ListNode {

    ListNode l;
    boolean flag = true;

    public void reorderList(ListNode head) {
        l = head;
        reorder(l);
    }

    public void reorder(ListNode curr){
        if(curr!=null){
            reorder(curr.next);
            if(flag){
                if(l==curr){
                    flag = false;
                    l.next = null;
                } else if(l.next==curr){
                    flag = false;
                    l.next.next = null;
                }
                else{
                    curr.next = l.next;
                    l.next = curr;
                    l = curr.next;
                }
            }
        }
    }

}
