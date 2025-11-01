package LeetCodeEasy;

public class LeetCode876 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            ListNode res = new ListNode();
            return res;
        }
        int s = 1;
        int f = 1;
        ListNode s1 = head;
        ListNode f1 = head;
        int l = -1;
        do {
            if (l == -1) {
                if (f1.next == null) {
                    l = median(f);
                } else if (f1.next.next == null) {
                    f += 1;
                    l = median(f);
                } else {
                    s += 1;
                    f += 2;
                    s1 = s1.next;
                    f1 = f1.next.next;
                }
            } else {
                s += 1;
                s1 = s1.next;
            }
        }
        while (s != l);
        return s1;
    }

    public int median(int n) {
        if (n % 2 != 0)
            return (n + 1) / 2;
        else
            return (n / 2) + 1;
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
        LeetCode876 obj = new LeetCode876();
        int[] values = {};
        ListNode head = obj.createLinkedList(values);
        System.out.print("Linked List: ");
        obj.displayLinkedList(head);
        System.out.println("Middle Element : ");
        System.out.println(obj.middleNode(head).val);
    }

}
