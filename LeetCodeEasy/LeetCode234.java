package LeetCodeEasy;

import Programs.ListNode;

public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        else if(head.next.next==null) return head.val==head.next.val;
        int length = -1;
        ListNode node = head;
        while(node!=null){
            length+=1;
            node = node.next;
        }
        length = length/2;
        node = head;
        while(length!=0){
            node=node.next;
            length-=1;
        }
        node.next = reverse(node.next);
        node=node.next;
        while(node!=null){
            if(node.val!=head.val) return false;
            node = node.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
