package LeetCodeMedium;

import Programs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 extends TreeNode {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root!=null) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            path(root, targetSum-root.val, temp);
        }
        return result;
    }

    private void path(TreeNode root, int targetSum, List<Integer> temp){
        if(targetSum==0 && root.left==null && root.right==null){
            result.add(new ArrayList<>(temp));
            temp.removeLast();
        }
        else{
            boolean flag = false;
            if(root.left!=null){ temp.add(root.left.val); path(root.left, targetSum-root.left.val, temp); }
            if(root.right!=null && !flag){ temp.add(root.right.val); path(root.right, targetSum-root.right.val, temp); }
            temp.removeLast();
        }
    }
}
