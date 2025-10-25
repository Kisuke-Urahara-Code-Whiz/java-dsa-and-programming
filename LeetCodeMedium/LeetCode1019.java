//Correction needed
package LeetCodeMedium;

import Programs.ListNode;

import java.util.Arrays;

public class LeetCode1019 extends ListNode {

    int[] arr;
    int max;
    int nMax;

    public int[] nextLargerNodes(ListNode head) {
        find(head,0);
        return arr;
    }

    public void find(ListNode curr, int l){
        if(curr == null){
            arr = new int[l];
        } else {
            find(curr.next,l+1);
            if(curr.next == null){
                max = curr.val;
                nMax = curr.val;
                arr[l] = 0;
            } else {
                if(curr.val < nMax){
                    arr[l] = nMax;
                } else if(curr.val < max){
                    arr[l] = max;
                } else {
                    max = curr.val;
                    arr[l] = 0;
                }
                if(curr.val>nMax){
                    max = nMax;
                    nMax = curr.val;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode1019 obj = new LeetCode1019();
        int[] arr = new int[]{4,3,2,5,1,8,10};
        ListNode head = obj.createLinkedList(arr);
        System.out.println("Linked List -> ");
        obj.displayLinkedList(head);
        System.out.println("Resultant Array -> "+ Arrays.toString(obj.nextLargerNodes(head)));
    }
}
