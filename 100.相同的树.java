import java.util.List;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
   
    public boolean isSameTree(TreeNode p, TreeNode q) {
      
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public ArrayList<Integer> preArr(TreeNode root, ArrayList<Integer> p) {
        if (root == null) {
            p.add(-1);
            return p;
        }
        p.add(root.val);
        if (root.left != null)
            preArr(root.left, p);
        if (root.right != null)
            preArr(root.right, p);
        return p;

    }

    public ArrayList<Integer> inArr(TreeNode root, ArrayList<Integer> p) {
        if (root == null) {
            p.add(-1);
            return p;
    }
        if (root.left != null)
            inArr(root.left, p);
       
        p.add(root.val);
        if (root.right != null)
            inArr(root.right, p);
        return p;

    }

}
