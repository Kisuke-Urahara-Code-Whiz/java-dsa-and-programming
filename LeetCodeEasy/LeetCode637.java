package LeetCodeEasy;

import Programs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode637 extends TreeNode {

    //BFS
    public List<Double> averageOfLevelsBFS(TreeNode root){
        List<Double> list = new ArrayList<>();
        if(root==null){
            System.out.println("No elements to print");
        } else {
            double avg = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int levelSize =  queue.size();
                for(int i=0;i<levelSize;i++){
                    TreeNode node = queue.poll();
                    avg +=node.val;
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
                avg/=levelSize;
                list.add(avg);
                avg = 0;
            }
        }
        return list;
    }
}
