package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode61 extends ListNode {

    public ListNode rotateRight(ListNode head, int k) {
        return null;
    }

    private int findLength(ListNode node){
        ListNode temp = node;
        int l = 0;
        while(temp!=null){
            l+=1;
            temp = temp.next;
        }
        return l;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        LeetCode61 obj = new LeetCode61();
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        int k = 2;
        head = obj.rotateRight(head, k);
        System.out.println("Linked List rotating by k -> ");
        obj.displayLinkedList(head);
    }

}
