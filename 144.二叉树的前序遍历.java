import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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

    public List<Integer> preorderTraversal(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }

        if(root!=null)
        re.add(root.val);
        if(root.left!=null)
        {preorderTraversal(root.left);
        }    
        
        if(root.right!=null)
            preorderTraversal(root.right);
        
        return re;
    }
}

