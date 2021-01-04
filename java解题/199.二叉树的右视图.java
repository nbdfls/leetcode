import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<TreeNode>> wrapList = new LinkedList<>();
        List<Integer> re = new ArrayList<>();
        if(root==null) return re;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> subList = new LinkedList<>();
            while(size>0){
                TreeNode now = queue.element();
                if(now.left!=null) queue.offer(now.left);
                if(now.right!=null) queue.offer(now.right);
                subList.add(now);
                queue.poll();
                size--;
            }
            wrapList.add(subList);
        }
        for(int i = 0;i<wrapList.size();i++){

            re.add(wrapList.get(i).get(wrapList.get(i).size()-1).val);
        }
        return re;
    }
}

