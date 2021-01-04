import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    List<Integer> re = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        if(root.left!=null){
            postorderTraversal(root.left);
        }
        if(root.right!=null){
            postorderTraversal(root.right);
        }
        if(root!=null)
        re.add(root.val);

        return re;
    }
}

