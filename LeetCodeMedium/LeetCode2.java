package LeetCodeMedium;

import Programs.ListNode;

public class LeetCode2 extends ListNode {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        reverse(sum(l1, l2, 0),dummy);
        return dummy.next;
    }

    public ListNode reverse(ListNode list, ListNode dummy){
        if(list.next!=null){
            ListNode l = reverse(list.next, dummy);
            l.next = list;
            list.next = null;
        }
        else{
            dummy.next = list;
        }
        return list;
    }

    public ListNode sum(ListNode l1, ListNode l2, int carry) {
        int sum = 0;
        ListNode node = null;
        if (l1 == null && l2 == null) {
            if (carry > 0) return new ListNode(carry);
        } else {
            node = new ListNode(0);
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                node.val = sum % 10;
                node.next = sum(l1.next, l2.next, sum / 10);
            } else if (l1 == null) {
                sum = l2.val + carry;
                node.val = sum % 10;
                node.next = sum(l1, l2.next, sum / 10);
            } else {
                sum = l1.val + carry;
                node.val = sum % 10;
                node.next = sum(l1.next, l2, sum / 10);
            }
        }
        return node;
    }



    public static void main(String[] args) {
        LeetCode2 solution = new LeetCode2();

        int[] arr1 = {9};
        int[] arr2 = {1,9,9,9,9,9,9,9,9,9};

        ListNode l1 = solution.createLinkedList(arr1);
        ListNode l2 = solution.createLinkedList(arr2);

        System.out.print("Input List 1: ");
        printLinkedList(l1);

        System.out.print("Input List 2: ");
        printLinkedList(l2);

        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.print("Result List:  ");
        printLinkedList(result);
    }

    public ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = null;
        ListNode current = null;
        for(int i=0; i<arr.length; i++){
            if(head==null){
                ListNode temp = new ListNode(arr[i]);
                head = temp;
                current = temp;
            }
            else {
                ListNode temp = new ListNode(arr[i]);
                current.next = temp;
                current = temp;
            }
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
