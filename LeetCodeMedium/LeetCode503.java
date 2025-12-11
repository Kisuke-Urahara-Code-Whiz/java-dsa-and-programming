package LeetCodeMedium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        int first = nums[i];
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
                boolean flag = false;
                if(nums[index]<first) {
                    nums[index] = first;
                    flag = true;
                }
                if(!flag) {
                    for (int j = 0; j <= deque.getLast(); j++) {
                        if (nums[j] > nums[index]) {
                            nums[index] = nums[j];
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) nums[index] = -1;
                }
            } else
                nums[index] = -1;
        }
        return nums;
    }

    public static void main(String[] args) {
        new LeetCode503().nextGreaterElements(new int[]{1,2,3,2,1});
    }
}

//        while(!deque.isEmpty()){
//            int index = deque.pop();
//            if(!deque.isEmpty()){
//                nums[index] = nums[deque.getLast()]>nums[index]?nums[deque.getLast()]:-1;
//            } else {
//                nums[index] = -1;
//            }
//        }
