import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode resu = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return resu;
    }

    public TreeNode build(int[] preorder, int sp, int ep, int[] inorder, int si, int ei) {

        if (sp < 0) {
            return null;
        }
        int root = preorder[sp];
        int rootIndex = 0;
        TreeNode rootNode = new TreeNode(root);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex != si) {
            rootNode.left = build(preorder, sp + 1, sp + rootIndex - si, inorder, si, rootIndex - 1);
        }
        if (rootIndex != ei) {
            rootNode.right = build(preorder, sp + rootIndex - si + 1, ep, inorder, rootIndex + 1, ei);
        }
        return rootNode;
    }
}
