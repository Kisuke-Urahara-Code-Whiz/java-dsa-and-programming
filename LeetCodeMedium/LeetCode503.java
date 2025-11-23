package LeetCodeMedium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        deque.push(i++);
        while(i<nums.length){
            while(!deque.isEmpty() && nums[deque.peek()]<nums[i]){
                nums[deque.pop()] = nums[i];
            }
            deque.push(i++);
        }
        while(!deque.isEmpty()){
            int index = deque.pop();
            if(!deque.isEmpty()){
                nums[index] = nums[deque.getLast()]>nums[index]?nums[deque.getLast()]:-1;
            } else {
                nums[index] = -1;
            }
        }
        return nums;
    }

}
