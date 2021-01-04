/*

 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = rootNode(nums, 0, nums.length-1);
        return root;
    }
    public TreeNode rootNode(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int index = start;
        for(int i = start;i<=end;i++){
            if(nums[i]>nums[index]){
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        if(index>start){
            root.left = rootNode(nums, start, index-1);
            
        }
        if(index<end)
        root.right = rootNode(nums, index+1, end);
        return root;
        
    }
}

