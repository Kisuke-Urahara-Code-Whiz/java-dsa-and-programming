package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode61 extends ListNode {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        ListNode last = head;
        int l = 1;
        while(last.next!=null){
            last = last.next;
            l+=1;
        }
        l = l - (k%l);
        if(l!=0) {
            boolean flag = true;
            while (flag) {
                if (l - 1 == 0)
                    flag = false;
                else {
                    temp = temp.next;
                    l -= 1;
                }
            }
            ListNode temp1 = head;
            last.next = temp1;
            head = temp.next;
            temp.next = null;
        }
        return head;
    };

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
