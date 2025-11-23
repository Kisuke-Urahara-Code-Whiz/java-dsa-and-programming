package LeetCodeEasy;

import Programs.TreeNode;

public class LeetCode112 extends TreeNode {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root!=null){
            boolean flag = root.left==null && root.right==null && root.val==targetSum;
            if(!flag) {
                flag = sum(root.left, targetSum, root.val);
                flag = flag || sum(root.right, targetSum, root.val);
            }
            return flag;
        }
        return false;
    }

    public boolean sum(TreeNode root, int targetSum, int sum) {
        if(root!=null){
            sum = sum+root.val;
            boolean flag = root.left!=null?sum(root.left,targetSum,sum): root.right == null && sum == targetSum;
            flag = flag || (root.right != null && sum(root.right, targetSum,sum));
            return flag;
        } else {
            return false;
        }
    }

}
