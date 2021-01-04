/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxD(root);
        return result;
    }
    public int maxD(TreeNode root){
        if(root==null)
        return 0;
        int l = maxD(root.left);
        int r = maxD(root.right);
        if(Math.abs(l-r)>1){
            result = false;
        }
        return 1 + Math.max(l, r);
    }
}

