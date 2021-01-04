import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public int value = 0;
    public List<Integer> vals = new ArrayList<>();
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
       if(root.left==null && root.right==null && root.val == sum)
       return true;
       return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
        

    }

}

