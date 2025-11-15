package LeetCodeEasy;

import Programs.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode160 extends ListNode {

    Set<ListNode> set = new HashSet<>();
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        while(temp!=null){
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(!set.contains(temp)){
            temp = temp.next;
        }
        return temp;
    }
}
