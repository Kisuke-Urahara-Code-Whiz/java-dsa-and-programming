package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode61 {

//    Reverse and Partition Reverse

//    public ListNode rotateRight(ListNode head, int k) {
//        int length = findLength(head);
//        k = k%length;
//        ListNode dummy = new ListNode(0, head);
//        reverseBetween(dummy, head, 1, length);
//        reverseBetween(dummy, dummy.next, 1, k);
//        ListNode temp = dummy.next;
//        int remainingCount = length-k;
//        while(k-1!=0){
//            temp = temp.next;
//            k = k-1;
//        }
//        reverseBetween(temp, temp.next, 1, remainingCount);
//        return dummy.next;
//    }
//
//    public void reverseBetween(ListNode prev, ListNode curr, int left, int right) {
//        ListNode backupCurr = curr;
//        ListNode backupPrev = prev;
//        ListNode next;
//        while(left<=right){
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//            left+=1;
//        }
//        backupCurr.next = curr;
//        backupPrev.next = prev;
//    }
//
//    private int findLength(ListNode node){
//        ListNode temp = node;
//        int l = 0;
//        while(temp!=null){
//            l+=1;
//            temp = temp.next;
//        }
//        return l;
//    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head!=null) {
            ListNode temp = head;
            ListNode last = head;
            int l = 1;
            while (last.next != null) {
                last = last.next;
                l += 1;
            }
            l = l - (k % l);
            if (l != 0) {
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
        }
        return head;
    };

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        ListNode obj = new ListNode();
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        int k = 2;
        head = new LeetCode61().rotateRight(head, k);
        System.out.println("Linked List rotating by k -> ");
        obj.displayLinkedList(head);
    }

}
