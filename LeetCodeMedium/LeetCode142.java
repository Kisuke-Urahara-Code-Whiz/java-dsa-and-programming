//Linked ListCycle ->
//1. Detection
//2. Length of the cycle
//3. Start of the cycle

//3. Approaches
//A1 -> slow and fast meets, then slow to slow.next and head to head.next till slow==head, return head when met or slow
//A2 -> Find length of the cycle , p1 and p2 -> at head, move p2 ahead by l times, p1 to p1.next and p2 to p2.next
//till p1==p2, then return p1

package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode142 extends ListNode {
    public ListNode detectCycle(ListNode head) {
        int cycle;
        int l = 0;
        ListNode s = head, f = head;
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if(s==f){
                while(s!=head){
                    s = s.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
