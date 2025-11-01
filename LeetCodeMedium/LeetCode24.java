package LeetCodeMedium;

public class LeetCode24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        ListNode res = new ListNode();
        res.next = head;
        rec(res,head);
        return res.next;
    }

    public void rec(ListNode prev, ListNode current) {
        if (current == null)
            return;
        else if (current.next == null)
            return;
        else {
            prev.next = prev.next.next;
            current.next = current.next.next;
            prev.next.next = current;
            rec(current, current.next);
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
        LeetCode24 obj = new LeetCode24();
        int[] values = {1,2,3,4,5};
        ListNode head = obj.createLinkedList(values);
        System.out.print("Linked List: ");
        obj.displayLinkedList(head);
        System.out.println("Linked List after swapping: ");
        head = obj.swapPairs(head);
        obj.displayLinkedList(head);
    }
}
