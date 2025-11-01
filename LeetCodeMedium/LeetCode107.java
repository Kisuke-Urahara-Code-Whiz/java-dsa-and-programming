package LeetCodeMedium;

import Programs.TreeNode;
import java.util.*;

public class LeetCode107 extends TreeNode {

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        LeetCode107 obj = new LeetCode107();
        TreeNode root = obj.buildTree(arr);
        List<List<Integer>> result = obj.levelOrderBottomLL(root);
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

    public List<List<Integer>> levelOrderBottomLL(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }


            res.addFirst(level);
        }

        return res;
    }

}
