/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * 
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tempRoot = root.left;
        root.left = root.right;
        root.right = tempRoot;
        if(root.left!=null)
        invertTree(root.left);
        if(root.right!=null)
        invertTree(root.right);
        return root;
    }
}

