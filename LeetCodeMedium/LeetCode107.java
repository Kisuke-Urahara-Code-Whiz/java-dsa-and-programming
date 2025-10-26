package LeetCodeMedium;

import Programs.TreeNode;
import java.util.*;

public class LeetCode107 extends TreeNode {

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        LeetCode107 obj = new LeetCode107();
        TreeNode root = obj.buildTree(arr);
        List<List<Integer>> result = obj.levelOrderBottom(root);
        System.out.println(result);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        List<Integer> levelLengths = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> lengthStack = new Stack<>();
        queue.add(root);
        int levelLength = queue.size();
        while(levelLength!=0){
            lengthStack.push(levelLength);
            for(int i=1;i<=levelLength;i++){
                TreeNode node = queue.poll();
                stack.push(node);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            levelLength = queue.size();
        }
        while(!lengthStack.isEmpty()){
            int l = lengthStack.pop();
            List<Integer> levelList = new ArrayList<>(l);
            for(int i=0;i<l;i++){
                levelList.add(null);
            }
            for(int j=l-1;j>=0;j--){
                levelList.set(j,stack.pop().val);
            }
            res.add(levelList);
        }
        return res;
    }

}
