package LeetCodeMedium;

public class LeetCode198_BruteForce_O2pn {

    int max = -1;

    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        else {
            boolean[] used = new boolean[nums.length];
            for (int i = 0; i < nums.length; i++) {
                used[i] = true;
            }
            backtrack(nums, used, 0);
            return max;
        }
    }

    public void backtrack(int[] nums, boolean[] used, int sum) {
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                if (i + 1 == nums.length) {
                    int a = 0;
                    if (!used[i - 1])
                        a = 1;
                    used[i] = used[i - 1] = false;
                    sum += nums[i];
                    backtrack(nums, used, sum);
                    sum -= nums[i];
                    if (a == 0)
                        used[i - 1] = true;
                    used[i] = true;
                } else if (i == 0) {
                    int a = 0;
                    if (!used[i + 1])
                        a = 1;
                    used[i] = used[i + 1] = false;
                    sum += nums[i];
                    backtrack(nums, used, sum);
                    sum -= nums[i];
                    if (a == 0)
                        used[i + 1] = true;
                    used[i] = true;
                } else {
                    int a = 0;
                    int b = 0;
                    if (!used[i + 1])
                        a = 1;
                    if (!used[i - 1])
                        b = 1;
                    used[i] = used[i + 1] = used[i - 1] = false;
                    sum += nums[i];
                    backtrack(nums, used, sum);
                    sum -= nums[i];
                    if (a == 0)
                        used[i + 1] = true;
                    if (b == 0)
                        used[i - 1] = true;
                    used[i] = true;
                }
            }
        }
        if (sum > max) {
            max = sum;
        }
    }
}
