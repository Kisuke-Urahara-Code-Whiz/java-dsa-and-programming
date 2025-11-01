package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode2181 extends ListNode {

    public ListNode mergeNodes(ListNode head) {
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        int s = 0;
        while (temp2 != null) {
            if (temp2.val != 0) {
                s += temp2.val;
                temp2 = temp2.next;
            } else {
                temp1.val = s;
                if(temp2.next==null) {
                    temp1.next = null;
                    temp2 = null;
                }
                else {
                    temp1.next = temp2;
                    s = 0;
                    temp1 = temp1.next;
                    temp2 = temp1.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,3,1,0,4,5,2,0};
        LeetCode2181 obj = new LeetCode2181();
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        System.out.println("Linked List after operation -> ");
        head = obj.mergeNodes(head);
        obj.displayLinkedList(head);
    }
}

