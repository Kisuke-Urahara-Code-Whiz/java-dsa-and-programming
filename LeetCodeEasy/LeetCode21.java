package LeetCodeEasy;

public class LeetCode21 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = null;
        if(p1!=null || p2!=null) {
            head = new ListNode();
            if (p1 == null && p2 != null) {
                head = p2;
                p2 = p2.next;
            } else if (p1 != null && p2 == null) {
                head = p1;
                p1 = p1.next;
            } else {
                if (p1.val < p2.val) {
                    head = p1;
                    p1 = p1.next;
                } else {
                    head = p2;
                    p2 = p2.next;
                }
            }
            merge(p1, p2, head);
        }
        return head;
    }

    public void merge(ListNode p1, ListNode p2, ListNode temp){
        if(p1!=null || p2!=null){
            if(p1==null){
                temp.next = p2;
                p2 = p2.next;
            }
            else if(p2==null){
                temp.next = p1;
                p1 = p1.next;
            }
            else{
                if(p1.val < p2.val){
                    temp.next = p1;
                    p1 = p1.next;
                }
                else{
                    temp.next = p2;
                    p2 = p2.next;
                }
            }
            merge(p1,p2,temp.next);
        }
    }

    public ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public void displayLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LeetCode21 obj = new LeetCode21();

        int[] values = {};
        int[] values2 = {};

        ListNode head1 = obj.createLinkedList(values);
        ListNode head2 = obj.createLinkedList(values2);
        System.out.print("Linked List 1 : ");
        obj.displayLinkedList(head1);
        System.out.print("Linked List 2 : ");
        obj.displayLinkedList(head2);
        ListNode sorted = obj.mergeTwoLists(head1,head2);
        System.out.println("Sorted Linked List");
        obj.displayLinkedList(sorted);
    }

}
