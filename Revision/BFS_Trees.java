package Revision;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Trees {

     static class TreeNode{

        int value;
        TreeNode left;
        TreeNode right;

    }

    public void traversal(TreeNode root){
         if(root!=null) {
             Queue<TreeNode> queue = new LinkedList<>();
             queue.add(root);
             int levelLength = queue.size();
             while (!queue.isEmpty()) {
                 while (levelLength != 0) {
                     TreeNode temp = queue.poll();
                     System.out.print(temp.value + " ");
                     if (temp.left != null) queue.add(temp.left);
                     if (temp.right != null) queue.add(temp.right);
                     levelLength -= 1;
                 }
                 levelLength = queue.size();
                 System.out.println();
             }
         }
    }
}
