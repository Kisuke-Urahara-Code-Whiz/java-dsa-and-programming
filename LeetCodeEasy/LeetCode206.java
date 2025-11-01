package LeetCodeEasy;

public class LeetCode206 {


     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
        LeetCode206 obj = new LeetCode206();
        int[] values = {1,2,3,4,5};
        ListNode head = obj.createLinkedList(values);
        System.out.print("Linked List: ");
        obj.displayLinkedList(head);
        System.out.println("Linked List after Reversing: ");
        head = obj.reverseList(head);
        obj.displayLinkedList(head);
    }

    public ListNode reverseList(ListNode head) {
         if(head==null)
             return head;
         else if(head.next==null)
             return head;
         else{
             ListNode current = head;
             ListNode next = head.next;
             head = reverseList(head.next);
             next.next = current;
             current.next = null;
             return head;
         }
    }

}
