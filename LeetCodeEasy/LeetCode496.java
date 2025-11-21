package LeetCodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i = 1;
        while(i<nums2.length){
            while(!stack.isEmpty() && nums2[stack.peek()]<nums2[i]){
                int index = stack.pop();
                map.put(nums2[index],index);
                nums2[index] = nums2[i];
            }
            stack.push(i);
            i+=1;
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            map.put(nums2[index],index);
            nums2[index] = -1;
        }
        for(int j=0;j<nums1.length;j++){
            nums1[j] = nums2[map.get(nums1[j])];
        }
        return nums1;
    }

    public static void main(String[] args) {
        System.out.println("Answer -> "+ Arrays.toString(new LeetCode496().nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2})));
    }

}
