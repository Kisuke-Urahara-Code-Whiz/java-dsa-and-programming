package LeetCodeMedium;

import Programs.TreeNode;

import java.util.*;

public class LeetCode437 extends TreeNode {

    int result = 0;
    HashMap<Long, Integer> map = new HashMap<>();
    List<Long> prefixSum = new ArrayList<>();

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        List<Long> path = new ArrayList<>();
        prefixSumOps((long)0, -1, (long)targetSum);
        preorder(root, 0, (long)targetSum);
        return result;
    }

    private void preorder(TreeNode node, int index, long targetSum){
        if(node.left==null && node.right==null){
            prefixSumOps((long)node.val, index, targetSum);
            map.put(prefixSum.getLast(), map.get(prefixSum.getLast())-1);
            prefixSum.removeLast();
        } else {
            prefixSumOps((long)node.val, index, targetSum);
            if(node.left!=null) preorder(node.left, index+1, targetSum);
            if(node.right!=null) preorder(node.right, index+1, targetSum);
            map.put(prefixSum.getLast(), map.get(prefixSum.getLast())-1);
            prefixSum.removeLast();
        }
    }

    private void prefixSumOps(long l, int index, long targetSum){
        if(index==-1) prefixSum.add(l);
        else prefixSum.add(prefixSum.get(index)+l);
        long needed = prefixSum.getLast()-targetSum;
        result+=map.getOrDefault(needed,0);
        map.put(prefixSum.getLast(),map.getOrDefault(prefixSum.getLast(),0)+1);
    }

    static void main(){
        LeetCode437 obj = new LeetCode437();
        TreeNode root = obj.buildTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println("Answer -> "+obj.pathSum(root,8));
    }
}