package LeetCodeEasy;

import Programs.TreeNode;

import java.util.*;

public class LeetCode101 extends TreeNode {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelLength = queue.size();
        while(!queue.isEmpty()){
            List<TreeNode> list = new ArrayList<>();
            for(int i=1;i<=levelLength;i++){
                TreeNode curr = queue.poll();
                list.add(curr);
                if(curr!=null){
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            levelLength  = queue.size();
            int p1 = 0;
            int p2 = list.size()-1;
            while(p1<=p2){
                if(list.get(p1)==null){
                    if(list.get(p2)==null){
                        p1+=1;
                        p2-=1;
                    } else {
                        return false;
                    }
                } else {
                    if(list.get(p2)==null)
                        return false;
                    else if(list.get(p1).val!=list.get(p2).val)
                        return false;
                    else{
                        p1+=1;
                        p2-=1;
                    }
                }
            }
        }
        return true;
    }

}
