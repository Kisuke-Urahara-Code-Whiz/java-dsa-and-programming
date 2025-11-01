package LeetCodeEasy;

import Programs.ListNode;

public class Leetcode141 extends ListNode {
    public boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        do{
            if(f==null)
                return false;
            else if(f.next==null)
                return false;
            else{
                s = s.next;
                f = f.next.next;
            }
            if(s==f)
                return true;
        } while(true);
    }
}
