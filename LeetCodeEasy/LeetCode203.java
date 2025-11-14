package LeetCodeEasy;

import Programs.ListNode;

public class LeetCode203 extends ListNode {

    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        ListNode temp = new ListNode(-1,head);
        ListNode res = temp;
        while(head!=null){
            while(head!=null && head.val==val){
                head =  head.next;
            }
            if(head!=null){
                temp.next = head;
                temp = temp.next;
                head = head.next;
            }
        }
        if(temp.next!=null && temp.next.val==val)
            temp.next = null;
        return res.next;
    }

    public static void main(String[] args) {
        LeetCode203 obj = new LeetCode203();
        ListNode head = obj.createLinkedList(new int[]{1,2,6,3,4,5,6});
        obj.displayLinkedList(obj.removeElements(head,6));
    }
}
