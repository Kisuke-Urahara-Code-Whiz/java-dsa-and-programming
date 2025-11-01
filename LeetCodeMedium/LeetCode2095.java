package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode2095 extends ListNode {

    public ListNode deleteMiddle(ListNode head) {
        ListNode res = new ListNode(0,head);
        ListNode prev = null;
        ListNode curr = res;
        ListNode fp = curr;
        int a = -1;
        int b = 0;
        boolean flag1 = true;
        boolean flag2 = true;
        while(flag1 || flag2){
            if(flag1){
                if(fp==null){
                    b-=1;
                    flag1 = false;
                } else if(fp.next==null) {
                    flag1 = false;
                } else {
                    fp = fp.next.next;
                    b+=2;
                }
            }
            if(flag2){
                if(!flag1 && b/2==a){
                    prev.next = curr.next;
                    flag2 = false;
                } else {
                    prev = curr;
                    curr = curr.next;
                    a+=1;
                }
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1};
        LeetCode2095 obj = new LeetCode2095();
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        System.out.println("Linked List after operation -> ");
        head = obj.deleteMiddle(head);
        obj.displayLinkedList(head);
    }

}
