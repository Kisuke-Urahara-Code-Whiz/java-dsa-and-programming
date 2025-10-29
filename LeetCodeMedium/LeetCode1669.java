package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode1669 extends ListNode {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6};
        int[] arr2 = {1000000,1000001,1000002,1000003,1000004};
        LeetCode1669 obj = new LeetCode1669();
        ListNode head = obj.createLinkedList(arr);
        ListNode head2 = obj.createLinkedList(arr2);
        obj.displayLinkedList(obj.mergeInBetween(head,2,5,head2));
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = new ListNode(0,list1);
        ListNode temp = res;
        ListNode p1;
        b = b-a;

        while(a!=0){
            temp = temp.next;
            a-=1;
        }

        p1 = temp.next;
        temp.next = list2;

        while(temp.next!=null){
            temp = temp.next;
        }

        while(b!=0){
            p1 = p1.next;
            b-=1;
        }

        temp.next = p1.next;
        return res.next;
    }
}
