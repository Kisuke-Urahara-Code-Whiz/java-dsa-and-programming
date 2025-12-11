package LeetCodeMedium;

import Programs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 extends TreeNode {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sets = new ArrayList<>();
        if(root==null)
            return res;
        sets.add(root.val);
        sum(res,sets,root,root.val, targetSum);
        return res;
    }

    private void sum(List<List<Integer>> res, List<Integer> sets, TreeNode curr, int sum, int targetSum){
        if(curr.left==null && curr.right==null){
            if(sum==targetSum)
                res.add(new ArrayList<>(sets));
        } else {
            if(curr.left!=null) {
                sets.add(curr.left.val);
                sum(res,sets,curr.left,sum+curr.left.val, targetSum);
                sets.removeLast();
            }
            if(curr.right!=null) {
                sets.add(curr.right.val);
                sum(res,sets,curr.right,sum+curr.right.val, targetSum);
                sets.removeLast();
            }
        }
    }
}
