package LeetCodeEasy;

import Programs.TreeNode;
import java.util.*;

public class LeetCode993 extends TreeNode {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelLength = queue.size();
        while(!queue.isEmpty()){
            int a = 0;
            for(int i=1;i<=levelLength;i++){
                int sameParent = 0;
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    if(curr.left.val==x || curr.left.val==y){
                        if(a==0){
                            sameParent = 1;
                            a = 1;
                        } else {
                            if(sameParent==1)
                                return false;
                            else
                                return true;
                        }
                    } else {
                        queue.add(curr.left);
                    }
                }
                if(curr.right!=null){
                    if(curr.right.val==x || curr.right.val==y){
                        if(a==0){
                            sameParent = 1;
                            a = 1;
                        } else {
                            if(sameParent==1)
                                return false;
                            else
                                return true;
                        }
                    } else {
                        queue.add(curr.right);
                    }
                }
            }
            levelLength = queue.size();
            if(a==1)
                return false;
        }
        return false;
    }
}
